package geeks4geeks.arraysAndStrings;

//https://www.geeksforgeeks.org/find-subarray-with-given-sum/
public class _10SubArrayWithGivenSumNonNegative {

	public static void main(String[] args) {
		
		int[] arr = {1, 4, 20, 3, 10, 5};
		int sum = 33;
		System.out.println(isSumPresent(arr,sum));
	}
	
	public static boolean isSumPresent(int[] nums, int sum){
		
		if(nums.length == 0)
			return false;
		int currSum = 0;
		
		int start = 0;
		for(int i = 0; i < nums.length;i++){
			
			currSum += nums[i];
			
			while(currSum > sum && start < i){
				currSum -= nums[start];
				start++;
			}
			
			if(currSum == sum)
				return true;
		}
		
		
		return false;
	}

}
