package com.swf.playground;

import com.swf.playground.service.WordCounter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WordCounterTest {

	@Autowired
	WordCounter wordCounter;

	@Test
	void countWords() {
		String input = "one two one";
		Map<String, Integer> expected = new HashMap<>();
		expected.put("one", 2);
		expected.put("two", 1);

		assertEquals(expected, wordCounter.count(input));
	}

}
