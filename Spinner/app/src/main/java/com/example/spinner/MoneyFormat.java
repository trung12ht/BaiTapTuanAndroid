package com.example.spinner;

import java.io.Serializable;

public class MoneyFormat implements Serializable {
    private String name;
    private Double factor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFactor() {
        return factor;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }

    public MoneyFormat(String name, Double factor) {
        this.name = name;
        this.factor = factor;
    }

    @Override
    public String toString() {
        return name;
    }
}
