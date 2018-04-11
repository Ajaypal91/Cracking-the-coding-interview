package geeks4geeks.arraysAndStrings;

//https://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
public class _11MaxOccuringELementO1Space {

	public static void main(String[] args) {
		
		int arr[] = {2, 3, 3, 5, 3, 4, 1, 7};
		int k = 8;
		System.out.println(maxReapeting(arr, arr.length, k));
	}
	
	
	public static int maxReapeting(int[] arr, int n , int k){
		
		int max = 0;
		int maxIndex = 0;
		for(int i = 0; i< n; i++){
			arr[arr[i]%k]+=k;
		}
		
		for(int i =0; i < n; i++){
			if(arr[i] > max){
				max = arr[i];
				maxIndex = i;
			}
		}
		
		
		return maxIndex;
	}
}
