package com.manulife.msadv1;

import com.manulife.msadv1.domain.DemoProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Msadv1ApplicationTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World!"));
    }

    @Autowired
    private DemoProperties properties;

    @Test
    public void testDemoProperties() throws Exception{
        Assert.assertEquals(properties.getAuthor(), "Manulife Chengdu");
        Assert.assertEquals(properties.getTitle(), "SpringBoot QuickStart Demo");
        Assert.assertEquals(properties.getDesc(), properties.getAuthor() + " is writting " + properties.getTitle());
    }
}
