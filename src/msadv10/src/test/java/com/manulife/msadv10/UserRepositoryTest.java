package com.manulife.msadv10;

import com.manulife.msadv10.domain.User;
import com.manulife.msadv10.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void setUp(){
        userRepository.deleteAllInBatch();
        userRepository.save(new User("AAA", 10));
    }

    @Test
    public void testFindByName() throws Exception {
        User u1 = userRepository.findByName("AAA");
        System.out.println("1st Query : " + u1.getAge());

        User u2 = userRepository.findByName("AAA");
        System.out.println("2nd Query : " + u2.getAge());

        u1.setAge(20);
        userRepository.save(u1);

        User u3 = userRepository.findByName("AAA");
        System.out.println("3rd query : " + u3.getAge());
    }
}
