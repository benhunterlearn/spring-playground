package com.swf.playground.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.swf.playground.view.Views;

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
