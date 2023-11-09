

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

    @PostMapping("/criar-indice")
    public String criarIndice(@RequestParam String indice) throws IOException {
        return elasticService.criarIndice(indice);
    }

    @PostMapping("/criar-documento")
    public String criarDocumento(@RequestParam String indice, @RequestBody Map<String, Object> documento) throws IOException {
        return elasticService.criarDocumento(indice, documento);
    }

    @GetMapping("/visualizar-documento")
    public Map<String, Object> visualizarDocumento(@RequestParam String indice, @RequestParam String id) throws IOException {
        return elasticService.visualizarDocumento(indice, id);
    }
}
