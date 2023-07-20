package com.samet.injectiontuto;

import com.samet.injectiontuto.common.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Car myBrand;
    private Car anotherBrand;

    @Autowired
    public DemoController(@Qualifier("bmw") Car brand,
                          @Qualifier("bmw") Car theAnotherBrand
                          ){
        System.out.println("In Constructor:" +getClass().getSimpleName());

        myBrand=brand;
        anotherBrand=theAnotherBrand;
    }


    @GetMapping("/car")
    public String getBrand(){
        return myBrand.brand();
    }


    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myBrand == anotherBrand, "+ (myBrand==anotherBrand);
    }

}
