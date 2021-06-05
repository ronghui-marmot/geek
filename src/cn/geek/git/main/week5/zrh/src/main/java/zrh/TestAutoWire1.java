package zrh;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 该测试类没有实现自动装配，运行报错了。待查看原因
 * @author rongh
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("MarmotBeanConfig1.class")
@ContextConfiguration(locations = {"classpath*:springbean.xml"})
public class TestAutoWire1 {
	@Autowired
	private MarmotBean2 bean2;
	
	@Test
	public void beanNotNull() {
		Assert.assertNotNull(bean2);
	}
}
