package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String addFeedback(@RequestBody Feedback feedback) {
		service.addFeedback(feedback);
		return "feedback added";
	}
	
	@GetMapping("/unacknowledged")
	private List<Feedback> getAllUnacknowledgedFeedback(){
		return service.getAllUnacknowledgedFeedback();
	}
	
	@GetMapping("/acknowledged")
	private List<Feedback> getAllAcknowledgedFeedback(){
		return service.getAllAcknowledgedFeedback();
	}
	
	@PostMapping("/updateFeedback")
	private String updateFeedback(@RequestBody Feedback feedback) {
		service.updateFeedback(feedback);
		return "Updated";
	}
}
