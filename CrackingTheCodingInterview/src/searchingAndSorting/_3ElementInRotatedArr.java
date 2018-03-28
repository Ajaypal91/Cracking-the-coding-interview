package searchingAndSorting;

public class _3ElementInRotatedArr {

	public static void main(String[] args) {
		
		int[] arr = {1};
		int k = 0;
		System.out.println(findElement(arr, 0, arr.length-1, k));
	}
	
	private static int findElement(int[] arr, int start, int end, int k) {
		
		if(start > end) {
			return -1;
		}
		//in case of 1 elements
		if(start == end)
			return arr[start] == k ? start : -1;
		
		int mid = (start+end)/2;
	
		if (arr[mid] == k)
			return arr[mid];
		
		if(arr[mid] > arr[start]) {
			if(k >= arr[start] && k < arr[mid])
				return findElement(arr, start, mid-1, k);
			else
				return findElement(arr, mid+1, end, k);
		}
		else if(arr[mid] < arr[end]) {
			if (k > arr[mid] && k <= arr[end])
				return findElement(arr, mid+1, end, k);
			else
				return findElement(arr, start, mid-1, k);
		}
		else { //check for continuous repeating elements
			if(arr[mid] == arr[start] && arr[mid] == arr[end]) {
				int left = findElement(arr, start, mid, k);
				int right = findElement(arr, mid, end, k);
				return left == k ? left : right;
			}
			else if(arr[mid] == arr[start]) {
				return findElement(arr, mid+1, end, k);
			}
			else
				return findElement(arr, start, mid-1, k);
			
		}
		
		
	}

}
