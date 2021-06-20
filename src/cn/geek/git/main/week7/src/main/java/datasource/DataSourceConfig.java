package datasource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {

    @Bean(name = "test1DataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.data1")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.data2")
    public DataSource formalDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="test1JdbcTemplate")
    public JdbcTemplate test1JdbcTemplate (
            @Qualifier("test1DataSource")  DataSource testDataSource ) {
        return new JdbcTemplate(testDataSource);
    }

    @Bean(name = "test2JdbcTemplate")
    public JdbcTemplate formalJdbcTemplate(
            @Qualifier("test2DataSource") DataSource formalDataSource){
        return new JdbcTemplate(formalDataSource);
    }
	
}
