package searchingAndSorting;

public class _0KthElement2SortedArrays {

	public static void main(String[] args) {
		
		int[] arr1 = {2,3,6,7,9};
		int[] arr2 = {1,4,8,10};
		int n1 = arr1.length;
		int n2 = arr2.length;
		int k = 8;
		
		System.out.println(kthElement(arr1, arr2, 0, 0, n1-1, n2-1, k));
		
	}
	
	
	private static int kthElement(int[] arr1, int[] arr2, int start1, int start2, int end1, int end2, int k) {
		
		if (k==1)
			return arr1[start1] < arr2[start2]?arr1[start1]:arr2[start2];
		if (k==2)
			return arr1[start1] > arr2[start2]?arr1[start1]:arr2[start2];
		if (start1 == end1) {
			if (arr1[start1]<arr2[start2])
				return arr2[start2+k-1];
			else
				return kthElement(arr1, arr2, start1, start2+1, end1, end2, k-1);
		}
		if (start2 == end2) {
			if(arr1[start1]>arr2[start2])
				return arr1[start1+k-1];
			else
				return kthElement(arr1, arr2, start1+1, start2, end1, end2, k-1);
		}
		int mid1 = (start1+end1)/2;
		int mid2 = (start2+end2)/2;
		
		if((mid1-start1+1)+(mid2-start2+1) == k)
			return arr1[mid1]>arr2[mid2]?arr1[mid1]:arr2[mid2];

		if ((mid1-start1+1)+(mid2-start2+1) < k) {
			if (arr1[mid1] < arr2[mid2]) {
				return kthElement(arr1, arr2, mid1+1, mid2, end1, end2, k-(mid1-start1+1)-(mid2-start2));
			}
			else {
				return kthElement(arr1, arr2, mid1, mid2+1, end1, end2, k-(mid2-start2+1)-(mid1-start1));
			}
		}
		else {
			if (arr1[mid1] > arr2[mid2])
				return kthElement(arr1, arr2, start1, start2, mid1, end2, k);
			else {
				return kthElement(arr1, arr2, start1, start2, end1, mid2, k);
			}
		}
		
	}

}
