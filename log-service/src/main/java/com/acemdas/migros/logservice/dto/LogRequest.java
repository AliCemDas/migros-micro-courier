package com.acemdas.migros.logservice.dto;


import com.acemdas.migros.logservice.util.LogLevel;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogRequest {
    private String service;
    private String message;
    private String timestamp;
    private LogLevel logLevel;
}
