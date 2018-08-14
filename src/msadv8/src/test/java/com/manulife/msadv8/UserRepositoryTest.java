package com.manulife.msadv8;

import com.manulife.msadv8.domain.User;
import com.manulife.msadv8.domain.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	@Test
	@Transactional
	public void testAddNewRecords() {
		// 01.创建10条记录
		userRepository.save(new User("AAA",10));
		userRepository.save(new User("BBB",20));
		userRepository.save(new User("CCC",30));
		userRepository.save(new User("DDD",40));
		userRepository.save(new User("EEE",50));
		userRepository.save(new User("FFF",60));
		userRepository.save(new User("GGG",70));
		userRepository.save(new User("HHHHHHHHHH",80)); // 测试length>5
		userRepository.save(new User("III",90));
		userRepository.save(new User("JJJ",100));

		// 02.测试findAll
		Assert.assertEquals(10, userRepository.findAll().size());
	}

}
