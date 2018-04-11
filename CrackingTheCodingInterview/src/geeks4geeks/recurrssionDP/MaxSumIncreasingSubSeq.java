package geeks4geeks.recurrssionDP;


//https://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
public class MaxSumIncreasingSubSeq {

	public static void main(String[] args) {
		
		int[] arr = {3, 4, 5, 10};
		
		System.out.println(maxSum(arr));

	}
	
	private static int maxSum(int[] nums){
		
		int result = Integer.MIN_VALUE;
		
		if(nums.length == 0)
			return 0;
		
		int[] temp = new int[nums.length];
		temp[0] = nums[0];
		
		
		for(int i = 1; i < nums.length; i++){
			
			temp[i] = nums[i];
			for(int j = i-1; j >= 0; j--){
				
				if(nums[j] < nums[i]){
					temp[i] = Math.max(temp[i], nums[i] + temp[j]);
				}
				
			}
			
			result = Math.max(result, temp[i]);
		}
		
		return result;
	}
}
