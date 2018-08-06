package com.manulife.msadv2.service;

import com.manulife.msadv2.domain.User;
import com.manulife.msadv2.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public List<User> getUserList() {
        return repository.getUserList();
    }

    @Override
    public Boolean addNewUser(User user) {
        return repository.addNewUser(user);
    }

    @Override
    public User findUserById(Long id) {
        return repository.findUserById(id);
    }

    @Override
    public Boolean updateUserById(Long id, User user) {
        return repository.updateUserById(id, user);
    }

    @Override
    public Boolean deleteUserById(Long id) {
        return repository.deleteUserById(id);
    }
}
