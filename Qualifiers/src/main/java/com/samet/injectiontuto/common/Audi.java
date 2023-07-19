package com.samet.injectiontuto.common;

import org.springframework.stereotype.Component;

@Component
public class Audi implements  Car{
    @Override
    public String brand() {
        return "Audi is the name of brand!!!!!";
    }
}
