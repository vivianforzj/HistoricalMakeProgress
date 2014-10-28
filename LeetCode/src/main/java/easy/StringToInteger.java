package main.java.easy;

public class StringToInteger {

	public static void main(String[] args) {
		System.out.println(new StringToInteger().atoiNew("-10955046576868789792506p8"));
	}
	
	private int atoiNew(String str) {
		 if (str == null || str.trim().length() == 0)
			 return 0;
		 str = str.trim();		 
		 if (str.startsWith("-")) {
			 String convertedPart = getPureString(str.substring(1));
			 int length = convertedPart.length();
			 long result = getNum(convertedPart, length);
			 if (result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
			 else return -((int)result);
		 }  else if (Character.isDigit(str.charAt(0)) || str.startsWith("+")) {
			 String convertedPart = null;
			 if (Character.isDigit(str.charAt(0)))
			 	convertedPart = getPureString(str);
			 else
				 convertedPart = getPureString(str.substring(1));
			 int length = convertedPart.length();
			 long result = getNum(convertedPart, length);
			 if (result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
			 else return (int) result;
		 }
		 return 0;
	}

	public final static String max_value = String.valueOf(Integer.MAX_VALUE);
	public final static String min_value = String.valueOf(Integer.MIN_VALUE).substring(1);
	public final static int max_length = max_value.length();
	
	 public int atoi(String str) {//可以直接取结果存储到long型变量中，然后再判断。此处判断各种长度神马的忒麻烦恶心了点儿╭(╯3╰)╮
		 if (str == null || str.trim().length() == 0)
			 return 0;
		 str = str.trim();		 
		 if (str.startsWith("-")) {
			 String convertedPart = getPureString(str.substring(1));
			 int length = convertedPart.length();
			 if (convertedPart.equals(min_value)) return Integer.MIN_VALUE;
			 if (length > max_length) return Integer.MIN_VALUE;
			 else if (length == max_length) {
				 if (isLarger(convertedPart, min_value)) return Integer.MIN_VALUE;
				 else return -getNum(convertedPart, length);
			 } else {
				 return -getNum(convertedPart, length);
			 }
		 } else if (Character.isDigit(str.charAt(0)) || str.startsWith("+")) {
			 String convertedPart = null;
			 if (Character.isDigit(str.charAt(0)))
			 	convertedPart = getPureString(str);
			 else
				 convertedPart = getPureString(str.substring(1));
			 int length = convertedPart.length();
			 if (length > max_length) return Integer.MAX_VALUE;
			 else if (length == max_length) {
				 if (isLarger(convertedPart, max_value)) return Integer.MAX_VALUE;
				 else return getNum(convertedPart, length);
			 } else {
				 return getNum(convertedPart, length);
			 }
		 } 
		 
		 return 0;
	 }

	private String getPureString(String str) {
		String convertedPart = "";
		 int length = str.length();
		 for (int i = 0; i < length && Character.isDigit(str.charAt(i)); i++) {
			 convertedPart += str.charAt(i);
		 }
		 return convertedPart;
	}

	private boolean isLarger(String convertedPart, String value) {
		for (int i = 0; i < max_length; i++) {
			if (convertedPart.charAt(i) < value.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	private int getNum(String convertedPart, int length) {
		 int result = 0;
		 for (int i = 0; i < length; i++) {
			 result += Character.getNumericValue(convertedPart.charAt(i)) * Math.pow(10, length - i -1);
		 }
		 return result;
	}

}
