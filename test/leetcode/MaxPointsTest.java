package leetcode;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class MaxPointsTest {
	private static MaxPoints mp ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mp = new MaxPoints();
	}

	@Test
	public void testMaxPoints() {
		Point[] points = new Point[3];
		points[0] = new Point(2, 3);
		points[1] = new Point(3, 3);
//		points[2] = new Point(3, 1);
		points[2] = new Point(-5, 3);
		assertEquals(3,mp.getMaxPoints(points));
		
		Point[] points1 = new Point[7];
		points1[0] = new Point(2, 2);
		points1[1] = new Point(2, 4);
		points1[2] = new Point(3, 3);
		points1[3] = new Point(4, 2);
		points1[4] = new Point(1, 1);
		points1[5] = new Point(3, 2);
		points1[6] = new Point(5, 2);
		assertEquals(4,mp.getMaxPoints(points1));
		
		Point[] points2 = new Point[4];
		points2[0] = new Point(0, 0);
		points2[1] = new Point(1, 1);
		points2[2] = new Point(1, -1);
		points2[3] = new Point(-1, -1);
		assertEquals(3,mp.getMaxPoints(points2));
	}

}
