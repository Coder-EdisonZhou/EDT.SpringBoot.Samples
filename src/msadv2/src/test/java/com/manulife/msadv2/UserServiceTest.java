package com.manulife.msadv2;

import com.manulife.msadv2.domain.User;
import com.manulife.msadv2.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService service;

    @Test
    public void testUserService() throws Exception {
        // 01.get all user list
        List<User> userList = service.getUserList();
        Assert.assertEquals(0, userList.size());

        // 02.add one new user
        User user = new User();
        Long userId = 10001L;
        user.setId(userId);
        user.setName("EdisonZhou");
        user.setAge(29);
        service.addNewUser(user);

        userList = service.getUserList();
        Assert.assertEquals(1, userList.size());

        // 03.get one existing user
        user = null;
        user = service.findUserById(userId);
        Assert.assertEquals("EdisonZhou", user.getName());

        // 04.update one existing user
        user.setName("HelloKitty");
        service.updateUserById(userId, user);
        user = null;
        user = service.findUserById(userId);
        Assert.assertEquals("HelloKitty", user.getName());

        // 05.delete one existing user
        service.deleteUserById(userId);
        userList = service.getUserList();
        Assert.assertEquals(0, userList.size());
    }
}
