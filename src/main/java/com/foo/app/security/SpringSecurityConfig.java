package com.foo.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	// roles admin allow to access /admin/**
	// roles user allow to access /user/**
	// custom 403 access denied handler
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests()
				// Permitir sempre as URI seguintes:
				.antMatchers("/**", "/res-static/**").permitAll()

				.antMatchers("/home").hasAnyRole("ADMIN")
//				.antMatchers("/user/**").hasAnyRole("USER")

				// Permitir todos os requests autenticados
				.anyRequest().authenticated().and()

				// Os requests que não derem match acima serão redirectionados para /login
				.formLogin().loginPage("/login").permitAll().and().logout().permitAll().and() // Permitir /logout

				// Erros redirecionados para este handler
				.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}

	// create two users, admin and user
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication() //
				.withUser("user").password("{noop}password").roles("USER") //
				.and() //
				.withUser("admin").password("{noop}password").roles("ADMIN"); //
	}
}
