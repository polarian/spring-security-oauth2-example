package io.polarian.api.config;

import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;

public class CustomUserInfoTokenServices extends UserInfoTokenServices {

	public CustomUserInfoTokenServices(String userInfoEndpointUrl, String clientId) {
		super(userInfoEndpointUrl, clientId);
	}
}
