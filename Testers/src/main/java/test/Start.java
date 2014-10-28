package main.java.test;

import main.java.test.a.TestA;
import main.java.test.b.TestB;
import main.java.test.c.TestC;
import main.java.test.d.TestD;

public class Start {
	 public static void main(String[] args) {
		 String URL = "D://Git//HistoricalMakeProgress//Testers//logback.xml";
		    System.out.println(ClassLoader.getSystemResource(URL));

		    while(true) {
		    	 TestA a = new TestA();
			        TestB b = new TestB();
			        TestC c = new TestC();
			        TestD d = new TestD();
		    }
	       
	    }
}
