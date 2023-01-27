package com.springframework.springrestapi.dataLoader;

import com.springframework.springrestapi.models.User;
import com.springframework.springrestapi.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserService userService;

    public DataLoader(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(1L,"amioualid","User2022","passs","email@gmail.com");
        userService.save(user1);

        User user2 = new User(2L,"Srhiroualid","User2023","wordddd","gmail@gmail.com");
        userService.save(user2);
    }
}
