package com.realcoderz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.realcoderz.service.IUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private IUserService userService;

	@Autowired
	private JWTTokenHelper jWTTokenHelper;

	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
//		//in memory
//		auth.inMemoryAuthentication().withUser("Pradeep").password(passwordEncoder().encode("pradeep123"))
//				.authorities("USER", "ADMIN");

		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and()
//		.exceptionHandling()
//		.authenticationEntryPoint(authenticationEntryPoint)
//		.and()
//		.authorizeRequests((request) -> request.antMatchers("/**", "/api/v1/auth/login")
//		.permitAll()
//		.antMatchers(HttpMethod.OPTIONS, "/**")
//		.permitAll()
//		.anyRequest()
//		.authenticated())
//		.addFilterBefore(new JWTAuthenticationFilter(userService, jWTTokenHelper),
//						UsernamePasswordAuthenticationFilter.class);
//
//		http.csrf().disable().cors().and().headers().frameOptions().disable();
//
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(authenticationEntryPoint)
		.and()
		.authorizeRequests().antMatchers("/api/v1/user/register","/api/v1/auth/**","/images/**","/**").permitAll()
				
				
		.antMatchers("/api/v1/quiz/score").authenticated()
		
				
	     .antMatchers(HttpMethod.OPTIONS,"/api/v1/questions/**").permitAll()
		  
		
		

		
		
		.anyRequest().authenticated()
		
		
		.and()
		.addFilterBefore(new JWTAuthenticationFilter(userService, jWTTokenHelper),UsernamePasswordAuthenticationFilter.class);
		
		
		http.csrf().disable().cors().and().headers().frameOptions().disable();
		

	}

}