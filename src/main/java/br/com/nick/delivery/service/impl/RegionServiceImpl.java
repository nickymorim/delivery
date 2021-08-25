package br.com.nick.quotation.service.impl;

import br.com.nick.quotation.domain.Address;
import br.com.nick.quotation.integration.client.CepClient;
import br.com.nick.quotation.integration.resource.RegionResource;
import br.com.nick.quotation.service.RegionService;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {

    public RegionServiceImpl(){
    }

    @Override
    public Address addressBuilder(RegionResource regionResource){
        Address address = new Address();
        address.setDistrict(regionResource.getBairro());
        address.setCep(regionResource.getCep());
        address.setComplement(regionResource.getComplemento());
        address.setLocation(regionResource.getLocalidade());
        address.setStreet(regionResource.getLogradouro());
        address.setUf(regionResource.getUf());

        return address;

    }
}
