package com.cloth.spring.api;

public abstract class Cloth {
    float supportLowTemperature;
    float supportHighTemperature;
    String name;

    public Cloth(float low, float high, String name){
        this.supportLowTemperature = low;
        this.supportHighTemperature = high;
        this.name = name;
    }

    public abstract boolean canBeOuterWear();
    public abstract boolean canBeInnerWear();
    public abstract boolean isOuterWear();
    public abstract boolean isInnerWear();

    public float getSupportLowTemperature() {
        return supportLowTemperature;
    }

    public void setSupportLowTemperature(float supportLowTemperature) {
        this.supportLowTemperature = supportLowTemperature;
    }

    public float getSupportHighTemperature() {
        return supportHighTemperature;
    }

    public void setSupportHighTemperature(float supportHighTemperature) {
        this.supportHighTemperature = supportHighTemperature;
    }

    public String getName() {
        return name;
    }
}
