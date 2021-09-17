package com.swf.playground;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

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
    public String postSum(MathService mathService, WebRequest webRequest, @RequestParam List<String> n) {
        mathService.setWebRequest(webRequest);
        mathService.setOperation("sum");  // There must be a better way.
        return mathService.toString();
    }

    @RequestMapping("/volume/{length}/{width}/{height}")
//    public String requestVolume(@RequestParam Map<String, String> params) {
        public String requestVolume(@PathVariable int length, @PathVariable int width, @PathVariable int height) {
//        int length = Integer.valueOf(params.get("length"));
//        int width = Integer.valueOf(params.get("width"));
//        int height = Integer.valueOf(params.get("height"));
        return MathService.buildVolumeMathService(length, width, height).toString();

    }

    @RequestMapping("/area")
    public String requestArea(MathArea mathArea) {
        MathService mathService = new MathService(mathArea);
        return mathArea.toString();
    }
}
