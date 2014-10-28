package medium;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class RPNEvaluatorTest {
	private static RPNEvaluator rpn;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rpn = new RPNEvaluator();
	}

	@Test
	public void testEvalRPN() {
		String s1 = "2 1 + 3 *";
		String s2 = "4 13 5 / +";
		String s3 = "3 -4 +";
		String s4 = "3 +";
		assertEquals(9,rpn.evalRPN(s1.split(" ")));
		assertEquals(6,rpn.evalRPN(s2.split(" ")));
		assertEquals(-1,rpn.evalRPN(s3.split(" ")));
		assertEquals(Integer.MIN_VALUE,rpn.evalRPN(s4.split(" ")));
	}

}
