package com.es.vicarius.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private ElasticService elasticService;

    @PostMapping("/create-index")
    public String createIndex(@RequestParam String index) throws IOException {
        return elasticService.createIndex(index);
    }

    @PostMapping("/create-document")
    public String createDocument(@RequestParam String index, @RequestBody Map<String, Object> document) throws IOException {
        return elasticService.createDocument(index, document);
    }

    @GetMapping("/view-document")
    public Map<String, Object> viewDocument(@RequestParam String index, @RequestParam String id) throws IOException {
        return elasticService.viewDocument(index, id);
    }
}
