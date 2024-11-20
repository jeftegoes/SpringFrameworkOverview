package com.example.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails brenno = User.builder()
                .username("brenno")
                .password("{noop}master@123")
                .roles("TEACHER")
                .build();

        UserDetails barbara = User.builder()
                .username("barbara")
                .password("{noop}master@123")
                .roles("TEACHER", "COORDINATOR")
                .build();

        UserDetails jefte = User.builder()
                .username("jefte")
                .password("{noop}master@123")
                .roles("TEACHER", "COORDINATOR", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(brenno, barbara, jefte);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer -> {
            configurer
                    .requestMatchers(HttpMethod.GET, "/api/teachers/").hasRole("TEACHER")
                    .requestMatchers(HttpMethod.GET, "/api/teachers/**").hasRole("TEACHER")
                    .requestMatchers(HttpMethod.POST, "/api/teachers/").hasRole("COORDINATOR")
                    .requestMatchers(HttpMethod.PUT, "/api/teachers/**").hasRole("COORDINATOR")
                    .requestMatchers(HttpMethod.DELETE, "/api/teachers/**").hasRole("ADMIN");
        });

        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
