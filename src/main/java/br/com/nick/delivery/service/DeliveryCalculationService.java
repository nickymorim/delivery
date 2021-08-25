package br.com.nick.quotation.service;

import br.com.nick.quotation.domain.DeliveryCalculation;

public interface DeliveryCalculationService {

    public DeliveryCalculation calculate(String cep);
}
