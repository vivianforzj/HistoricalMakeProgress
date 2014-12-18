package javaood;

public class PassByValue {

	public static void main(String[] args) {
		Circle c = new Circle(2);
		change(c);
		System.out.println(c.getRadius());
	}
	
	private static void change(Circle c) {
		c = new Circle(3);
	}

	public static class Circle {
		int radius;
		
		public Circle(int rad) {
			this.radius = rad;
		}
		
		public int getRadius() {
			return this.radius;
		}
	}

}
