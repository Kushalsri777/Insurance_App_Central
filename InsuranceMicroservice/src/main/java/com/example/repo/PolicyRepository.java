package com.example.repo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Policy;
import com.example.models.AddPolicyRequest;

@Repository
public interface PolicyRepository extends CrudRepository<Policy, Long> {
	List<Policy> findAll();
	Optional<Policy> findUpdatePolicyByPolicyId(int policyId);
}

