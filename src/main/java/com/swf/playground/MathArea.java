package com.swf.playground;

public class MathArea {
    private String type;
    private Integer radius;
    private Integer width;
    private Integer height;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {

        if (this.type.equals("rectangle") && this.width == null && this.height == null) {
            return "Invalid";
        } else if (this.type.equals("circle") && this.radius == null) {
            return "Invalid";
        }

        String result = "";
        StringBuilder output = new StringBuilder();
        output.append("Area of a ");
        if (this.type.equals("circle")) {
            result = String.format("%.5f", this.radius * this.radius * Math.PI);
            output.append(String.format("circle with a radius of %d is %s", this.radius, result));
        } else if (this.type.equals("rectangle")) {
            result = String.valueOf(this.width * this.height);
            output.append(String.format("%dx%d rectangle is %s", this.width, this.height, result));
        }
        return output.toString();
    }
}