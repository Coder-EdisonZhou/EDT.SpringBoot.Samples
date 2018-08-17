package com.manulife.msadv11;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Log4jApplicationTests {

	private Logger logger = Logger.getLogger(getClass());

	@Test
	public void testLog4jInApp() {
		logger.info("输出INFO");
		logger.debug("输出DEBUG");
		logger.error("输出ERROR");
	}
}
