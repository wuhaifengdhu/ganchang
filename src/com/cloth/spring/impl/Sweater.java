package com.cloth.spring.impl;

import com.cloth.spring.api.Cloth;

public class Sweater extends Cloth{
    public Sweater(float low, float high, String name) {
        super(low, high, name);
    }

    @Override
    public boolean canBeOuterWear() {
        return true;
    }

    @Override
    public boolean canBeInnerWear() {
        return true;
    }

    @Override
    public boolean isOuterWear() {
        return false;
    }

    @Override
    public boolean isInnerWear() {
        return false;
    }
}
