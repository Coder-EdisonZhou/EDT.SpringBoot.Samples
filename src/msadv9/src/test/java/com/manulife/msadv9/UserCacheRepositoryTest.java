package com.manulife.msadv9;

import com.manulife.msadv9.domain.User;
import com.manulife.msadv9.domain.UserCacheRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCacheRepositoryTest {
    @Autowired
    private UserCacheRepository userRepository;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void setUp(){
        userRepository.deleteAllInBatch();
        userRepository.save(new User("AAA", 10));
    }

    /*
     * 调用第二次findByName函数时，没有再执行select语句，也就直接减少了一次数据库的读取操作
     * Hibernate: select user0_.id as id1_0_, user0_.age as age2_0_, user0_.name as name3_0_ from user user0_ where user0_.name=?
            1st Query : 10
            2nd Query : 10
     */
    @Test
    public void testFindByName() throws Exception {
        User u1 = userRepository.findByName("AAA");
        System.out.println("1st Query : " + u1.getAge());

        User u2 = userRepository.findByName("AAA");
        System.out.println("2nd Query : " + u2.getAge());
    }
}
