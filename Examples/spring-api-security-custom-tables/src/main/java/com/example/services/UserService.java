package com.example.services;

import com.example.entities.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserService(UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        user.findRoles().forEach(r -> {
            r.setUser(user);
        });
        user.setPassword("{bcrypt}" + bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
