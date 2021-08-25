package br.com.nick.quotation.domain.builder;

import br.com.nick.quotation.domain.Multiplier;

public class MultiplierBuilder {

    private Multiplier multiplier;

    public MultiplierBuilder(){
        this.multiplier = new Multiplier();
    }

    public MultiplierBuilder multiplier(float multiplier){
        this.multiplier.setMultiplier(multiplier);
        return this;
    }
}
