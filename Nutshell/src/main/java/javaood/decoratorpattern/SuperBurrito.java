package javaood.decoratorpattern;

public class SuperBurrito implements Burrito{
	private static final double PRICE = 6.99;
	
	@Override
	public double getPrice() {
		return PRICE;
	}
}
