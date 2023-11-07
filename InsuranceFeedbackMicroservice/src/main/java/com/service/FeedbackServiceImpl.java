package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Feedback;
import com.repo.FeedbackRepo;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackRepo repo;
	
	@Override
	@Transactional
	public void addFeedback(Feedback feedback) {
		repo.save(feedback);
	}

	@Override
	public List<Feedback> showAll() {
		return (List<Feedback>)repo.findAll();
	}
}
