package leetCode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/description/

//If list does not contains duplicates

/*
 * MUST CHECK
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
public class _46Permutations {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3};

		System.out.println(permute(nums));
		
	}
	
	public static List<List<Integer>> permute(int[] nums) {
        return permutation(nums, 0);
    }
	
	
	public static List<List<Integer>> permutation(int[] nums, int start) {
    
		List<List<Integer>> result = new ArrayList<>();
		
		if(nums.length-1 == start){
			List<Integer> temp = new ArrayList<>();
			temp.add(nums[start]);
			result.add(temp);
			return result;
		}
			
		
		int first = nums[start];
		List<List<Integer>> remaining = permutation(nums, start+1);
		
		for(List<Integer> temp : remaining){
			result.addAll(addToList(temp, first));
		}
		
		return result;
    }
	
	
	public static List<List<Integer>> addToList(List<Integer> arr, int value){
		
		List<List<Integer>> result = new ArrayList<>();
		
		for(int i = 0; i <= arr.size(); i++){
			List<Integer> temp = new ArrayList<>(arr);
			temp.add(i,value);
			result.add(temp);
		}
		
		return result;
	}
	
	

	

}
