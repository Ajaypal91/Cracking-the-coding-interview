package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum/description/
//This is attempt 2

public class _39_2CombinationSum {

	public static void main(String[] args) {
		
		int[] arr = {2, 3, 6, 7};
		int target = 7;
		
		System.out.println(combinationSum(arr, target));
		
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		Arrays.sort(candidates);
//		Method1
//		return combinations(candidates, target, 0);
		
		//Method2
		List<List<Integer>> result = new ArrayList<>();
		combinatios2(candidates, result , new ArrayList<>(), target, 0);
		return result;
	}
	
	
	public static List<List<Integer>> combinations(int[] candidates, int target, int start) {
		
		List<List<Integer>> result = new ArrayList<>();
		
		if(target < 0)
			return result;
		
		if(start == candidates.length){
			return result;
		}
		
		for(int i = start; i < candidates.length ; i++){
			
			if(candidates[i] == target){
				List<Integer> t = new ArrayList<>();
				t.add(candidates[i]);
				result.add(t);
			}
			else{
				List<List<Integer>> remaining = combinations(candidates, target-candidates[i], i);
				if(remaining.size() > 0){
					for(List<Integer> t : remaining){
						List<Integer> temp = new ArrayList<>(t);
						temp.add(candidates[i]);
						result.add(temp);
					}
				}
			}
			
			
		}
		
		return result;
	}
	
	
	public static void combinatios2(int[] candidates, List<List<Integer>> result, List<Integer> temp, int target, int start){
		
		if (start == candidates.length){
			return;
		}
		
		if(target < 0)
			return;
		
		if(target == 0){
			List<Integer> t = new ArrayList<>(temp);
			result.add(t);
			return;
		}
		
		for(int i = start; i < candidates.length; i++){
			if(candidates[i] > target)
				break;
			temp.add(candidates[i]);
			combinatios2(candidates, result, temp, target-candidates[i], i);
			temp.remove(temp.size()-1);
			
		}	
		
	}
	

}
