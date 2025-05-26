package com.acemdas.migros.logservice.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LogLevel {
    COURIER_NOTIFICATION,
    INFO,
    ERROR,
    WARN
}
