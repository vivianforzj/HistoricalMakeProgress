package javaood.decoratorpattern;

public class Jalapeno extends BurritoOptionalExtra{
	private final static double MYPRICE = 4;
	
	public Jalapeno(Burrito toDecorate) {
		super(toDecorate, MYPRICE);
	}

}
