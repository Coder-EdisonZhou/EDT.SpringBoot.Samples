package com.manulife.msadv2;

import com.manulife.msadv2.domain.Person;
import com.manulife.msadv2.domain.PersonRepository;
import com.manulife.msadv2.service.PersonService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {
    @Mock
    private PersonRepository mockRepository;

    @InjectMocks
    private PersonService service;

    @Before
    public void setUp() throws Exception {
        Mockito.when(mockRepository.getPersonById(1)).thenReturn(new Person(1, "TestPerson"));
        Mockito.when(mockRepository.updatePerson(Mockito.isA(Person.class))).thenReturn(true);
    }

    @Test
    public void testGetPerson() {
        Person person = service.getPerson(1);
        Assert.assertEquals("TestPerson", person.getName());
    }

    @Test
    public void testUpdatePerson() {
        int id = 1;
        String updateName = "Edison Zhou";

        boolean result = service.updatePerson(id, updateName);
        Assert.assertEquals(true, result);
    }
}
