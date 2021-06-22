package shardingDemo.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shardingDemo.entity.UserEntity;
import shardingDemo.service.UserService;

@RestController
@RequestMapping("sj/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("addUser")
    public void addUser(){

        UserEntity userEntity = new UserEntity();
        userEntity.setCreateTime(new Date(0));
        userEntity.setName("zsk");
        userEntity.setSex("男");

        userService.addUser(userEntity);
    }
}
