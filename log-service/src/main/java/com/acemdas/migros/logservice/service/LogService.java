package com.acemdas.migros.logservice.service;

import com.acemdas.migros.logservice.dto.LogRequest;

import java.io.IOException;
import java.util.Map;

public interface LogService {

    public void saveLog(LogRequest request) throws IOException;
}
