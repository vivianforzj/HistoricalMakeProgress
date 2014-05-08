package git;

public class Demo {
	private String msg = "git demo";
	
	public Demo(){
		this.msg = "initialized!";
	}
	
	public void printMSG(){
		System.out.println(this.msg);
	}
	
	public static void main(String[] args) {
		Demo d=new Demo();
		d.printMSG();
	}
}
