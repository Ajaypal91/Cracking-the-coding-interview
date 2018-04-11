package leetCode;

import java.util.Arrays;

public class _561ArrayPartition1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,4,3,2};
		System.out.println(arrayPairSum(nums));
	}
	
	public static int arrayPairSum(int[] nums) {
        if(nums.length == 0 || nums.length%2 != 0)
            return 0;
        
        Arrays.sort(nums);
        int sum = 0; 
        for(int i = 0; i < nums.length; i+=2){
            sum+=nums[i];
        }
        
        return sum;
    }

}
