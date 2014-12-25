package javaood.singleton;

public class Singleton {
	private final static Singleton instance = new Singleton();
	private static boolean state = false;
	
	private void init() {
		//do initialization
	}
	
	public static synchronized Singleton getInstance() {
		if (state) return instance;
		instance.init();
		state = true;
		return instance;
	}
	
	public static void main(String[] args) {
		Singleton.getInstance();
	}
}
