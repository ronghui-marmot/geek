package shardingDemo.mapper;

import org.apache.ibatis.annotations.Mapper;

import shardingDemo.entity.UserEntity;

@Mapper
public interface UserMapper {

    void inster(UserEntity userEntity);

}
