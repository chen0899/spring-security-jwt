package com.edu.service;

import com.edu.model.User;
import com.edu.dto.UserDto;

import java.util.List;

public interface UserService {

    User save(UserDto user);

    List<User> findAll();

    void delete(long id);

    User findOne(String username);

    User findById(Long id);

}
