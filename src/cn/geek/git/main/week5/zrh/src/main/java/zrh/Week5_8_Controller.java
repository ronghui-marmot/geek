package zrh;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Week5_8_Controller {
	@Resource
	private KimService service;
	
	@GetMapping("/test")
	public String say() {
		return service.say();
	}
}
