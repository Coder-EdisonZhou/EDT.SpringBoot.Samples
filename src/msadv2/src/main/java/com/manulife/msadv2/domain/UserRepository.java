package com.manulife.msadv2.domain;

import java.util.List;

public interface UserRepository {
    List<User> getUserList();
    Boolean addNewUser(User user);
    User findUserById(Long id);
    Boolean updateUserById(Long id, User user);
    Boolean deleteUserById(Long id);
}
