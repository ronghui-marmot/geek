package zrh;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Week5_2 {
	
	public static void main(String[] args) {
//		方法一：通过注释自动装配bean
//		ApplicationContext context = new AnnotationConfigApplicationContext(MarmotBeanConfig1.class);
//		MarmotBean1 b = (MarmotBean1)context.getBean("marmotBean1",MarmotBean1.class);
//		System.out.println(b.getName());
//		方法二：通过xml的方式
		ApplicationContext context2 = new ClassPathXmlApplicationContext("classpath:springBean.xml");
		MarmotBean2 b2 = (MarmotBean2)context2.getBean("marmotBean2",MarmotBean2.class);
		System.out.println(b2.getName());
//		
		
	}
	
	
}
