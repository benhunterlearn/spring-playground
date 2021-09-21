package com.swf.playground;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@GetMapping("/search")
	public String getSearch(BookSearch bookSearch) {
		return bookSearch.toString();
	}

	@PostMapping("/string-raw")
	public String getRawString(@RequestBody String rawBody) {
		System.out.println(rawBody);
		return rawBody;
	}

	@PostMapping("/string-map")
	public String getMap(@RequestParam Map<String, String> params) {
		return params.toString();
	}

	@PostMapping("/string-pojo")
	public String getPojo(@ModelAttribute Pojo params) {
		// public String getPojo(@RequestBody Pojo params) {
		System.out.println(params.toString());
		return params.toString();
	}

}
