package com.swf.playground.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.swf.playground.view.Views;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {

	@JsonView(Views.DetailedView.class)
	@JsonProperty("FirstName")
	private String firstName;

	@JsonView(Views.DetailedView.class)
	@JsonProperty("LastName")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
