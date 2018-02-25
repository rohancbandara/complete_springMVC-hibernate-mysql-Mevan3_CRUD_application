package com.rcb.controllers.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcb.dtos.DocterDTO;
import com.rcb.services.DocterService;
import com.rcb.utils.CustomizedResponse;

@RestController
@RequestMapping("/api/docter")
public class DocterController {
	@Autowired
	private DocterService docterService;

	@PostMapping("/saveUpdate")
	public ResponseEntity<CustomizedResponse> saveUpdateDocter(@RequestBody DocterDTO docter) {
		return new ResponseEntity<CustomizedResponse>(docterService.saveUpdateDocter(docter), HttpStatus.OK);

	}
}
