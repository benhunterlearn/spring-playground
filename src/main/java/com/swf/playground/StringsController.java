package com.swf.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StringsController {

	// @Autowired
	private final WordCounter wordCounter;

	public StringsController(WordCounter wordCounter) {
		this.wordCounter = wordCounter;
	}

	@PostMapping("/word/count")
	public Map<String, Integer> postWordCount(@RequestBody String body) {
		return wordCounter.count(body);
	}

}
