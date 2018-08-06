package com.manulife.msadv2.controller;

import com.manulife.msadv2.domain.User;
import com.manulife.msadv2.service.UserService;
import com.manulife.msadv2.util.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList(){
        return service.getUserList();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        boolean result = service.addNewUser(user);

        return result == true ?
                StatusResponse.SUCCESS.getDescription()
                : StatusResponse.FAILED.getDescription();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return service.findUserById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user){
        boolean result = service.updateUserById(id, user);

        return result == true ?
                StatusResponse.SUCCESS.getDescription()
                : StatusResponse.FAILED.getDescription();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id, @ModelAttribute User user){
        boolean result = service.deleteUserById(id);

        return result == true ?
                StatusResponse.SUCCESS.getDescription()
                : StatusResponse.FAILED.getDescription();
    }
}
