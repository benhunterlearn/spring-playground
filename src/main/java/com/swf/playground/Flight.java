package com.swf.playground;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class Flight {

	@JsonProperty("Departs")
	private LocalDateTime departs;

	@JsonProperty("Tickets")
	private List<Ticket> ticketsList;

	@JsonFormat(pattern = "YYYY-MM-dd HH:mm")
	public LocalDateTime getDeparts() {
		return departs;
	}

	public void setDeparts(LocalDateTime departs) {
		this.departs = departs;
	}

	public List<Ticket> getTicketsList() {
		return ticketsList;
	}

	public void setTicketsList(List<Ticket> ticketsList) {
		this.ticketsList = ticketsList;
	}

}
