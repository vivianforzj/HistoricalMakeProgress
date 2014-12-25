package javaood.decoratorpattern;

public class StandardBurrito implements Burrito{
	private static final double PRICE = 5.99;
	
	@Override
	public double getPrice() {
		return PRICE;
	}
}
