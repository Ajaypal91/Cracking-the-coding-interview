package geeks4geeks.recurrssionDP;

public class LongestIncreasingSubSeq {

	public static void main(String[] args) {
	
		int[] nums = {3, 10, 2, 1, 20};
		
		System.out.println(LIS(nums));
	}
	
	
	private static int LIS(int[] nums){
		
		int result = Integer.MIN_VALUE;
		
		if(nums.length == 0)
			return 0;
		
		int[] temp = new int[nums.length];
		
		temp[0] = 1;
		
		for(int i = 1; i < nums.length; i++){
			
			temp[i] = 1;
			
			for(int j = i-1; j >=0; j--){
				
				if(nums[j] < nums[i]){
					temp[i] = Math.max(temp[i], temp[j]+1);
				}
				
			}
			
			result = Math.max(temp[i], result);
		}
		
		
		return result;
	}

}
