
package com.example.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Discount;

@Repository
public interface DiscountRepo extends CrudRepository<Discount, Long> {
	List<Discount> findAllByPolicyId(List<Long> policyId);
}
