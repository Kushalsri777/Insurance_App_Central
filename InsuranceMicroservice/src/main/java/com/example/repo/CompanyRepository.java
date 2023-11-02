package com.example.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Company;


@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
}

