package br.com.nick.quotation.service.impl;

import br.com.nick.quotation.domain.DeliveryCalculation;
import br.com.nick.quotation.integration.client.CepClient;
import br.com.nick.quotation.integration.client.MultiplierClient;
import br.com.nick.quotation.integration.resource.MultipliersResource;
import br.com.nick.quotation.integration.resource.RegionResource;
import br.com.nick.quotation.service.DeliveryCalculationService;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DeliveryCalculationServiceImpl implements DeliveryCalculationService {

    private final CepClient cepClient;

    private final MultiplierClient multiplierClient;

    public DeliveryCalculationServiceImpl(CepClient cepClient, MultiplierClient multiplierClient) {
        this.cepClient = cepClient;
        this.multiplierClient = multiplierClient;
    }

    @Override
    public DeliveryCalculation calculate(String cep) {
        RegionResource regionResource = getRegionFromCep(cep);
        MultipliersResource multipliersResource = getMultipliers();
        Map<String, Double> multipliers = multipliersResource.getMultipliers();
        RegionServiceImpl regionService = new RegionServiceImpl();

        if (regionResource.getUf() != null) {
            Double multiplier = multipliers.getOrDefault(regionResource.getUf(), 0.0);

            double freight = (10 + 2.4) * multiplier;
            DeliveryCalculation deliveryCalculation = new DeliveryCalculation();
            deliveryCalculation.setAddress(regionService.addressBuilder(regionResource));
            deliveryCalculation.setFreight(freight);
            return deliveryCalculation;
        } else {
            throw new RuntimeException("Não foi possível consultar a região. Erro ao gerar o frete");
        }
    }

    private RegionResource getRegionFromCep(String cep) {
        try {
            return cepClient.consultCep(cep);
        } catch (FeignException ex) {
            throw new RuntimeException("Erro ao consultar o CEP indicado");
        }
    }

    private MultipliersResource getMultipliers() {
        try {
            return multiplierClient.consultMultiplier();
        } catch (FeignException ex) {
            throw new RuntimeException("Erro ao consultar os multipliers");
        }
    }
}
