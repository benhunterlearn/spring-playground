package com.swf.playground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

	@GetMapping("/flight")
	public Flight getFlight() {
		Flight flight = new Flight();
		flight.setDeparts(LocalDateTime.of(2017, Month.APRIL, 21, 14, 34));

		Person passenger = new Person();
		passenger.setFirstName("Ro");
		passenger.setLastName("Block");

		Ticket ticket = new Ticket();
		ticket.setPassenger(passenger);
		ticket.setPrice(100);

		flight.setTicketsList(Arrays.asList(ticket));

		return flight;
	}

	@GetMapping("")
	public List<Flight> getFlightsList() {
		List<Flight> flightsList = new ArrayList<>();

		Flight flight = new Flight();
		flight.setDeparts(LocalDateTime.of(2017, Month.APRIL, 21, 14, 34));

		Person passenger = new Person();
		passenger.setFirstName("Ro");
		passenger.setLastName("Block");

		Ticket ticket = new Ticket();
		ticket.setPassenger(passenger);
		ticket.setPrice(100);

		flight.setTicketsList(Arrays.asList(ticket));

		flightsList.add(flight);
		flightsList.add(flight);

		return flightsList;
	}

}
