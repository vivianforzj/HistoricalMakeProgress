package main.java.easy;

public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(new ValidPalindrome().isPalindrome("1aA2"));
	}

	public boolean isPalindrome(String s) {
		int len = s.length();
		for (int i = 0, j = len - 1; i < len && j >= 0; ) {
			if (i >= j) return true;
			if (isValidChar(s, i) && isValidChar(s, j)) {
				if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
					i++;
					j--;
					continue;
				}
				else return false;
			} else if (!isValidChar(s, i) && isValidChar(s, j)) {
				i++; 
			} else if (isValidChar(s, i) && !isValidChar(s, j)) {
				j--;
			} else {
				i++;
				j--;
			}
		}
		
		return true;
	}

	private boolean isValidChar(String s, int i) {
		return Character.isLetterOrDigit(s.charAt(i));
	}

	public boolean isPalindrome_old(String s) {
		if (s == null) return false;
		if (s.trim().length() == 0) return true;
		
		s = getFilteredString(s);
		if (s == null) return false;
		else {
			return isPali(s);
		}
	}

	private boolean isPali(String str) {
		int len = str.length();
		for (int i = 0; i < len/2; i++) {
			if (str.charAt(i) == str.charAt(len - i - 1))
				continue;
			else return false;
		}
		
		return true;
	}

	private String getFilteredString(String str) {
		String temp = "";
		for (Character cha : str.toCharArray()) 
			if (Character.isLetter(cha)) 
				temp += Character.toString(Character.toLowerCase(cha));
		
		return temp;
	}

}
