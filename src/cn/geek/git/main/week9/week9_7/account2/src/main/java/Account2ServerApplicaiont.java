import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ImportResource({"classpath:spring-dubbo.xml"})
@SpringBootApplication
@RestController
@MapperScan("com.example.mapper")
public class Account2ServerApplicaiton {

    public static void main(String[] args) {
        SpringApplication.run(Account2ServerApplicaiton.class,args);
    }
    @GetMapping("/hi")
    public String hi(){
        return "hello world!";
    }
}