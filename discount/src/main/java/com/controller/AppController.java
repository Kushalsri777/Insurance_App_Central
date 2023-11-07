// Controller class for handling Discount operations
package com.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.DiscountDao;
import com.entity.Discount;


@RestController
@RequestMapping("/discount")
public class AppController {

	@Autowired
	private DiscountDao dao;
	
	// Endpoint to create a discount
	@PostMapping("/creatediscount")
	public ResponseEntity<String> addDiscount(@RequestBody Discount discount) throws URISyntaxException{
		// Call the DAO to add the discount
		dao.addDiscount(discount);
		
		// Prepare response headers with Policy-Id
		HttpHeaders header = new HttpHeaders();
		header.add("Policy-Id", discount.getPolicyId()+"");
		
		// Return response with created URI and headers
		return ResponseEntity.created(new URI("/discount/" + discount.getPolicyId()))
	            .headers(header)
	            .body("Discount created successfully");
	}
	
	// Endpoint to retrieve discounts by policy ID
	@GetMapping("/showbypolicyid/{id}")
	public ResponseEntity<Object> showDiscountByPolicyId(@PathVariable Long id ){
		HttpHeaders header = new HttpHeaders();
		header.add("Policy-Id", id.toString());
		// Return response with OK status, headers, and discounts
		return ResponseEntity.ok()
	            .headers(header)
	            .body(dao.getDiscountByPolicyId(id));
	}
}
