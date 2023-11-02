package com.service;

import java.util.List;

import com.entity.Feedback;

public interface FeedbackService {
	public void addFeedback(Feedback feedback);
	public List<Feedback> getAllAcknowledgedFeedback();
	public List<Feedback> getAllUnacknowledgedFeedback();
	public String updateFeedback(Feedback feedback);
}
