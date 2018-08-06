package com.manulife.msadv3.domain;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {
    // thread-safe Map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @Override
    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>(users.values());

        return userList;
    }

    @Override
    public Boolean addNewUser(User user) {
        users.put(user.getId(), user);

        return true;
    }

    @Override
    public User findUserById(Long id) {
        return users.get(id);
    }

    @Override
    public Boolean updateUserById(Long id, User user) {
        User model = users.get(id);

        if (model == null){
            return false;
        }

        model.setName(user.getName());
        model.setAge(user.getAge());

        users.put(id, model);

        return true;
    }

    public Boolean deleteUserById(Long id){
        users.remove(id);

        return true;
    }

}
