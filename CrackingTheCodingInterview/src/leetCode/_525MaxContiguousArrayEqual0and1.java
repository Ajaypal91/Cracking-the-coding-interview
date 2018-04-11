package leetCode;

import java.util.HashMap;
import java.util.Map;

public class _525MaxContiguousArrayEqual0and1 {

	public static void main(String[] args) {
		
		int[] nums = {0,0,0,1,0,0,0,0,1};
		System.out.println(findMaxLength(nums));
	}
	
	public static int findMaxLength(int[] nums){
		
		int maxLen = 0;
		
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		
		for(int i = 0; i < nums.length; i ++){
			
			if(nums[i] == 0 )
				sum-=1;
			else
				sum+=1;
			
			if(sum == 0)
				maxLen = i+1;
			
			if(map.containsKey(sum)){
				maxLen = Math.max(maxLen, i-map.get(sum));
			}
			else{ //it is in else because we want to keep firs occurance to find maxLen substring
				map.put(sum, i);
			}
		}
		
		
		return maxLen;
	}

}
