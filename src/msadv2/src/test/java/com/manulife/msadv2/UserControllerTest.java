package com.manulife.msadv2;

import com.manulife.msadv2.util.StatusResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testUserController() throws Exception {
        RequestBuilder request = null;
        // 01.get all user list
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[]"));

        // 02.post a new user
        request = MockMvcRequestBuilders.post("/users/")
                .param("id","10001")
                .param("name","Edison Zhou")
                .param("age", "29");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(StatusResponse.SUCCESS.getDescription()));

        // 03.get all user list
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[{\"id\":10001,\"name\":\"Edison Zhou\",\"age\":29}]"));

        // 04.put one existing user to update name
        request = MockMvcRequestBuilders.put("/users/10001")
                .param("name","Edison Chou")
                .param("age","30");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.content().string(StatusResponse.SUCCESS.getDescription()));

        // 05.get one existing user by id
        request = MockMvcRequestBuilders.get("/users/10001");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":10001,\"name\":\"Edison Chou\",\"age\":30}"));

        // 06.delete one existing user by id
        request = MockMvcRequestBuilders.delete("/users/10001");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(StatusResponse.SUCCESS.getDescription()));

        // 07.get all user list => it is null
        request = MockMvcRequestBuilders.get("/users/");
        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}
