package com.dao;

import java.util.List;

import com.entity.Discount;

public interface DiscountDao {
	public void addDiscount(Discount discount);
	public List<Discount> getDiscountByPolicyId(Long policyId);
}
