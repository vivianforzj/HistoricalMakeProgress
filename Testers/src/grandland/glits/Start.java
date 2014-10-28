package grandland.glits;

import grandland.glits.business.base.TestA;
import grandland.glits.business.processor.sync.TestC;
import grandland.glits.business.processor.sync.abnormalBehaviorAnalysis.TestB;
import grandland.glits.core.TestD;

public class Start {
	 public static void main(String[] args) throws InterruptedException {

		    while ( true) {
		    	TestA a = new TestA();
		        TestB b = new TestB();
		        TestC c = new TestC();
		        TestD d = new TestD();
		    }
	        
	    }
}
