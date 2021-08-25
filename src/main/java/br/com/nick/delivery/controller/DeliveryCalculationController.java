package br.com.nick.quotation.controller;

import br.com.nick.quotation.domain.DeliveryCalculation;
import br.com.nick.quotation.service.DeliveryCalculationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryCalculationController {

    private final DeliveryCalculationService deliveryCalculationService;

    public DeliveryCalculationController(DeliveryCalculationService deliveryCalculationService) {
        this.deliveryCalculationService = deliveryCalculationService;
    }

    @GetMapping("/deliveryCalculation")
    public DeliveryCalculation getDelivery(@RequestParam String cep) {
        return deliveryCalculationService.calculate(cep);
    }
}
