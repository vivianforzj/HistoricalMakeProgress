package main.java.logback_test.b;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestB {
	private static Logger log = LoggerFactory.getLogger(TestB.class);

	public TestB() {
		log.debug("TestB-debug");
		log.info("TestB-info");
		log.warn("TestB-warn");
		log.error("TestB-error");
	}
}
