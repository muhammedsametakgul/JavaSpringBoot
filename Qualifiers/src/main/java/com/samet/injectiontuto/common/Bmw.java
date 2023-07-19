package com.samet.injectiontuto.common;

import org.springframework.stereotype.Component;

@Component
public class Bmw implements Car{
    @Override
    public String brand() {
        return "Bmw is the name of brand!!!!!";
    }
}
