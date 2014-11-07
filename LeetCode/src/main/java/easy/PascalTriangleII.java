package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

	public static void main(String[] args) {
		System.out.println(new PascalTriangleII().getRow(3));
	}

	public List<Integer> getRow(int rowIndex) {
		 if (rowIndex < 0) return null;
		 
		 List<Integer> result = new ArrayList<Integer>();
		 List<Integer> temp = new ArrayList<Integer>();
		 result.add(0);
		 result.add(1);
		 result.add(0);
		 
		 for (int i = 1; i <= rowIndex; i++) {
			 temp.add(0);
			 for (int j = 0; j < result.size() - 1; j++) {
				 temp.add(result.get(j) + result.get(j + 1));
			 }
			 temp.add(0);
			 result = temp;
			 temp = new ArrayList<Integer>();
		 }
		 
		 return result.subList(1, result.size() - 1);
	 }
}
