package com.haui.it.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  private static final String[] AUTH_WHITELIST = {
      // -- Swagger UI v2
      "/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
      "/configuration/security", "/swagger-ui.html", "/swagger-ui", "/webjars/**",
      // -- Swagger UI v3 (OpenAPI)
      "/v3/api-docs/**", "/swagger-ui/**"
      // other public endpoints of your API may be appended to this array
  };


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
    .
    // ... here goes your custom security configuration
        authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll(). // whitelist Swagger UI
                                                                     // resources
        // ... here goes your custom security configuration
        antMatchers("/**").authenticated(); // require authentication for any endpoint that's not
                                            // whitelisted
  }
  

}
