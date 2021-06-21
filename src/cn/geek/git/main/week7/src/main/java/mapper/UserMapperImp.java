package mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import dao.CommonDao;
import entity.User;
@Mapper
public class UserMapperImp extends CommonDao implements UserMapper{

	@Override
	public int insert(User entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByMap(Map<String, Object> columnMap) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Wrapper<User> queryWrapper) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBatchIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateById(User entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User entity, Wrapper<User> updateWrapper) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectBatchIds(Collection<? extends Serializable> idList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectByMap(Map<String, Object> columnMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectOne(Wrapper<User> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectCount(Wrapper<User> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectList(Wrapper<User> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> selectMaps(Wrapper<User> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> selectObjs(Wrapper<User> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPage<User> selectPage(IPage<User> page, Wrapper<User> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPage<Map<String, Object>> selectMapsPage(IPage<User> page, Wrapper<User> queryWrapper) {
		// TODO Auto-generated method stub
		return null;
	}

}
