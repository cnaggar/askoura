package com.askoura.library;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class LibraryController {
    
    @RequestMapping(value = "/isalive", method = RequestMethod.GET)
    public boolean isAlive() {
        return true;
    }
}
