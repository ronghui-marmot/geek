package week7;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import datasource.DataSourceConfig;

@MapperScan("mapper")
@PropertySource(value = {"classpath:application.properties"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@Import({DataSourceConfig.class})
@SpringBootApplication
public class Week7Application {

	public static void main(String[] args) {
		SpringApplication.run(Week7Application.class, args);
	}

}
