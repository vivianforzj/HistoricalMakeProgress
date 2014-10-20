package main.java.easy;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(-2398506));
	}
	
	public int reverse(int x) {
		StringBuffer sb = new StringBuffer();
		String temp = String.valueOf(Math.abs(x));
		
		for( int i = temp.length() - 1; i >= 0; i--) {
			sb.append(temp.charAt(i));
		}
		return x > 0 ? Integer.parseInt(sb.toString()) : -Integer.parseInt(sb.toString());
    }

}
