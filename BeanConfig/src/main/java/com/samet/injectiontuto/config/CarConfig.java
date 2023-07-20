package com.samet.injectiontuto.config;

import com.samet.injectiontuto.common.Car;
import com.samet.injectiontuto.common.RangeRover;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {

    @Bean("rangerovercar")//the statement between "" represent the id of our bean
    public Car rangeRover(){
        return  new RangeRover();
    }
}
