package com.sametakgul.rest_template_demo.catapi.controller;


import com.sametakgul.rest_template_demo.catapi.model.CatImage;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
public class CatController {

    private final RestTemplate restTemplate;


    @GetMapping("/cat")
    public String getCatImage(@RequestParam(required = false, defaultValue = "1") int limit) {
        String url = "https://api.thecatapi.com/v1/images/search?limit=" + limit;

        CatImage[] catImages = restTemplate.getForObject(url, CatImage[].class);

        if (catImages != null && catImages.length > 0) {
            return catImages[0].getUrl();
        } else {
            return "No cat images found.";
        }
    }

}
