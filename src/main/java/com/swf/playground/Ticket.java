package com.swf.playground;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

public class Ticket {

	@JsonView(Views.DetailedView.class)
	@JsonProperty("Passenger")
	private Person passenger;

	@JsonView(Views.ShortView.class)
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
