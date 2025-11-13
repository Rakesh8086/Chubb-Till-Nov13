package com.smartship.model;


public class Route {
    private String fromCity;
    private String toCity;

    public Route(String fromCity, String toCity) {
        this.fromCity = fromCity;
        this.toCity = toCity;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    @Override
    public String toString() {
        return fromCity + " TO " + toCity;
    }
}
