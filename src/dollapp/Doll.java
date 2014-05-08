package dollapp;

/**
 * @author hellouniverse
 * 
 */
public class Doll extends Base{
	
	String var = "DollVar";
	static String staticVar = "StaticDollVar";
	
	void method(){
		System.out.print("Doll method\n");
	}
	
	static void staticMethod(){
		System.out.print("Static Doll method\n");
	}
	
	public static void main(String[] args){
		Base b = new Doll();
		System.out.println(b.var);
		System.out.println(b.staticVar);
		b.method();
		b.staticMethod();
	}
}

class Base{
	String var = "BaseVar";
	static String staticVar = "StaticBaseVar";
	
	void method(){
		System.out.print("Base method\n");
	}
	
	static void staticMethod(){
		System.out.print("Static Base method\n");
	}
}
