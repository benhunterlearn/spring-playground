package com.swf.playground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @GetMapping("/search")
    public String getSearch(BookSearch bookSearch) {
        return bookSearch.toString();
    }
}
