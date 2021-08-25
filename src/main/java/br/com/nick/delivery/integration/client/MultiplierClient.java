package br.com.nick.quotation.integration.client;

import br.com.nick.quotation.integration.resource.MultipliersResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Multipliers", url ="${integration.multipliers.url}")
public interface MultiplierClient {

    @GetMapping(value = "/${integration.multipliers.id}", consumes = "application/json", produces = "application/json")
    MultipliersResource consultMultiplier();
}
