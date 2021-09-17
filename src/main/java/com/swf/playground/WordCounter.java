package com.swf.playground;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

//@Service
public class WordCounter {

    public Map<String, Integer> count(String message) {
        Map<String, Integer> wordCountMap = new HashMap<String, Integer>();

        // split message
        String[] words = message.split(" ");

        // iterate and increment the map
        for (String word : words) {
            Integer count = wordCountMap.computeIfAbsent(word, s -> StringUtils.countOccurrencesOf(message, word));
            if (count != null) {
                wordCountMap.put(word, StringUtils.countOccurrencesOf(message, word));
            }
        }

        return wordCountMap;
    }

}
