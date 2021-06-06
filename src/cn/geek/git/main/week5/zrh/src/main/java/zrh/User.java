package zrh;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	
	private int id;
	
	private String name;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
