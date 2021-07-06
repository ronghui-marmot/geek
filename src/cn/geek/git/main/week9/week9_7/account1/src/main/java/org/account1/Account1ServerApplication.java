package org.account1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.Account2Service;

@ImportResource({"classpath:spring-dubbo.xml"})
@SpringBootApplication
@RestController
@MapperScan("com.example.mapper")
public class Account1ServerApplication {

    @Autowired
    private Account2Service account2Service;

    public static void main(String[] args) {
        SpringApplication.run(Account1ServerApplication.class, args);
    }

    @GetMapping("/hi")
    public String hi() {
        System.out.println("我是bank1！");
        return account2Service.hi("bank1-server");

    }
}
