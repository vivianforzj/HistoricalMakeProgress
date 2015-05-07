package good.easy;

import java.util.HashSet;

public class HappyNumber {
	public boolean isHappy(int n) {
		boolean isOne = false;
		long temp = n;
		HashSet<Long> set = new HashSet<>();
		do{
			String num_str = String.valueOf(temp);
			temp = 0;
			int len = num_str.length();
			for (int i = 0; i < len; i++) {
				temp += (int)Math.pow(Integer.valueOf(num_str.substring(i, i + 1)), 2);
			}
			if (set.contains(temp))
				return false;
			
			if (temp == 1)
				isOne = true;
			
			set.add(temp);
		} while(!isOne);
		
		
		return true;
    }
	
	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(2));
	}
}
