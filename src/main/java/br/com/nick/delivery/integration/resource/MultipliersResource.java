package br.com.nick.quotation.integration.resource;
import java.util.Map;

public class MultipliersResource {

    private Map<String, Double> multipliers;

    public Map<String, Double> getMultipliers() {
        return multipliers;
    }

    public void setMultipliers(Map<String, Double> multipliers) {
        this.multipliers = multipliers;
    }
}
