package com.plansubscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.plansubscription.model.PaxUser;
import com.plansubscription.service.PaxUserService;

@RestController
@RequestMapping("/api/pax")
public class PaxController {

	@Autowired
	private PaxUserService paxUserService;
	
	@PostMapping("/createHead")
	public ResponseEntity<?>createPaxHead(@RequestBody PaxUser paxuser) {
		try 
		{
			PaxUser newHead=paxUserService.createpaxHead(paxuser);
			return new ResponseEntity<>(newHead, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
}
