package com.springframework.springrestapi.controllers;


import com.springframework.springrestapi.models.User;
import com.springframework.springrestapi.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public void updateuser(@PathVariable Long id,@RequestBody User user){
        user.setId(id);
        userService.save(user);
    }


    @PatchMapping("/{id}")
    public User patchUser(@PathVariable Long id,@RequestBody User patch){
        User user = userService.finduserById(id);
        if(patch.getFullname() != null){
            user.setFullname(patch.getFullname());
        }
        if(patch.getUsername() != null){
            user.setUsername(patch.getUsername());
        }
        if(patch.getPassword() != null){
            user.setPassword(patch.getPassword());
        }
        if(patch.getEmail() != null){
            user.setEmail(patch.getEmail());
        }
        return userService.save(user);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }
}
