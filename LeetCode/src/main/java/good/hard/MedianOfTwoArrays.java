package good.hard;

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

}
