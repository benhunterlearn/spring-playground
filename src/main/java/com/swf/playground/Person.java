package com.swf.playground;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

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
