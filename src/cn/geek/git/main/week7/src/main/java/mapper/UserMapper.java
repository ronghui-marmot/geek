package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import entity.User;
import shardingDemo.entity.UserEntity;
@Mapper
public interface UserMapper extends BaseMapper<User> {

	void inster(UserEntity userEntity);
	
}