package com.example.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.limitsservice.bean.LimitsConfiguration;
import com.example.microservices.limitsservice.bean.MyConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsServiceController {

	@Autowired
	MyConfiguration myConfiguration;

	@GetMapping("/limits")
	public LimitsConfiguration getLimitConfiguration() {
		return new LimitsConfiguration(myConfiguration.getMaximum(), myConfiguration.getMinimum());
	}

	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod = "fallBackMethodRetrieveConfiguration")
	public LimitsConfiguration retrieveConfiguration() {
		throw new RuntimeException();
	}

	public LimitsConfiguration fallBackMethodRetrieveConfiguration() {
		return new LimitsConfiguration(999, 9);
	}
}
