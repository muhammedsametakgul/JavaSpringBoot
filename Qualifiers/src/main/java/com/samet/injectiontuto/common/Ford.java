package com.samet.injectiontuto.common;

import org.springframework.stereotype.Component;

@Component
public class Ford implements Car{
    @Override
    public String brand() {
        return "Ford is the name of brand!!!!!";
    }
}
