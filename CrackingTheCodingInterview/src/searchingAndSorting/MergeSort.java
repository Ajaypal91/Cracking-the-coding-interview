package searchingAndSorting;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] arr = {3,2,5,1,4};
		
		partition(arr, 0, arr.length-1);
		
		for (int x : arr)
			System.out.println(x);

	}
	
	private static void partition(int[] arr, int low, int high){
		
		if (low < high){
			
			int mid = low+(high-low)/2;
			partition(arr, low, mid);
			partition(arr, mid+1, high);
			merge(arr, low, mid, high);
			
		}
		
	}
	
	private static void merge(int[] arr, int low, int mid, int high){
		
		int n = arr.length;
		int first = low;
		int second = mid+1;
		int[] res = new int[n];
		int i = first;
		
		while(first <= mid && second <= high){
			
			if(arr[first]<arr[second]){
				res[i] = arr[first];
				first+=1;
			}
			else{
				res[i] = arr[second];
				second+=1;
			}
			i+=1;
		}
		
		while(first<=mid){
			res[i] = arr[first];
			first+=1;i+=1;
		}
		
		while(second<=high){
			res[i] = arr[second];
			second+=1;i+=1;
		}
		
		while(low<=high){
			arr[low] = res[low];
			low+=1;
		}
		
	}

}
