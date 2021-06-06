package zrh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/user")
public class MarmotAction {
	
	@Autowired MarmotService marmotService;
	
	@RequestMapping("/find")
	public String find(int id) {
		User user = marmotService.find(id);
		return user == null ? "没找到":user.getName();
	}
}
