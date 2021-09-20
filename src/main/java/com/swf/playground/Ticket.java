package com.swf.playground;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticket {

    @JsonProperty("Passenger")
    private Person passenger;

    @JsonProperty("Price")
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getPassenger() {
        return passenger;
    }

    public void setPassenger(Person passenger) {
        this.passenger = passenger;
    }
}
