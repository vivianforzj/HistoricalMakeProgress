package main.java.easy;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(new ReverseInteger().reverse(1000000003));
		System.out.println(new ReverseInteger().reverseFool(1000000003));
	}
	
	private int reverse(int i) {
		long result = 0;
		while (i != 0) {
			result = result * 10 + i % 10;
			i /= 10;
		}
		if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
		return (int) result;
	}

	public int reverseFool(int x) {
		StringBuffer sb = new StringBuffer();
		String temp = String.valueOf(Math.abs(x));
		
		for( int i = temp.length() - 1; i >= 0; i--) {
			sb.append(temp.charAt(i));
		}
		long result = x > 0 ? Long.parseLong(sb.toString()) : -Long.parseLong(sb.toString());
		if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
		return (int) result;
    }

}
