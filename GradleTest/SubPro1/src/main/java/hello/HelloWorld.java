package hello;

import MethodsProvider.HelloString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {

	final static Logger log = LoggerFactory.getLogger(HelloWorld.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(HelloString.getHello());
			log.info("an message");
	}

}
