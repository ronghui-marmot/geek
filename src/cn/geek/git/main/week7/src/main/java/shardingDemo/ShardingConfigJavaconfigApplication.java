package shardingDemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@MapperScan("shardingDemo.mapper")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@PropertySource(value = {"classpath:application.yml"})
@SpringBootApplication
public class ShardingConfigJavaconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingConfigJavaconfigApplication.class, args);
    }

}
