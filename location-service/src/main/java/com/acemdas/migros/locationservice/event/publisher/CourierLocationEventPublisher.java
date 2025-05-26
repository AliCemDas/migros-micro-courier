package com.acemdas.migros.locationservice.event.publisher;

import com.acemdas.migros.locationservice.dto.CourierLocationDto;
import com.acemdas.migros.locationservice.event.CourierLocationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourierLocationEventPublisher {

    private final ApplicationEventPublisher publisher;

    public void publish(CourierLocationDto dto) {
        CourierLocationEvent event = new CourierLocationEvent(this, dto);
        publisher.publishEvent(event);
    }
}
