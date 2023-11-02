package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Feedback;
import com.repo.FeedbackRepo;

public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackRepo repo;
	
	@Override
	public void addFeedback(Feedback feedback) {
		repo.save(feedback);
	}

	@Override
	public List<Feedback> getAllAcknowledgedFeedback() {
		return repo. ;
	}

	@Override
	public List<Feedback> getAllUnacknowledgedFeedback() {
		return repo. ;
	}

	@Override
	public String updateFeedback(Feedback feedback) {			//not done
		return "Updated";
	}
	
}
