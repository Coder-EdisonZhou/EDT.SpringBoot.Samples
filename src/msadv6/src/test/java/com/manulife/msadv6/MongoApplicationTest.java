package com.manulife.msadv6;

import com.manulife.msadv6.domain.Client;
import com.manulife.msadv6.domain.ClientRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoApplicationTest {
    @Autowired
    private ClientRepository clientRepository;

    @Before
    public void setUp(){
        clientRepository.deleteAll();
    }

    @Test
    public void testClientRepository(){
        // 01.创建三个Client到MongoDB，并验证Client总数
        clientRepository.save(new Client(1L, "Edison", 29));
        clientRepository.save(new Client(2L, "Andy", 30));
        clientRepository.save(new Client(3L, "Leo", 27));

        Assert.assertEquals(3, clientRepository.findAll().size());

        // 02.删除一个Client，再验证Client总数
        Client client = clientRepository.findOne(1L);
        clientRepository.delete(client);

        Assert.assertEquals(2, clientRepository.findAll().size());

        // 03.再删除一个Client，再验证Client总数
        client = clientRepository.findByUserName("Leo");
        clientRepository.delete(client);

        Assert.assertEquals(1, clientRepository.findAll().size());

        // 04.更改一个Client的age，再存入MongoDB，最后验证age
        client = clientRepository.findByUserName("Andy");
        client.setAge(31);
        clientRepository.save(client);

        Assert.assertEquals(31,
                clientRepository.findByUserName("Andy").getAge().intValue());
    }
}
