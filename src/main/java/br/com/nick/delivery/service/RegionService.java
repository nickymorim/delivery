package br.com.nick.quotation.service;


import br.com.nick.quotation.domain.Address;
import br.com.nick.quotation.integration.resource.RegionResource;

public interface RegionService {

    public Address addressBuilder(RegionResource regionResource);
}
