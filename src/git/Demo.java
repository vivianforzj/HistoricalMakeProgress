package git;

public class Demo {
	private String msg = "git demo";
	
	public Demo(){
		this.msg = "initialized!";
	}
	
	public void printMSG(){
		System.out.println(this.msg);
	}
	
	public static void main(){
		Demo d=new Demo();
		d.printMSG();
	}
}
