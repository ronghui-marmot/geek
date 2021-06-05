package zrh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="zrh")
public class MarmotBeanConfig1 {
	@Bean
	public MarmotBean1 setBean() {
		return new MarmotBean1();
	}
}
