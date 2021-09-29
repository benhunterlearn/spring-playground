package com.swf.playground.configuration;

import com.swf.playground.service.WordCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WordCounterConfiguration {

	@Bean
	public WordCounter getWordCounter() {
		return new WordCounter();
	}

}
