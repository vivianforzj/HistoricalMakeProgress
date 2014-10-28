package easy;

public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(new PalindromeNumber().isPalindrome(222));
	}


    public boolean isPalindrome(int x) {
    	if (x < 0) return false;
    	if (x < 10) return true;
    	long result = 0;
    	int temp = x;
    	while (x > 0) {
    		result = result * 10 + x % 10;
    		x /= 10;
    	}
    	if (temp == result) return true;
		return false;
    }

}
