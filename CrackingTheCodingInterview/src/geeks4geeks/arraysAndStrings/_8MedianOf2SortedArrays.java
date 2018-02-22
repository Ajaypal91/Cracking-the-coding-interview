package geeks4geeks.arraysAndStrings;


//https://www.geeksforgeeks.org/median-of-two-sorted-arrays/
public class _8MedianOf2SortedArrays {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 6};
		int[] arr2 = {4, 6, 8, 10};
		
		System.out.println(medianOfArrays(arr1, arr2, 0, 0, arr1.length-1, arr1.length-1));
	}
	
	private static float getMedian(int[] arr, int start, int end) {
		int mid = (start+end)/2;
		if (((end-start)+1)%2 == 0) {
			return (float) ((arr[mid]+arr[mid+1])/2.0);
		}
		else
			return arr[mid];
	}

	private static float medianOfArrays(int[] arr1, int[] arr2, int start1 , int start2, int end1, int end2) {
		
		if (((end1-start1)+1) == 0)
			return 0;
		
		if (((end1-start1)+1) == 2)
		{
			return (Math.max(arr1[start1], arr2[start2])+Math.min(arr1[start1+1], arr2[start2+1]))/2;
		}
		
		float m1 = getMedian(arr1, start1, end1);
		float m2 = getMedian(arr2, start2, end2);
		
		if(m1 == m2)
			return m1;
	
		int mid1 = (start1+end1)/2;
		int mid2 = (start2+end2)/2;
		if (m1 > m2) {
			if (((end1-start1)+1)%2 == 0) {
				return medianOfArrays(arr1, arr2, start1, mid2, mid1+1, end2);
			}
			else {
				return medianOfArrays(arr1, arr2, start1, mid2, mid1, end2);
			}
			
		}
		else {

			if (((end1-start1)+1)%2 == 0) {
				return medianOfArrays(arr1, arr2, mid1, start2, end1, mid2+1);
			}
			else {
				return medianOfArrays(arr1, arr2, mid1, start2, end1, mid2);
			}
		}
		
		
	}
	
}
