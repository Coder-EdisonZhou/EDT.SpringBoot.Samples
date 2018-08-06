package com.manulife.msadv3.service;

import com.manulife.msadv3.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    Boolean addNewUser(User user);
    User findUserById(Long id);
    Boolean updateUserById(Long id, User user);
    Boolean deleteUserById(Long id);
}
