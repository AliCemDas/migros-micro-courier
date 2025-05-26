package com.acemdas.migros.locationservice.event;

import com.acemdas.migros.locationservice.dto.CourierLocationDto;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CourierLocationEvent extends ApplicationEvent {

    private final CourierLocationDto location;

    public CourierLocationEvent(Object source, CourierLocationDto location) {
        super(source);
        this.location = location;
    }
}
