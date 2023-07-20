package com.samet.injectiontuto.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Bmw implements Car{




    public Bmw(){
        System.out.println("In Constructor:" +getClass().getSimpleName());
    }

    @Override
    public String brand() {
        return "Bmw is the name of brand!!!!!";
    }
}
