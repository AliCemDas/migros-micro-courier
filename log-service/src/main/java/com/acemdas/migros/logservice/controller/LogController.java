package com.acemdas.migros.logservice.controller;

import com.acemdas.migros.logservice.dto.LogRequest;
import com.acemdas.migros.logservice.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;


@RequestMapping("/logs")
@RestController
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;

    @PostMapping
    public void saveLog(@RequestBody LogRequest request) throws IOException {
        logService.saveLog(request);
    }
}