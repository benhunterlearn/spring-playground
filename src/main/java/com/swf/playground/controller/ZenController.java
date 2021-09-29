package com.swf.playground.controller;

import com.swf.playground.service.ZenService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zen")
public class ZenController {
    ZenService zenService;

    public ZenController(ZenService zenService) {
        this.zenService = zenService;
    }

    @RequestMapping("")
    public String zen() {
        return this.zenService.getZen();
    }
}
