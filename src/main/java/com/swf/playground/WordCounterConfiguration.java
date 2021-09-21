package com.swf.playground;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WordCounterConfiguration {

	@Bean
	public WordCounter getWordCounter() {
		return new WordCounter();
	}

}
