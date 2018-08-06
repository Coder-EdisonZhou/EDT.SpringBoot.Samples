package com.manulife.msadv3.controller;

import com.manulife.msadv3.domain.User;
import com.manulife.msadv3.service.UserService;
import com.manulife.msadv3.util.StatusResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    UserService service;

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList(){
        return service.getUserList();
    }

    @ApiOperation(value = "创建新用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        boolean result = service.addNewUser(user);

        return result == true ?
                StatusResponse.SUCCESS.getDescription()
                : StatusResponse.FAILED.getDescription();
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
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

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id, @ModelAttribute User user){
        boolean result = service.deleteUserById(id);

        return result == true ?
                StatusResponse.SUCCESS.getDescription()
                : StatusResponse.FAILED.getDescription();
    }
}
