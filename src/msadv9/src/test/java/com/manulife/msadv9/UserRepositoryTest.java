package com.manulife.msadv9;

import com.manulife.msadv9.domain.User;
import com.manulife.msadv9.domain.UserRepository;
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
        userRepository.save(new User("AAA", 10));
    }

    @Test
    public void testFindByName() throws Exception{
        User u1 = userRepository.findByName("AAA");
        System.out.println("1st Query : " + u1.getAge());

        User u2 = userRepository.findByName("AAA");
        System.out.println("2nd Query : " + u2.getAge());
    }
}
