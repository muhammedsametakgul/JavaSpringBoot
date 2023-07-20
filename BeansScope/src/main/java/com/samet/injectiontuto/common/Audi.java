package com.samet.injectiontuto.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Audi implements  Car{

    public Audi(){
        System.out.println("In Constructor:" +getClass().getSimpleName());
    }

    @Override
    public String brand() {
        return "Audi is the name of brand!!!!!";
    }
}
