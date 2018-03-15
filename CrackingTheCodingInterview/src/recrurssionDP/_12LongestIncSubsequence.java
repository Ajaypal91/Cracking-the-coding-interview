package recrurssionDP;

//https://www.geeksforgeeks.org/longest-increasing-subsequence/
public class _12LongestIncSubsequence {

	public static void main(String[] args) {
		
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
		
		System.out.println(LIS(arr));
		
	}
	
	private static int LIS(int[] arr) {
		
		int n = arr.length;
		if(n == 1)
			return 1;
		
		int[] lis = new int[n];
		lis[0] = 1;
		
		for (int i = 1 ; i < n; i++) {
			int maxSoFar = 0;
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j])
					maxSoFar = Math.max(maxSoFar, lis[j]);
			}
			lis[i] = 1+maxSoFar;
			
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int x : lis)
			max = Math.max(max, x);
		
		
		return max;
	}

}
