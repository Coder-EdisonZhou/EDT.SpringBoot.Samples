package com.manulife.msadv7;

import com.manulife.msadv7.domain.User;
import com.manulife.msadv7.domain.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void testFindByName() throws Exception {
        userMapper.insert("ABCD", 29);

        User user = userMapper.findByName("ABCD");
        Assert.assertEquals(29, user.getAge().intValue());
    }

    @Test
    @Rollback
    public void testInsertByMap() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "CCCC");
        map.put("age", 40);

        userMapper.insertByMap(map);
        User user = userMapper.findByName("CCCC");
        Assert.assertEquals(40, user.getAge().intValue());
    }

    @Test
    @Rollback
    public void testInsertByUser() throws Exception {
        User user = new User();
        user.setName("EDC");
        user.setAge(29);

        userMapper.insertByUser(user);

        Assert.assertEquals(29, userMapper.findByName("EDC").getAge().intValue());
    }

    @Test
    @Rollback
    public void testUpdate() throws Exception {
        User user = userMapper.findByName("EDC");
        user.setAge(30);

        userMapper.update(user);

        Assert.assertEquals(30, userMapper.findByName("EDC").getAge().intValue());
    }

    @Test
    @Rollback
    public void testDelete() throws Exception {
        User user = userMapper.findByName("EDC");

        userMapper.delete(user.getId());

        Assert.assertEquals(null, userMapper.findByName("EDC"));
    }

    @Test
    @Rollback
    public void testFindAll() throws Exception {
        List<User> userList = userMapper.findAll();

        for (User user : userList){
            Assert.assertEquals(null, user.getId());
            Assert.assertNotEquals(null, user.getName());
            Assert.assertNotEquals(null, user.getAge());
        }
    }
}
