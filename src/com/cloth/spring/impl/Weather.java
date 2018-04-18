package com.cloth.spring.impl;

public class Weather {
    private float maxTemp;
    private float minTemp;

    public Weather(float min, float max){
        this.maxTemp = max;
        this.minTemp = min;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public float getMinTemp() {
        return minTemp;
    }
}
