package zrh;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarmotDao extends JpaRepository<User, Integer>{
	
}
