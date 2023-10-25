package com.javamicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {


	/**
	 * @return
	 */
	@Bean
	public WebClient webclient() {
		return WebClient.builder().build();
	}
}
