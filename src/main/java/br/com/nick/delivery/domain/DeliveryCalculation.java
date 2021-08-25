package br.com.nick.quotation.domain;

public class DeliveryCalculation {

    private Address address;
    private double freight;

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
