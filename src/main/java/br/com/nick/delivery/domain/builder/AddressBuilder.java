package br.com.nick.quotation.domain.builder;

import br.com.nick.quotation.domain.Address;

public class AddressBuilder {

	private Address address;

	public AddressBuilder() {
		this.address = new Address();
	}

	public AddressBuilder cep(String cep) {
		this.address.setCep(cep);
		return this;
	}

	public AddressBuilder street(String street) {
		this.address.setStreet(street);
		return this;
	}

	public AddressBuilder complement(String complement) {
		this.address.setComplement(complement);
		return this;
	}

	public AddressBuilder district(String district) {
		this.address.setDistrict(district);
		return this;
	}

	public AddressBuilder location(String location) {
		this.address.setLocation(location);
		return this;
	}

	public AddressBuilder uf(String uf) {
		this.address.setUf(uf);
		return this;
	}

	public Address build() {
		return this.address;
	}
}
