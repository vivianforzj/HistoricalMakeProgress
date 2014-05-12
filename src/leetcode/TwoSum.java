package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TwoSum {
//	public int[] twoSum(int[] numbers, int target) {
//		//问题：当输入非常大时效率太低
//		int[] indices = new int[2];
//		for(int i = 0;i<numbers.length-1;i++){
//			int add = target - numbers[i];
//			boolean found=false;
//			for(int j=i+1;j<numbers.length;j++){
//				if(add == numbers[j]){
//					indices[0]=i+1;
//					indices[1]=j+1;
//					found = true;
//					break;
//				}
//			}
//			if(found) break;
//		}
//		
//		return indices;
//	}
	public int[] twoSum(int[] numbers, int target) {
		int[] indices = new int[2];
		Set<Integer> origins = new HashSet<Integer>();
		HashMap<Integer,List<Integer>> originIndexMap = new HashMap<Integer,List<Integer>>();
		HashMap<Integer,Integer> addNumIndexMap = new HashMap<Integer,Integer>();
		for(int i=0;i<numbers.length;i++){
			origins.add(numbers[i]);
			int index = i+1;
			if(!originIndexMap.containsKey(numbers[i])){
				List<Integer> duplications = new LinkedList<Integer>();
				duplications.add(index);
				originIndexMap.put(numbers[i],duplications);
			}else
				originIndexMap.get(numbers[i]).add(index);
			
			addNumIndexMap.put(index, target-numbers[i]);
		}
		for(int i=1;i<=numbers.length;i++){
			int addNum = addNumIndexMap.get(i);
			if(addNum == numbers[i-1]){
				if(originIndexMap.get(addNum).size()<2)  continue;
				//有重复情况
				List<Integer> temp = originIndexMap.get(addNum);
				indices[0]= temp.get(0);
				indices[1]= temp.get(1);
//				System.out.println("hahaha\t"+indices[0]+" "+indices[1]+"\n\n");

				break;
			}
			if(origins.contains(addNum)){
				indices[0]=i;
				indices[1]=originIndexMap.get(addNum).get(0);
//				System.out.println("heihei\t"+indices[0]+" "+indices[1]+"\n\n");
				break;
			}
		}
		
		return indices;
	}
}
