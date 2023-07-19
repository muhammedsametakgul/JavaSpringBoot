package com.samet.injectiontuto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    public Car myBrand;

    @Autowired
    public void setBrand(Car brand){
        myBrand=brand;
    }


    @GetMapping("/car")
    public String getBrand(){
        return myBrand.brand();
    }


}
