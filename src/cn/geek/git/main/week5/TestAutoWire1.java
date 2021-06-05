package cn.geek.git.main.week5;

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
@ContextConfiguration("MarmotBeanConfig1.class")
public class TestAutoWire1 {
	@Autowired
	private MarmotBean1 bean1;
	
	@Test
	public void beanNotNull() {
		Assert.assertNotNull(bean1);
	}
}
