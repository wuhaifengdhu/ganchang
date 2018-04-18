package com.cloth.spring.impl;

import com.cloth.spring.api.Cloth;

public class Coat extends Cloth{

    public Coat(float low, float high, String name) {
        super(low, high, name);
    }

    @Override
    public boolean canBeOuterWear() {
        return true;
    }

    @Override
    public boolean canBeInnerWear() {
        return false;
    }

    @Override
    public boolean isOuterWear() {
        return true;
    }

    @Override
    public boolean isInnerWear() {
        return false;
    }
}
