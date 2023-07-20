package com.samet.injectiontuto;

import com.samet.injectiontuto.common.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    public Car myBrand;

    @Autowired
    public DemoController(@Qualifier("bmw") Car brand){
        System.out.println("In Constructor:" +getClass().getSimpleName());

        myBrand=brand;
    }


    @GetMapping("/car")
    public String getBrand(){
        return myBrand.brand();
    }



}
