package br.com.seteideias.consultacep.api.controller;

import br.com.seteideias.consultacep.api.controller.request.CepDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1")
public class PrincipalController {

    @GetMapping("/cep/{id}")
    public ResponseEntity<CepDto> findCep(@PathVariable("id") String id) {

        RestTemplate restTemplate = new RestTemplate();
        String uri = String.format("http://www.viacep.com.br/ws/%s/json/", id);
        return restTemplate.getForEntity(uri, CepDto.class);
    }

}
