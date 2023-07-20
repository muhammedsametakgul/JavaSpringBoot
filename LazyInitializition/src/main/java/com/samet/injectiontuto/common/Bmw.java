package com.samet.injectiontuto.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Bmw implements Car{

    public Bmw(){
        System.out.println("In Constructor:" +getClass().getSimpleName());
    }
    @Override
    public String brand() {
        return "Bmw is the name of brand!!!!!";
    }
}
