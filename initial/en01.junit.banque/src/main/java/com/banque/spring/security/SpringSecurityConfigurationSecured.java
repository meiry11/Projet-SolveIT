// -#--------------------------------------
// -# ©Copyright Ferret Renaud 2019 -
// -# Email: admin@ferretrenaud.fr -
// -# All Rights Reserved. -
// -#--------------------------------------

package com.banque.spring.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.banque.spring.security.filter.JwtAuthenticationFilter;
import com.banque.spring.security.filter.JwtAuthorizationFilter;
import com.banque.spring.security.filter.SecurityConstants;

/**
 * Security configuration. <br>
 * This is default configuration. <br>
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SpringSecurityConfigurationSecured {
	private static final Logger LOG = LogManager.getLogger();

	@Autowired
	protected Environment env;
	@Autowired
	protected AuthenticationProvider customAuthenticationProvider;

	/**
	 * Global CORS configuration.
	 *
	 * @return global cors configuration for Spring Security.
	 */
	@Bean
	protected CorsConfigurationSource corsConfigurationSource() {
		var source = new UrlBasedCorsConfigurationSource();
		var config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOriginPattern("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");

		config.addExposedHeader("WWW-Authenticate");
		config.addExposedHeader("Access-Control-Allow-Origin");
		config.addExposedHeader("Access-Control-Allow-Headers");
		// In order to see the token for Angular
		config.addExposedHeader(SecurityConstants.TOKEN_HEADER);

		source.registerCorsConfiguration("/**", config);
		return source;
	}

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) {
		SpringSecurityConfigurationSecured.LOG
				.debug("SpringSecurityConfigurationSecured - Link with our Authentication provider");
		// Our Authentication Manager
		auth.authenticationProvider(this.customAuthenticationProvider);
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager)
			throws Exception {
		SpringSecurityConfigurationSecured.LOG.debug("SpringSecurityConfigurationSecured - Apply rules");

		// Keep cors enable here, otherwise configuration of it is not applied
		http.csrf().disable().cors();

		http.authorizeRequests().antMatchers("/", // Root
				"/favicon.ico*", //
				"/index.jsp*", //
				"/csrf/**", //
				"/v3/api-docs/**", // Swagger
				"/v3/api-docs**", //
				"/configuration/**", //
				"/swagger-ui.html", //
				"/swagger-resources/**", //
				"/swagger*/**", //
				"/webjars/**", //
				"/h2/**", // h2 + frameOptions
				"/css/**", // Resources
				"/fonts/**", //
				"/img/**", //
				"/js/**", //
				"/error", //
				"license.txt").anonymous();

		// For H2
		http.headers().frameOptions().disable();

		// The JWT filter
		// We add the two filters and set session policy to Stateless
		http.authorizeRequests().and()
				.addFilterBefore(new JwtAuthenticationFilter(authenticationManager, this.env),
						UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(new JwtAuthorizationFilter(authenticationManager, this.env),
						UsernamePasswordAuthenticationFilter.class)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		var exceptionHandling = http.authorizeRequests().and().exceptionHandling();
		exceptionHandling.authenticationEntryPoint(new RestAuthenticationEntryPoint());
		exceptionHandling.accessDeniedHandler(new AccesDeniedHandler());

		// For logout, simply send 200
		http.authorizeRequests().and().logout().clearAuthentication(true)
				.logoutSuccessHandler((pRequest, pResponse, pAuthentication) -> pResponse.setStatus(200));

		// No login, and no logout
		http.authorizeRequests().and().formLogin().disable().httpBasic().disable();

		// Other constraint are handled at the controller level with annotations
		http.authorizeRequests().anyRequest().authenticated();

		return http.build();
	}

}
