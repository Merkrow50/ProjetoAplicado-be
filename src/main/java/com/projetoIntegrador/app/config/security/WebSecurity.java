package com.projetoIntegrador.app.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class WebSecurity {

  @Autowired
  private JwtRequestFilter jwtRequestFilter;
  @Autowired
  private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
        .and().csrf().disable()
        .headers().frameOptions().disable().and().authorizeRequests()
        .antMatchers("/v1/users/create", "/v1/auth/login", "/swagger-resources/**", "/v2/api-docs", "/configuration/ui", "/configuration/security", "/swagger-ui.html", "/webjars/**")
        .permitAll().anyRequest().authenticated()
        .and()
        .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class).build();
  }

}
