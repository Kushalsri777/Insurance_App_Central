// Interface for Discount Data Access Object (DAO)
package com.dao;

import java.util.List;

import com.entity.Discount;

public interface DiscountDao {
	// Method to add a discount
	public void addDiscount(Discount discount);
	
	// Method to get discounts by policy ID
	public List<Discount> getDiscountByPolicyId(Long policyId);
}
