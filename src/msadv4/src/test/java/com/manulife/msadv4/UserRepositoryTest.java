package com.manulife.msadv4;

import com.manulife.msadv4.domain.User;
import com.manulife.msadv4.domain.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp(){
        // 准备工作：清空user表
        userRepository.deleteAllInBatch();
    }

    @Test
    public void testSpringDataJpa() throws Exception{
        // 01.创建10条记录
        userRepository.save(new User("AAA",10));
        userRepository.save(new User("BBB",20));
        userRepository.save(new User("CCC",30));
        userRepository.save(new User("DDD",40));
        userRepository.save(new User("EEE",50));
        userRepository.save(new User("FFF",60));
        userRepository.save(new User("GGG",70));
        userRepository.save(new User("HHH",80));
        userRepository.save(new User("III",90));
        userRepository.save(new User("JJJ",100));

        // 02.测试findAll
        Assert.assertEquals(10, userRepository.findAll().size());

        // 03.测试findByName, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());

        // 04.测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());

        // 05.测试删除姓名为AAA的User
        userRepository.delete(userRepository.findByName("AAA"));

        // 06. 测试findAll，查询所有记录，验证上面的删除是否成功
        Assert.assertEquals(9, userRepository.findAll().size());
    }
}
