package com.oprosWeb.web.services;

import com.oprosWeb.web.models.UserModel;

import java.util.List;

public interface UserService {
    UserModel saveUser(UserModel user);
    UserModel getUserById(Long userId);
    List<UserModel> getAllUsers();
    UserModel updateUser(UserModel user);
    void deleteUser(Long userId);
    UserModel getCurrentUser();
}
