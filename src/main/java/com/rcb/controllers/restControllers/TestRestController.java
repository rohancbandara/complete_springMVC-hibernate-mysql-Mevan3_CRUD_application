package com.rcb.controllers.restControllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcb.utils.CustomizedResponse;

@RestController
@RequestMapping("/api")
public class TestRestController {
	
	private static final Logger LOG = Logger.getLogger(TestRestController.class);
	
	@GetMapping("/test")
	public ResponseEntity<CustomizedResponse> testApi () {
		LOG.debug("*****************/Enter message in TestRestController /*************");
		
		CustomizedResponse customizedResponse = new CustomizedResponse();
		customizedResponse.setResponse("Done");
		customizedResponse.setSuccess(true);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Access-Control-Allow-Origin", "*");
		headers.set("Access-Control-Allow-Methods", "GET");
		headers.set("Access-Control-Max-Age", "3600");
		headers.set("Access-Control-Allow-Headers", "x-requested-with");
		
		LOG.debug("*****************/Exit message in TestRestController /*************");
        return new ResponseEntity<CustomizedResponse>(customizedResponse,headers, HttpStatus.OK);
	}
}
