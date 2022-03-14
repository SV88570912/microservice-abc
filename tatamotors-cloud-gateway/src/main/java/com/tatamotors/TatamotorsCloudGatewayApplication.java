package com.tatamotors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class TatamotorsCloudGatewayApplication {
	
//	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes().route("stocklist", r ->r.path("/stock/**").uri("lb://INVENTORY-MANAGEMENT-SERVICE")).build();
		
	}

	public static void main(String[] args) {
		SpringApplication.run(TatamotorsCloudGatewayApplication.class, args);
		
	}

}
