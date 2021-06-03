package cn.geek.git.main.week5;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MarmotBeanConfig1.class)
public class TestAutoWire1 {
	@Autowired
	private MarmotBean1 bean1;
	
	@Test
	public void beanNotNull() {
		Assert.assertNotNull(bean1);
	}
}
