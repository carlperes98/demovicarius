package com.es.vicarius.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "meuindice")
public class PH {
    @Id
    private String id;
}
