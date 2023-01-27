package com.springframework.springrestapi.services;

import com.springframework.springrestapi.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    User save(User user);
    void deleteById(Long id);
    User finduserById(Long id);

}
