package javaood.decoratorpattern;

public class Test {
	public static void main(String[] args) {
		Burrito lunch = new Jalapeno(new SuperBurrito());
		System.out.println("lunch is " + lunch.getPrice());
	}
}
