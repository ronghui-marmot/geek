package datasource;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

@Configuration
@MapperScan(basePackages = "mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.druid.first")
    public DataSource firstDataSource(){

        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.druid.second")
    public DataSource secondDataSource(){

        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(5);
        targetDataSources.put(DataSourceNames.FIRST, firstDataSource);
        targetDataSources.put(DataSourceNames.SECOND, secondDataSource);
        return new DynamicDataSource(firstDataSource, targetDataSources);
    }
    
    
//	@Bean(name = "sqlSessionFactory")
//	private SqlSessionFactory sqlSessionFactoryBean(@Qualifier("dynamicDataSource") DataSource dynamicDataSource) {
//	    MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
//	    bean.setDataSource(dynamicDataSource);
//	    try {
//	        return bean.getObject();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        throw new RuntimeException(e);
//	    }
//	}
//	
//	@Bean
//	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
//	    return new SqlSessionTemplate(sqlSessionFactory);
//	}
    
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory test1SqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
//            throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dynamicDataSource);
//        bean.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/*.xml"));
//        return bean.getObject();
//    }


}
