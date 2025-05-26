package com.acemdas.migros.locationservice.event.listener;

import com.acemdas.migros.locationservice.dto.CourierLocationDto;
import com.acemdas.migros.locationservice.event.CourierLocationEvent;
import com.acemdas.migros.locationservice.service.CourierLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourierLocationEventListener {

    private final CourierLocationService courierLocationService;

    @EventListener
    public void handleCourierLocationEvent(CourierLocationEvent event) {
        CourierLocationDto dto = event.getLocation();
        courierLocationService.processCourierLocation(dto);
    }
}