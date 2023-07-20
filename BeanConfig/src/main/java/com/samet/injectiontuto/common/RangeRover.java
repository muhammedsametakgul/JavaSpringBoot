package com.samet.injectiontuto.common;

public class RangeRover implements Car{

    public RangeRover(){
        System.out.println("In Consructor: " + getClass().getSimpleName());
    }

    @Override
    public String brand() {
        return "Range rover is the name of brand!!!!!!!!!";
    }
}
