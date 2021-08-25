package br.com.nick.quotation.integration.client;

import br.com.nick.quotation.integration.resource.RegionResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ViaCep", url ="${integration.viacep.url}")
public interface CepClient {

    @GetMapping(value = "/ws/{cep}/json", consumes = "application/json", produces = "application/json")
    RegionResource consultCep(@PathVariable("cep") String cep);
}
