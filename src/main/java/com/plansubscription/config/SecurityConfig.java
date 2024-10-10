package com.plansubscription.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.plansubscription.serviceImpl.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
   {
	   http
	   .csrf(AbstractHttpConfigurer::disable)// Disable CSRF for simplicity (enable for production)
	   .authorizeHttpRequests(auth -> auth
			   .requestMatchers("/login","register").permitAll()
	   		   .requestMatchers("/createUser").authenticated()
	   		   .anyRequest().authenticated()
	   		   )
	   		   .formLogin(form-> form
	   		   .loginPage("/login")  // Custom login page
	   		   .permitAll()
	   		   )
	   		.logout(logout -> logout
	                .logoutUrl("/logout")
	                .logoutSuccessUrl("/login?logout")
	                .invalidateHttpSession(true)
	                .deleteCookies("JSESSIONID")
	                .permitAll()
	            )
	            .sessionManagement(session -> session
	                .sessionFixation().migrateSession()  // Session fixation protection
	                .maximumSessions(1)  // Only 1 active session per user
	            );

	        return http.build();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public UserDetailsService userDetailsService() {
	        // Custom UserDetailsService to load users from the database without roles
	        return new CustomUserDetailsService();
	    }
	}
   
