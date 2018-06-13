package io.polarian.api.rest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
    @GetMapping("/test")
    public String test() {
    	String username = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
        return username+" can access this endpoint";
    }
}
