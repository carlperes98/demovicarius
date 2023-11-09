// ElasticService

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

    public String criarIndice(String indice) throws IOException {
        return "Índice criado com sucesso: " + indice;
    }

    public String criarDocumento(String indice, Map<String, Object> documento) throws IOException {
        String id = criarDocumentoComID(indice, documento);
        return "Documento criado com sucesso no índice " + indice + " com ID: " + id;
    }

    public String criarDocumentoComID(String indice, Map<String, Object> documento) throws IOException {
        IndexRequest request = new IndexRequest(indice);
        request.source(documento, XContentType.JSON);

        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        return response.getId();
    }

    public Map<String, Object> visualizarDocumento(String indice, String id) throws IOException {
        GetRequest getRequest = new GetRequest(indice, id);
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        return getResponse.getSourceAsMap();
    }
}
