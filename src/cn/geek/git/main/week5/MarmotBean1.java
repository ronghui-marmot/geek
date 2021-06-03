package cn.geek.git.main.week5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MarmotBean1 {
	@Value("1")
	private int id;
	@Value("marmot")
	private String name;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
