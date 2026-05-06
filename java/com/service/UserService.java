package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AccountRepository;
import com.dao.UserRepository;
import com.entity.Account;
import com.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    public User login(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            return null;
        }

        if (!user.getPassword().equals(password)) {
            return null;
        }

        return user;
    }

    public User register(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            return null;
        }

        user.setRole("CUSTOMER");
        User savedUser = userRepository.save(user);

        Account account = new Account();
        account.setBalance(0.0);
        account.setAccount_type("SAVINGS");
        account.setUser(savedUser);
        accountRepository.save(account);

        return savedUser;
    }
}