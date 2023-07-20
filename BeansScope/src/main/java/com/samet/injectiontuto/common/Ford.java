package com.samet.injectiontuto.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Ford implements Car{

    public Ford(){
        System.out.println("In Constructor:" +getClass().getSimpleName());
    }
    @Override
    public String brand() {
        return "Ford is the name of brand!!!!!";
    }
}
