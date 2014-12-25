package javaood.decoratorpattern;

public abstract class BurritoOptionalExtra implements Burrito {
	private final Burrito burrito;
	private final double price;
	
	protected  BurritoOptionalExtra(Burrito toDecorate, double myPrice) {
		burrito = toDecorate;
		price = myPrice;
	}
	
	public final double getPrice() {
		return burrito.getPrice() + price;
	}
}
