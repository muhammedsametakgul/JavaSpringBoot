package com.sametakgul.rest_template_demo.newsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public String getTopHeadlines(@RequestParam(defaultValue = "tr") String country) {
        return newsService.getTopHeadlines(country);
    }
}