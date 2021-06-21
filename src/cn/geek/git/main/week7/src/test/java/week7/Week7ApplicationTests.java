package week7;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import datasource.DataSourceConfig;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import service.UserService;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
@Slf4j
@RunWith(SpringRunner.class)
//@WebMvcTest(Week7ApplicationTests.MyController.class)
@AutoConfigureMybatis
@MapperScan("mapper")
@Import({DataSourceConfig.class})
@SpringBootTest
class Week7ApplicationTests {
//	@Autowired
//	private MockMvc mockMvc;
	
	@Autowired
    private UserService userService;
	
//	@Test
//	public void contextLoads() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
//			.andExpect(MockMvcResultMatchers.status().isOk())
//			.andExpect(MockMvcResultMatchers.content().string("hello"));
//	}

    @Test
    public void test() {
        User user = userService.findUserByFirstDb(1);
//        log.info("第一个数据库 : [{}]", user.toString());
        User user2 = userService.findUserBySecondDb(1);
//        log.info("第二个数据库 : [{}]", user2.toString());
    }
    
//	@RestController
//	static class MyController {
//
//		@GetMapping("/hello")
//		public String hello() {
//			return "hello";
//		}
//
//	}
//    
//    @Mapper
//    interface MyMapper {
//    	@Select("SELECT #{id}")
//    	int selectId(int id);
//    }

}
