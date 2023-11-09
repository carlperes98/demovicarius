package com.es.vicarius.demo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeuModeloRepository extends ElasticsearchRepository<PH, String> {
}
