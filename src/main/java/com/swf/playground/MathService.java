package com.swf.playground;

import java.util.List;

public class MathService {

    private String operation;
    private String x;
    private String y;
    private List<String> n;

    public MathService(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {

        if (operation == null) {
            operation = "add";
        }

        int intX = 0;
        int intY = 0;
        if (n == null) {
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
            output = sum();
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
}
