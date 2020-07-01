package com.elvis.gateway.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .antMatcher("/**") // this will apply to the entire web server
                .authorizeRequests()
                .antMatchers("/api/propietarios/swagger-ui.html"
                        , "/api/propietarios/webjars/springfox-swagger-ui/**"
                        , "/api/propietarios/swagger-resources/**"
                        ,"/api/propietarios/v2/**").permitAll()
                .antMatchers("/api/especies/swagger-ui.html"
                        , "/api/especies/webjars/springfox-swagger-ui/**"
                        , "/api/especies/swagger-resources/**"
                        ,"/api/especies/v2/**").permitAll()
                .anyRequest().authenticated();

    }
}
