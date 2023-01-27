package com.springframework.springrestapi.repositories;

import com.springframework.springrestapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
