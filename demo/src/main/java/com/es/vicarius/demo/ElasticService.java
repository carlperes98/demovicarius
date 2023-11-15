package com.es.vicarius.demo;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class ElasticService {

    @Autowired
    private RestHighLevelClient client;

    public String createIndex(String index) throws IOException {
        return "Index created successfully: " + index;
    }

    public String createDocument(String index, Map<String, Object> document) throws IOException {
        String id = createDocumentWithID(index, document);
        return "Document created successfully in index " + index + " with ID: " + id;
    }

    public String createDocumentWithID(String index, Map<String, Object> document) throws IOException {
        IndexRequest request = new IndexRequest(index);
        request.source(document, XContentType.JSON);

        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        return response.getId();
    }

    public Map<String, Object> viewDocument(String index, String id) throws IOException {
        GetRequest getRequest = new GetRequest(index, id);
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        return getResponse.getSourceAsMap();
    }
}
