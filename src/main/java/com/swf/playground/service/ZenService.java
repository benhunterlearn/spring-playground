package com.swf.playground.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZenService {
    private final RestTemplate restTemplate = new RestTemplate();

    public String getZen() {
        return this.restTemplate.getForObject(
                "https://api.github.com/zen",
                String.class
        );
    }
}
