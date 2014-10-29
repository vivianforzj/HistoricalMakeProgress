package MethodsProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloString {
	final static Logger log = LoggerFactory.getLogger(HelloString.class);
	public static String getHello() {
		log.info("HelloString is invoked");
		return "Hello, World!";
	}
	public static void main(String[] args) {
		while(true){
			System.out.println(HelloString.getHello());
			log.info("an message");
		}
	}
}
