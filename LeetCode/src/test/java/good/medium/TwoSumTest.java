package good.medium;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TwoSumTest {
	private static TwoSum ts;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ts = new TwoSum();
	}

	@Test
	public void test() {
		int[] numbers={2,4,3,8,9};
		int[] result = ts.twoSum(numbers, 12);
		assertEquals( 2,result[0]);
		assertEquals(4,result[1]);
		
		int[] numbers1={1,4,3,3,9};
		result = ts.twoSum(numbers1, 6);
		assertEquals(3,result[0]);
		assertEquals(4,result[1]);
		
		int[] numbers2={3,2,4};
		result = ts.twoSum(numbers2, 6);
		assertEquals(2,result[0]);
		assertEquals(3,result[1]);
	}
}
