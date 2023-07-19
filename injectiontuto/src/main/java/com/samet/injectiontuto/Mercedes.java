package com.samet.injectiontuto;

import org.springframework.stereotype.Component;

@Component
public class Mercedes implements  Car{
    @Override
    public String brand() {
        return "Mercedes is  the name of brand";
    }
}
