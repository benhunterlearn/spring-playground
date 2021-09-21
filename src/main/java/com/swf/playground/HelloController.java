package com.swf.playground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String getHello(@RequestParam(required = false) String one, @RequestParam(required = false) String two) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Hello friend.");

		if (one != null) {
			stringBuilder.append("one: ");
			stringBuilder.append(one);
		}
		if (two != null) {
			stringBuilder.append("two: ");
			stringBuilder.append(two);
		}
		return stringBuilder.toString();
	}

	@GetMapping("/drivers/{id}/trips")
	public String getDriverTripsByID(@PathVariable int id) {
		// return String.valueOf(id);
		return Integer.toString(id);
	}

	@GetMapping("/math/pi")
	public String getMathPi() {
		return String.valueOf(Math.PI);
		// return Double.toString(Math.PI);
	}

}
