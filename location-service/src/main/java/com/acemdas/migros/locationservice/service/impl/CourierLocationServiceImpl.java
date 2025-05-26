package com.acemdas.migros.locationservice.service.impl;

import com.acemdas.migros.locationservice.client.CourierClient;
import com.acemdas.migros.locationservice.client.LogClient;
import com.acemdas.migros.locationservice.client.StoreClient;
import com.acemdas.migros.locationservice.dto.*;
import com.acemdas.migros.locationservice.entity.CourierLocation;
import com.acemdas.migros.locationservice.entity.CourierLocationHistory;
import com.acemdas.migros.locationservice.mapper.CourierLocationMapper;
import com.acemdas.migros.locationservice.repository.CourierLocationHistoryRepository;
import com.acemdas.migros.locationservice.repository.CourierLocationRepository;
import com.acemdas.migros.locationservice.service.CourierLocationService;
import com.acemdas.migros.locationservice.util.DistanceUtil;
import com.acemdas.migros.locationservice.util.LogLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourierLocationServiceImpl implements CourierLocationService {

    private final CourierLocationRepository courierLocationRepository;
    private final CourierLocationMapper mapper;
    private final CourierClient courierClient;
    private final StoreClient storeClient;
    private final LogClient logClient;
    private final CourierLocationHistoryRepository courierLocationHistoryRepository;
    private final Map<Long, Map<Long, LocalDateTime>> lastEntryTimes = new ConcurrentHashMap<>();


    @Override
    public CourierLocationResponseDto saveLocation(CourierLocationRequestDto dto) {
        CourierLocation entity = CourierLocation.builder()
                .courierId(dto.getCourierId())
                .timestamp(dto.getTimestamp())
                .xCoordinate(dto.getxCoordinate())
                .yCoordinate(dto.getyCoordinate())
                .build();
        CourierLocation saved = courierLocationRepository.save(entity);
        return CourierLocationResponseDto.builder()
                .id(saved.getId())
                .courierId(saved.getCourierId())
                .timestamp(saved.getTimestamp())
                .xCoordinate(saved.getXCoordinate())
                .yCoordinate(saved.getYCoordinate())
                .build();
    }

    @Override
    public List<CourierLocationResponseDto> getLocationsByCourierId(Long courierId) {
        List<CourierLocation> locations = courierLocationRepository.findByCourierIdOrderByTimestampAsc(courierId);
        return mapper.toResponseDtoList(locations);
    }

    @Override
    public void processCourierLocation(CourierLocationDto locationDto) {

        // 1. Courier information is received (for control purposes only)
        CourierResponseDto courier = courierClient.getCourierById(locationDto.getCourierId());
        if (courier == null || !courier.getStatus()) {
            logClient.sendLog(LogRequest.builder()
                    .service("location-service")
                    .logLevel(LogLevel.ERROR)
                    .message(String.format(
                            "Inactive or missing courier: {}", locationDto.getCourierId()))
                    .build());
            return;
        }

        // Get the Store List
        List<StoreResponseDTO> stores = storeClient.getAllActiveStores();

        if (CollectionUtils.isEmpty(stores)) {
            logClient.sendLog(LogRequest.builder()
                    .service("location-service")
                    .logLevel(LogLevel.ERROR)
                    .message("No active store listing found !")
                    .build());
        }

        LocalDateTime now = locationDto.getEnteredAt();
        double courierX = locationDto.getXCoordinate();
        double courierY = locationDto.getYCoordinate();

        for (StoreResponseDTO store : stores) {
            double distance = DistanceUtil.calculateDistance(courierX, courierY, store.getXCoordinate(), store.getYCoordinate());

            if (distance <= 100) {
                // The courier's last entry time is checked
                Long courierId = locationDto.getCourierId();
                Long storeId = store.getId();

                lastEntryTimes.putIfAbsent(courierId, new ConcurrentHashMap<>());
                LocalDateTime lastEntry = lastEntryTimes.get(courierId).get(storeId);


                if (lastEntry == null || Duration.between(lastEntry, now).toMinutes() >= 1) {
                    lastEntryTimes.get(courierId).put(storeId, now);

                    // 4. Log yazılır
                    CourierLocationHistory history = CourierLocationHistory.builder()
                            .xCoordinate(locationDto.getXCoordinate())
                            .yCoordinate(locationDto.getYCoordinate())
                            .courierId(locationDto.getCourierId())
                            .storeId(storeId)
                            .enteredAt(now)
                            .build();

                    courierLocationHistoryRepository.save(history);

                    logClient.sendLog(LogRequest.builder()
                            .service("location-service")
                            .logLevel(LogLevel.COURIER_NOTIFICATION)
                            .message(String.format("Courier {} entered the store {}", courierId, storeId))
                            .build());
                }
            }
        }

        CourierLocation courierLocation = CourierLocation.builder()
                .courierId(locationDto.getCourierId())
                .xCoordinate(locationDto.getXCoordinate())
                .yCoordinate(locationDto.getYCoordinate())
                .timestamp(now)
                .build();

        courierLocationRepository.save(courierLocation);
    }
}
