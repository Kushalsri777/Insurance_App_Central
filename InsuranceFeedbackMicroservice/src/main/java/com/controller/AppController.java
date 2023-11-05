package com.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Feedback;
import com.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class AppController {

	@Autowired
	private FeedbackService service;
	
	@PostMapping("/addFeedback")
	public ResponseEntity<String> addFeedback(@RequestBody Feedback feedback) throws URISyntaxException {
		service.addFeedback(feedback);
		HttpHeaders header = new HttpHeaders();
		header.add("Order-Id", feedback.getOrderId().toString());
		 return ResponseEntity.created(new URI("/feedback/" + feedback.getFeedbackId().toString()))
            .headers(header)
            .body("Feedback created successfully");
	}
}
