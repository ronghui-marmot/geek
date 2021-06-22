package shardingDemo.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

@Configuration
public class MybatisPlusConfig {
    @Resource
    private DataSource dataSource;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        //可以通过环境变量获取你的mapper路径,这样mapper扫描可以通过配置文件配置了
        scannerConfigurer.setBasePackage("classpath*:application.yml");
        return scannerConfigurer;
    }


	@Bean(name = "sqlSessionFactory")
	SqlSessionFactory sqlSessionFactoryBean() {
	    MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
	    bean.setDataSource(dataSource);
	    try {
	        return bean.getObject();
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException(e);
	    }
	}
  @Bean
  public SqlSessionTemplate sqlSessionTemplate() {
      return new SqlSessionTemplate(sqlSessionFactory);
  }
	
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}

