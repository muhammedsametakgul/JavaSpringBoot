package com.samet.injectiontuto.common;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Bmw implements Car{

    public Bmw(){
        System.out.println("In Constructor:" +getClass().getSimpleName());
    }

    @Override
    public String brand() {
        return "Bmw is the name of brand!!!!!";
    }
}
