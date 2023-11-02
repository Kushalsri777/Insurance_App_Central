package com.repo;

import org.springframework.data.repository.CrudRepository;

import com.entity.Feedback;

public interface FeedbackRepo extends CrudRepository<Feedback, Integer>{

}
