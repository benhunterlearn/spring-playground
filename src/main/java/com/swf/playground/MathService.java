package com.swf.playground;

import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

public class MathService {

    private String operation;

    // x and y for the calculate operation
    private String x;
    private String y;

    // n for the sum operation
    private List<String> n;

    // length, width, height for the volume operation
    private int length;
    private int width;
    private int height;

    // for area calculations
    private MathArea mathArea;

    private WebRequest webRequest;  // not set by Spring Web MVC POJO mapping.
    private Map<String, String> querystring;

    public MathService() {
        // Default constructor needed for Spring Web MVC.
    }

    public MathService(String operation, int length, int width, int height) {
        this.operation = operation;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public MathService(MathArea mathArea) {
        this.mathArea = mathArea;
    }

    public static MathService buildVolumeMathService(int length, int width, int height) {
        return new MathService("volume", length, width, height);
    }

    @Override
    public String toString() {

        if (mathArea != null) {
            return mathArea.toString();
        }
        if (operation == null) {
            if (x != null && y != null) {
                operation = "add";
            } else if (n != null) {
                operation = "sum";
            }
        }

        int intX = 0;
        int intY = 0;
        if (x != null && y != null) {
            intX = Integer.valueOf(x);
            intY = Integer.valueOf(y);
        }

        int result;
        String output = "";
        if (operation.equals("add")) {
            result = intX + intY;
            output = x + " + " + y + " = " + result;
        } else if (operation.equals("subtract")) {
            result = intX - intY;
            output = x + " - " + y + " = " + result;
        } else if (operation.equals("multiply")) {
            result = intX * intY;
            output = x + " * " + y + " = " + result;
        } else if (operation.equals("divide")) {
            result = intX / intY;
            output = x + " / " + y + " = " + result;
        } else if (operation.equals("sum")) {
            return sum();
        } else if (operation.equals("volume")) {
            return volume();
        }

        return output;
    }

    private String sum() {

        int result = 0;
        for (String operand : n) {
            result += Integer.valueOf(operand);
        }

        StringBuilder output = new StringBuilder();
        output.append(String.join(" + ", n));
        output.append(" = " + result);

        return output.toString();
    }

    private String volume() {
        int result = length * width * height;
        return String.format("The volume of a %dx%dx%d rectangle is %d", length, width, height, result);
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public List<String> getN() {
        return n;
    }

    public void setN(List<String> n) {
        this.n = n;
    }

    public Map<String, String> getQuerystring() {
        return querystring;
    }

    public void setQuerystring(Map<String, String> querystring) {
        this.querystring = querystring;
    }

    public WebRequest getWebRequest() {
        return webRequest;
    }

    public void setWebRequest(WebRequest webRequest) {
        this.webRequest = webRequest;
    }
}
