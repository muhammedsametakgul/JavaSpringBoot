package com.sametakgul.rest_template_demo.newsapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Value("${newsapi.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public NewsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getTopHeadlines(String country) {
        String url = "https://newsapi.org/v2/top-headlines?country=" + country + "&apiKey=" + apiKey;

        return restTemplate.getForObject(url, String.class);
    }
}