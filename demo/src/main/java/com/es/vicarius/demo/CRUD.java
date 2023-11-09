package com.es.vicarius.demo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CRUD extends ElasticsearchRepository<PH, String> {
}
