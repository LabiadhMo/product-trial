package com.alten.product_trial;

import org.springframework.boot.SpringApplication;

public class TestProductTrialApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProductTrialApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
