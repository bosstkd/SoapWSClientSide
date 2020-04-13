package com.amine.spring.soap.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amine.spring.soap.api.client.SoapClient;
import com.amine.spring.soap.api.service.Acknowledgement;
import com.amine.spring.soap.api.service.CustomerRequest;

@SpringBootApplication
@RestController
public class SpringSoapWsClientSideApplication {

	@Autowired
	private SoapClient client;
	
	@PostMapping("/getLoanStatus")
	public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest request) {
		return client.getLoanStatus(request);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSoapWsClientSideApplication.class, args);
	}

}
