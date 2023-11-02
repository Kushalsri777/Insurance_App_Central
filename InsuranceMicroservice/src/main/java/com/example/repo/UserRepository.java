package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
