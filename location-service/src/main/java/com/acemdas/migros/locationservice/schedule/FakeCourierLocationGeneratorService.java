package com.acemdas.migros.locationservice.schedule;

import com.acemdas.migros.locationservice.dto.CourierLocationDto;
import com.acemdas.migros.locationservice.event.publisher.CourierLocationEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class FakeCourierLocationGeneratorService {

    private final CourierLocationEventPublisher eventPublisher;
    private final Random random = new Random();

    @Scheduled(fixedRate = 10000) // her 5 saniyede bir çalışır
    public void generateLocation() {
        CourierLocationDto dto = new CourierLocationDto();
        dto.setCourierId(1L);
        dto.setXCoordinate(randomLatitude());
        dto.setYCoordinate(randomLongitude());
        dto.setEnteredAt(LocalDateTime.now());

        eventPublisher.publish(dto);
    }

    private double randomLatitude() {
        return 41.0 + random.nextDouble() * 0.01;
    }

    private double randomLongitude() {
        return 29.0 + random.nextDouble() * 0.01;
    }
}
