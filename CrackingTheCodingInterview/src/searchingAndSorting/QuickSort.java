package searchingAndSorting;

public class QuickSort {

	public static void main(String[] args) {

		int[] arr = {3,2,5,1,4, 6, 1, 1};
		
		quickSort(arr, 0, arr.length-1);
		
		for (int x : arr)
			System.out.println(x);
	}
	
	private static void quickSort(int[] arr, int low, int high) {
		if (low<high) {
			int p = partition(arr,low,high);
			quickSort(arr, low, p-1);
			quickSort(arr, p+1, high);
		}
	}
	
	private static int partition(int[] arr, int low, int high) {
		
		int end = high;
		int pivot = arr[high];
		high-=1;
		while(low<high) {
			
			while(low <= high && arr[low] < pivot)
				low+=1;
			while(high >= low && arr[high] > pivot)
				high-=1;
			if(low<high) {
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				low+=1;high-=1;
			}
			
		}
		if (arr[low] > pivot) {
			int temp = arr[low];
			arr[low] = pivot;
			arr[end] = temp;
		}
		return low;
	}

}
