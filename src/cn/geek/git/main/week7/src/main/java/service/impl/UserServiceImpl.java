package service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import datasource.CurDataSource;
import datasource.DataSourceNames;
import entity.User;
import mapper.UserMapper;
import service.UserService;
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

	@Override
	public User findUserByFirstDb(long id) {
		// TODO Auto-generated method stub
		return this.baseMapper.selectById(id);
	}
	
	@CurDataSource(name = DataSourceNames.SECOND)
	@Override
	public User findUserBySecondDb(long id) {
		// TODO Auto-generated method stub
		return this.baseMapper.selectById(id);
	}

}
