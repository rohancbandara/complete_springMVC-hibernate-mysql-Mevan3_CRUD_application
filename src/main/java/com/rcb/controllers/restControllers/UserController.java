package com.rcb.controllers.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rcb.dtos.UserDTO;
import com.rcb.services.UserService;
import com.rcb.utils.CustomizedResponse;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUpdate")
	public ResponseEntity<CustomizedResponse> saveUpdateUser (@RequestBody UserDTO user) { 
		return new ResponseEntity<CustomizedResponse>(userService.saveUpdateUser(user), HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<CustomizedResponse> findUserById (@RequestParam("userId") String userId) { 
		return new ResponseEntity<CustomizedResponse>(userService.findUserById(Long.parseLong(userId)), HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<CustomizedResponse> getAll () { 
		return new ResponseEntity<CustomizedResponse>(userService.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<CustomizedResponse> deleteUserById (@RequestParam("userId") String userId) { 
		return new ResponseEntity<CustomizedResponse>(userService.deleteUserById(Long.parseLong(userId)), HttpStatus.OK);
	}

}
