package io.polarian.auth.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private DataSource dataSource;
	
	@Autowired
    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> builder = auth.jdbcAuthentication();
    	builder.dataSource(dataSource);
    	JdbcUserDetailsManager userDetailsService = builder.getUserDetailsService();
        userDetailsService.setUsersByUsernameQuery("select username,password,enabled from users where username = ?");
        userDetailsService.setAuthoritiesByUsernameQuery("select username,authority from user_roles where username = ?");
        userDetailsService.setCreateUserSql("insert into users (username, password, enabled) values (?,?,?)");
        userDetailsService.setCreateAuthoritySql("insert into user_roles (username, authority) values (?,?)");
     }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
