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
	
	@PostMapping("/creatediscount")
	public ResponseEntity<String> addDiscount(@RequestBody Discount discount) throws URISyntaxException{
		dao.addDiscount(discount);
		HttpHeaders header = new HttpHeaders();
		header.add("Policy-Id", discount.getPolicyId()+"");
		return ResponseEntity.created(new URI("/discount/" + discount.getPolicyId()))
	            .headers(header)
	            .body("Discount created successfully");
	}
	
	@GetMapping("/showbypolicyid/{id}")
	public ResponseEntity<Object> showDiscountByPolicyId(@PathVariable Long id ){
		HttpHeaders header = new HttpHeaders();
		header.add("Policy-Id", id.toString());
		return ResponseEntity.ok()
	            .headers(header)
	            .body(dao.getDiscountByPolicyId(id));
	}
}
