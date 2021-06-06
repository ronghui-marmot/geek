package zrh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kimmking.School;

@Configuration
@EnableConfigurationProperties(School.class)
@ConditionalOnProperty(
		prefix = "marmot",
		name = "isopen",
		havingValue="true"
		)
public class Week5_8 {
	@Autowired
	private School school;
	
	@Bean(name="marmot")
	public KimService test() {
		return new KimService(school.ding2());
	}
}
