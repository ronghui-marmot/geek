package zrh;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.test.context.ContextConfiguration;

import com.zaxxer.hikari.HikariDataSource;


@SpringBootApplication
//@ContextConfiguration(locations = {"classpath*:springBean.xml"})
@ConfigurationProperties
public class HikariDemoApp implements CommandLineRunner  {
	@Autowired
	private HikariDataSource datasource;
	
	public static void main(String[] args) {
		SpringApplication.run(HikariDemoApp.class, args);
	}
	
	public void run(String... args) throws Exception{
		Connection conn = datasource.getConnection();
		conn.close();
	}
	
}
