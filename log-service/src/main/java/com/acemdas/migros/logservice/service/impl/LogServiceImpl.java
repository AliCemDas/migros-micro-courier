package com.acemdas.migros.logservice.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import com.acemdas.migros.logservice.dto.LogRequest;
import com.acemdas.migros.logservice.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

import static com.acemdas.migros.logservice.util.LogLevel.*;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final ElasticsearchClient client;

    public void saveLog(LogRequest request) throws IOException {

        String indexName;
        switch (request.getLogLevel()) {
            case COURIER_NOTIFICATION:
                indexName = COURIER_NOTIFICATION.name();
                break;
            case INFO:
                indexName = INFO.name();
                break;
            case ERROR:
                indexName = ERROR.name();
                break;
            case WARN:
                indexName = WARN.name();
                break;
            default:
                indexName = "app-logs";
        }

        client.index(IndexRequest.of(i -> i
                .index(indexName)
                .document(request)));
    }
}
