package com.educandoweb.course.Config;

import com.educandoweb.course.Entities.User;
import com.educandoweb.course.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository UserRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com" , "9888888888", "12312");
        User u2 = new User(null, "Jown Brown", "Brown@gmail.com" , "123123", "34576345");

        UserRepository.saveAll(Arrays.asList(u1,u2));
    }
}
