package com.cloth.spring.impl;


import com.cloth.spring.api.Cloth;
import com.cloth.spring.api.Collocation;

import java.util.List;

public class CollocationImpl implements Collocation{
    private List<Cloth> clothList;
    private Weather weather;

    public CollocationImpl(List<Cloth> clothList, Weather weather){
        this.clothList = clothList;
        this.weather = weather;
    }

    @Override
    public int getCoatNum() {
        int coatNum = 0;
        for(Cloth cloth: this.clothList){
            if(cloth instanceof Coat){
                coatNum += 1;
            }
        }
        return coatNum;
    }

    @Override
    public int getUnderwearNum() {
        int underwearNum = 0;
        for(Cloth cloth: this.clothList){
            if(cloth instanceof Underwear){
                underwearNum += 1;
            }
        }
        return underwearNum;
    }

    @Override
    public int getSweaterNum() {
        int sweaterNum = 0;
        for(Cloth cloth: this.clothList){
            if(cloth instanceof Sweater){
                sweaterNum += 1;
            }
        }
        return sweaterNum;
    }

    @Override
    public float getClothNum() {
        return this.clothList.size();
    }

    @Override
    public int getOuterwearNum() {
        int outerwearNum = 0;
        for(Cloth cloth: this.clothList){
            if(cloth.canBeOuterWear()){
                outerwearNum += 1;
            }
        }
        return outerwearNum;
    }

    @Override
    public int getInnerwearNum() {
        int innerwearNum = 0;
        for(Cloth cloth: this.clothList){
            if(cloth.canBeInnerWear()){
                innerwearNum += 1;
            }
        }
        return innerwearNum;
    }

    public List<Cloth> getClothList() {
        return clothList;
    }

    @Override
    public float getWeatherMaxTemp() {
        return this.weather.getMaxTemp();
    }

    @Override
    public float getWeatherMinTemp() {
        return this.weather.getMinTemp();
    }

    @Override
    public float getWeatherTempDifference() {
        return this.weather.getMaxTemp() - this.weather.getMinTemp();
    }

    @Override
    public float getClothSupportMaxTemp() {
        float supportMaxTemp = - Float.MAX_VALUE;
        for(Cloth cloth: this.clothList){
            if(cloth.getSupportHighTemperature() > supportMaxTemp){
                supportMaxTemp = cloth.getSupportHighTemperature();
            }
        }
        return supportMaxTemp;
    }

    @Override
    public float getClothSupportMinTemp() {
        float supportMinTemp = Float.MAX_VALUE;
        for(Cloth cloth: this.clothList){
            if(cloth.getSupportLowTemperature() < supportMinTemp){
                supportMinTemp = cloth.getSupportLowTemperature();
            }
        }
        return supportMinTemp;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(100);
        for(Cloth cloth: this.clothList){
            builder.append(cloth.getName());
            builder.append("+");
        }
        String output = builder.toString();
        if(output.endsWith("+")){
            return output.substring(0, output.length() - 1);
        }
        return output;
    }
}
