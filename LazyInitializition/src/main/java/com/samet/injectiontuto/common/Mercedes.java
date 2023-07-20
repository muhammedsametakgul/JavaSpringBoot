package com.samet.injectiontuto.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Mercedes implements  Car{

    public Mercedes(){
        System.out.println("In Constructor:" +getClass().getSimpleName());
    }
    @Override
    public String brand() {
        return "Mercedes is  the name of brand";
    }
}
