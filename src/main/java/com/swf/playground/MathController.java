package com.swf.playground;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping(value = {"/", ""})
    public String emptyMathRequest() {
        return "Welcome to Math!";
    }

    @GetMapping("/calculate")
    public String getCalculate(MathService mathService) {
        return mathService.toString();
    }

    @PostMapping("/sum")
    public String postSum(MathService mathService) {
        mathService.setOperation("sum");
        return mathService.toString();


    }
}
