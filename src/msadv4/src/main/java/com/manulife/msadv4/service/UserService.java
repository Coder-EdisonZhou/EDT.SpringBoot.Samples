package com.manulife.msadv4.service;

public interface UserService {
    // 01.新增一个用户
    void create(String name, Integer age);
    // 02.根据name删除一个用户
    void deleteByName(String name);
    // 03.获取用户量
    Integer getAllUsers();
    // 04.删除所有用户
    void deleteAllUsers();
}
