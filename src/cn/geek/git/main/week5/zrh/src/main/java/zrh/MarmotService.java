package zrh;

import org.springframework.beans.factory.annotation.Autowired;

public class MarmotService {
	@Autowired
	MarmotDao mmDao;
	
	public User find(int id) {
		return mmDao.getOne(id);
	}
	
	public User update(User user) {
		return mmDao.save(user);
	}
	
	public void delete(User user) {
		mmDao.delete(user);
	}
}
