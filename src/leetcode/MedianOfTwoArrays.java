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

	public double findMedianSortedArrays1(int A[], int B[]) {
		int all = A.length + B.length;
		int medianIndex = (all - 1) / 2;
		int pointerA = 0, pointerB = 0;
		boolean a = false;
		for (int i = 0; i <= medianIndex; i++) {
			if (pointerA != A.length && pointerB != B.length) {
				if (A[pointerA] < B[pointerB]) {
					pointerA++;
					if (i == medianIndex)
						a = true;
				} else if(A[pointerA] > B[pointerB]){
					pointerB++;
				}else{
					if(pointerA<A.length-2&&pointerB<B.length-2)
						if(A[pointerA+1]<=B[pointerB+1]){
							pointerA++;
							if (i == medianIndex)
								a = true;
						}else{
							//?????????????????????
						}
				}
			} else if (pointerA == A.length && pointerB != B.length) {
				pointerB++;
			} else {
				pointerA++;
				a = true;
			}
		}
		if (a) {
			if (all % 2 == 1)
				return A[pointerA - 1];
			else {
				if (pointerB == B.length)
					return (double) (A[pointerA - 1] + A[pointerA]) / 2;
				else {
					int smaller=0 ;
					if(pointerA!=A.length)
					 smaller = (A[pointerA] <= B[pointerB] ? A[pointerA]
							: B[pointerB]);
					else smaller = B[pointerB];
					return (double) (A[pointerA - 1] + smaller) / 2;
				}
			}
		} else {
			if (all % 2 == 1)
				return B[pointerB - 1];
			else {
				if (pointerA == A.length)
					return (double) (B[pointerB - 1] + B[pointerB]) / 2;
				else {
					int smaller=0 ;
					if(pointerB!=B.length)
						 smaller = (A[pointerA] <= B[pointerB] ? A[pointerA]
								: B[pointerB]);
						else smaller = A[pointerA];
					return (double) (B[pointerB - 1] + smaller) / 2;
				}
			}
		}

	}

}
