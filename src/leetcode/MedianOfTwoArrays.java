package leetcode;

public class MedianOfTwoArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		// merge two arrays by 插入排序;假设A、B都是升序
		int merge[] = new int[A.length + B.length];
		int indexA = 0, indexB = 0;
		for (int i = 0; i < merge.length; i++) {
			if (indexA != A.length && indexB != B.length) {
				if (A[indexA] <= B[indexB])
					merge[i] = A[indexA++];
				else if (indexB < B.length)
					merge[i] = B[indexB++];
			} else if (indexA == A.length && indexB != B.length) {
				merge[i] = B[indexB++];
			} else
				merge[i] = A[indexA++];
			// System.out.println(i + ":\t" + merge[i]);
		}
		if (merge.length % 2 == 1)
			return merge[(merge.length - 1) / 2];
		else
			return (double) (merge[merge.length / 2] + merge[merge.length / 2 - 1]) / 2;
		// for (Integer a : merge)
		// System.out.print(a + "\t");

	}
	// public double findMedianSortedArrays(int A[], int B[]) {
	// //思想简单，但是好烦，不写了。。~~~~(>_<)~~~~
	// int all = A.length + B.length;
	// int medianIndex = (all % 2 == 1 ? (all - 1) / 2 : all / 2);
	// int nextIndex, i;
	// int pointerA = 0, pointerB = 0;
	// boolean a = false;
	// for (i = 0; i <= medianIndex; i++) {
	// if (pointerA != A.length && pointerB != B.length) {
	// if (A[pointerA] <= A[pointerB]) {
	// pointerA++;
	// if (i == medianIndex)
	// a = true;
	// } else {
	// pointerB++;
	// }
	// } else if (pointerA == A.length && pointerB != B.length) {
	// pointerB++;
	// } else {
	// pointerA++;
	// a = true;
	// ;
	// }
	// }
	// if (a) {
	// if (pointerA != A.length){
	// if (all % 2 == 1)
	// return A[medianIndex];
	// else {
	//
	// }
	// }
	// } else {
	//
	// }
	//
	// return 0;
	// }

}
