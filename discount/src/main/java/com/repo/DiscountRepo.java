package com.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Discount;

@Repository
public interface DiscountRepo extends CrudRepository<Discount, Long>{
	  List<Discount> findByPolicyId(Long policyId);
}
