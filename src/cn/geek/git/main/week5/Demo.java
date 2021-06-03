package cn.geek.git.main.week5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MarmotBeanConfig1.class);
		
		MarmotBean1 b = (MarmotBean1)context.getBean("MarmotBean1");
		System.out.println(b.getName());
	}
	
	
}
