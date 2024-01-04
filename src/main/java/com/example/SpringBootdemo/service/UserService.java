package com.example.SpringBootdemo.service;


import com.example.SpringBootdemo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    void deleteById(int id);

    void updateUser(User user);
    User findById(int id);
}
