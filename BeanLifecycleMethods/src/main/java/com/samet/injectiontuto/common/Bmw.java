package com.samet.injectiontuto.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class Bmw implements Car{

    //define a startup method
    @PostConstruct
    public void doStartup(){
        System.out.println("In doStartup() : "+ getClass().getSimpleName());
        //it will appear when we run the application
    }


    //define a destroy method
    @PreDestroy
    public void doCleanup(){
        System.out.println("In doCleanup() : "+ getClass().getSimpleName());
        //it will appear when we stop running our application
    }



    public Bmw(){
        System.out.println("In Constructor:" +getClass().getSimpleName());
    }

    @Override
    public String brand() {
        return "Bmw is the name of brand!!!!!";
    }
}
