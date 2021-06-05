package cn.geek.git.main.week5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="cn.geek.git.main.week5")
public class MarmotBeanConfig1 {
	@Bean
	public MarmotBean1 setBean() {
		return new MarmotBean1();
	}
}
