package hard;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MaxPoints {

	public static void main(String[] args) {
		MaxPoints mp = new MaxPoints();
		Point[] points = new Point[3];
		points[0] = new Point(2, 3);
		points[1] = new Point(3, 3);
//		points[2] = new Point(3, 1);
		points[2] = new Point(-5, 3);
		// 经过两次失败的尝试啊。MD
		 System.out.println(mp.getMaxPoints(points));
	}

	public int getMaxPoints(Point[] points) {
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			if(points.length - i <= max) break;
			System.out.println("\npoint "+i+"\t: ("+points[i].x+","+points[i].y+")");
			HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
			int zeroX = 0;
			int duplication = 1;
			for (int j = i + 1; j < points.length; j++) {
				int y = points[j].y - points[i].y;
				int x = points[j].x - points[i].x;
				if (x == 0 && y == 0) {
					duplication++;
					continue;
				}
				if (x == 0 && y != 0) {// 与纵轴平行的直线上的点
					zeroX++;
					continue;
				}
				double key = Math.tan((double) y / (double) x);
				if(key==0) key = Math.abs(key);
				if (hm.containsKey(key)) {
					hm.put(key, hm.get(key) + 1);
				} else {
					hm.put(key, 1);
				}
			}
			int tempMax = 0;
			for (Map.Entry<Double, Integer> map : hm.entrySet()) {
				tempMax = map.getValue() > tempMax ? map.getValue() : tempMax;
				System.out.println(map.getKey()+"\t"+map.getValue());
				// hm.put(map.getKey(), map.getValue()+duplication);
			}
			System.out.println("zeroX:\t"+zeroX+"\tduplication:\t"+duplication);
			
			tempMax = zeroX > tempMax ? zeroX : tempMax;
			tempMax += duplication;
			max = max > tempMax ? max : tempMax;
		}
		return max;
	}

	private int mPoints(Point[] points) {
		HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
		HashMap<Double, List<Point>> group = new HashMap<Double, List<Point>>();

		HashMap<Double, List<Point>> tanIs0 = new HashMap<Double, List<Point>>();// 存储与横轴平行的直线
		HashMap<Double, List<Point>> tanIsInfinity = new HashMap<Double, List<Point>>();// 纵轴平行的直线

		for (Point p : points) {
			if (tanIs0.containsKey(p.x)) {
				tanIs0.get(p.x).add(p);
			} else {
				List<Point> s = new LinkedList<Point>();
				s.add(p);
				group.put((double) p.x, s);
			}

			if (tanIsInfinity.containsKey(p.y)) {
				tanIsInfinity.get(p.y).add(p);
			} else {
				List<Point> s = new LinkedList<Point>();
				s.add(p);
				group.put((double) p.y, s);
			}

			double key = Math.tan((double) p.y / (double) p.x);
			if (hm.containsKey(key)) {
				hm.put(key, hm.get(key) + 1);
				group.get(key).add(p);
				// 放到与横轴和纵轴分别平行的情况中
				if (hm.containsKey(-2)) {
					hm.put((double) -2, hm.get(-2) + 1);
					group.get(-2).add(p);
				} else {
					hm.put((double) -2, 1);
					List<Point> s = new LinkedList<Point>();
					s.add(p);
					group.put((double) -2, s);
				}
				if (hm.containsKey(0)) {
					hm.put((double) 0, hm.get(0) + 1);
					group.get(0).add(p);
				} else {
					hm.put((double) 0, 1);
					List<Point> s = new LinkedList<Point>();
					s.add(p);
					group.put((double) 0, s);
				}
			} else {
				hm.put(key, 1);
				List<Point> s = group.get(key);
				s.add(p);
				group.put(key, s);
			}
		}

		int max = 0;
		for (Map.Entry<Double, Integer> map : hm.entrySet()) {
			// 还要判断0，0是否应该加入每个里面
			double key = map.getKey();
			int value = map.getValue();
			if (key == -1) {
				max = max > value ? max : value;
				continue;
			}
			if (key == -2) {
				value += hm.get(-1);
				max = max > value ? max : value;
				continue;
			}
			if (map.getValue() >= 2) {// 说明至少有两个点，判断这条线是不是过原点
				List<Point> s = group.get(key);
				// 取其中任意两个
				Point[] p = new Point[2];
				for (int i = 0; i < 2; i++) {
					p[i] = s.get(i);
				}
				if (Math.tan((double) p[0].y / (double) p[0].x) == Math
						.tan((double) (p[0].y - p[1].y)
								/ (double) (p[0].x - p[1].y))) {
					value += hm.get(-1);
				}
			}
			max = max > value ? max : value;
		}

		return max;
	}

	public int maxPoints(Point[] points) {
		int[] maxXY = getMaxXY(points);
		int lines = maxXY[0] + 1, columns = maxXY[1] + 1;
		boolean array[][] = new boolean[lines][columns];
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (Point p : points) {
			System.out.println(p.x + "\t" + p.y);
			array[p.x][p.y] = true;
			String key = String.valueOf(p.x) + String.valueOf(p.y);
			if (!hm.containsKey(key))
				hm.put(key, 1);
			else {
				int value = hm.get(key);
				hm.put(key, value + 1);
			}
		}
		// for (boolean[] a : array) {
		// for (boolean b : a)
		// System.out.print(b + "\t");
		// System.out.println();
		// }
		// System.out.println(hm.size());
		int max = 0;
		boolean[] visited = new boolean[points.length];
		int index = 0;
		for (Point p : points) {
			// System.out.println("point:\t" + p.x + "\t" + p.y);
			if (visited[index++])
				continue;
			int Max = 1;
			// 行不变，列加
			int duplicatePoints = getDup(p, points, visited, hm);
			int tempMax = duplicatePoints;
			for (int j = p.y + 1; j < columns; j++) {
				if (array[p.x][j])
					tempMax += hm.get(String.valueOf(p.x) + String.valueOf(j));
			}
			Max = tempMax > Max ? tempMax : Max;
			// System.out.println("行:\t" + tempMax);
			tempMax = duplicatePoints;

			// 列不变，行变
			for (int j = p.x + 1; j < lines; j++) {
				if (array[j][p.y])
					tempMax += hm.get(String.valueOf(j) + String.valueOf(p.y));
			}
			Max = tempMax > Max ? tempMax : Max;
			// System.out.println("列:\t" + tempMax);
			tempMax = duplicatePoints;

			// 右下45度
			for (int i = p.x + 1; i < lines; i++) {
				int t = duplicatePoints;
				for (int j = p.y + 1; j < columns;)
					if (array[i][j]) {
						t += hm.get(String.valueOf(i) + String.valueOf(j));
						j += j - p.y;
					}
				// tempMax =
			}
			Max = tempMax > Max ? tempMax : Max;
			// System.out.println("右下:\t" + tempMax);
			tempMax = duplicatePoints;

			// 左下45度
			for (int i = p.x + 1, j = p.y - 1; i < lines && j >= 0; i++, j--) {
				if (array[i][j])
					tempMax += hm.get(String.valueOf(i) + String.valueOf(j));
			}
			Max = tempMax > Max ? tempMax : Max;
			// System.out.println("左下:\t" + tempMax + "\n\n");

			max = Max > max ? Max : max;
		}

		if (max <= 1 && points.length > 1)
			return 2;
		if (hm.size() == 2 && points.length != 2) {
			int newMax = 0;
			for (Map.Entry<String, Integer> map : hm.entrySet())
				newMax += map.getValue();
			return newMax;
		}

		return max;
	}

	private int getDup(Point p, Point[] points, boolean[] visited,
			HashMap<String, Integer> hm) {
		for (int i = 0; i < points.length; i++)
			if (p != points[i] && p.x == points[i].x && p.y == points[i].y) {
				visited[i] = true;
			}
		return hm.get(String.valueOf(p.x) + String.valueOf(p.y));
	}

	private int[] getMaxXY(Point[] points) {
		int[] max = new int[2];
		int[] min = new int[2];
		max[0] = max[1] = 0;
		min[0] = min[1] = 0;
		for (Point p : points) {
			if (max[0] < p.x)
				max[0] = p.x;
			if (max[1] < p.y)
				max[1] = p.y;
			if (min[0] > p.x)
				min[0] = p.x;
			if (min[1] > p.y)
				min[1] = p.y;
		}
		int minXabs = Math.abs(min[0]);
		int minYabs = Math.abs(min[1]);
		if (minXabs + minYabs != 0) {
			for (Point p : points) {
				p.x += minXabs;
				p.y += minYabs;
			}
			max[0] += minXabs;
			max[1] += minYabs;
		}

		return max;
	}
	
}
