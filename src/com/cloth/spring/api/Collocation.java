package com.cloth.spring.api;

public interface Collocation {
    int getCoatNum();
    int getUnderwearNum();
    int getSweaterNum();
    float getClothNum();

    int getOuterwearNum();
    int getInnerwearNum();

    float getWeatherMaxTemp();
    float getWeatherMinTemp();
    float getWeatherTempDifference();

    float getClothSupportMaxTemp();
    float getClothSupportMinTemp();
}
