package good.easy;

import java.util.HashMap;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = {"","abc", "abcd", ""};
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
	}
	
	public String longestCommonPrefix(String[] strs) {
		if (strs == null) return null; 
		else if (strs.length == 0) return "";
        HashMap<Integer, Character> preMap = null;
        for(String str : strs) {
        	if (preMap == null) {
        		preMap = new HashMap<Integer, Character>();
        		int index = 0;
        		for (char ch : str.toCharArray()) {
        			preMap.put(index++, ch);
        		}
        	} else {
        		int i = 0, mapLength = preMap.size();
        		for (char ch : str.toCharArray()) {
        			if (i < mapLength) {
        				if (preMap.get(i) == ch) {
        					i++;
        				}
        				else break;
        			}
        		}
        		for ( ; i < mapLength; i++)
        			preMap.remove(i);
        	}
        }
        StringBuilder sb = new StringBuilder();
        int len = preMap.size();
        for (int i = 0 ; i < len; i++)
        	sb.append(preMap.get(i));
        
		return sb.toString();
    }
}
