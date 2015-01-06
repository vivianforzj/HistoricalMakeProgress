package good.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		System.out.println(new PascalTriangle().generate(5));
	}
	
	public List<List<Integer>> generate(int numRows) {
		if (numRows < 0) return null;
		if (numRows == 0) return new ArrayList<List<Integer>>();
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> row = new  ArrayList<Integer>();
		row.add(1);
		result.add(row);
		
		for (int i = 1; i < numRows; i++) {
			row = new  ArrayList<Integer>();
			row.add(1);
			List<Integer> preList = result.get(i - 1);
			int preListLen = preList.size() - 1;  
			for (int j = 0; j < preListLen; j++) {
				row.add(preList.get(j) + preList.get(j + 1));
			}
			row.add(1);
			result.add(row);
		}
		
		return result;
    }
}
