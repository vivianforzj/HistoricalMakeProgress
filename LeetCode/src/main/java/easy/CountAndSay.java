package easy;

import java.util.LinkedList;

public class CountAndSay {
	
	public static void main(String[] args) {
		String re  = new CountAndSay().countAndSay(6);
		System.out.println(re);
	}

    public String countAndSay(int n) {
    	LinkedList<Integer> current = new LinkedList<Integer>();
    	LinkedList<Integer> next = new LinkedList<Integer>();
        current.add(1);
        
        if (n == 1) {
        	return "1";
        }
        
		for (int i = 1; i < n; i++) {
			int pointer = current.get(0), nextNum;
			int count = 1, length = current.size();
			for (int j = 1; j < length; j++) {
				nextNum = current.get(j);
				if (pointer != nextNum) {
					next.add(count);
					next.add(pointer);
					count = 1;
					pointer = nextNum;
					if (j == length - 1) {
						next.add(count);
						next.add(pointer);
					}
				}
				else {
					count++;
					if (j == length - 1) {
						next.add(count);
						next.add(pointer);
					}
				}
			}
			if (length == 1) {
				next.add(1);
				next.add(1);
			}
			current.clear();
			current.addAll(next);
			next.clear();
		}
    	
		String result = "";
		for (Integer in: current) {
			result += in;
		}
		
    	return result;
    }

}
