package io.polarian.api.rest;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
    @GetMapping("/test")
    public String test(OAuth2Authentication auth) {
    	OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)auth.getDetails();
//    	OAuth2AccessToken accessToken = rsts.readAccessToken(token);
//    	Map map = accessToken.getAdditionalInformation();
    	
        return " can access this endpoint";
    }
}
