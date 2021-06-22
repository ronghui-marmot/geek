package shardingDemo.service.impl;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.UserMapper;
import shardingDemo.entity.UserEntity;
import shardingDemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
//    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(UserEntity userEntity) {
        userMapper.inster(userEntity);
    }
}