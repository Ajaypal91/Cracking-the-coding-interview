package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/combination-sum/description/

//This is working but not a good solution
public class _39CombinationSum {

	public static void main(String[] args) {
		
		int[] arr = {2, 3, 6, 7};
		int target = 7;
		
		System.out.println(combinationSum(arr, target));
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    
		Arrays.sort(candidates);
		Map<Integer, List<List<Integer>>> map = new HashMap<>();
		
		int i = 1;
		while(i <= target){
			attempt2(candidates, i, map);
			i++;
		}
		
		List<List<Integer>> res = new ArrayList<>();
		
		if(map.containsKey(target))
			res = map.get(target);
		
		return res;
    }
	
	public static void attempt2(int[] arr, int target, Map<Integer, List<List<Integer>>> map){
		
		int i = 0;
		while(i < arr.length && arr[i] <= target){
			
			if(map.containsKey(target - arr[i])){
				List<List<Integer>> temp = map.get(target-arr[i]);
				List<List<Integer>> result = new ArrayList<>();
				for(List<Integer> a : temp){
					List<Integer> t = new ArrayList<>(a);
					t.add(arr[i]);
					result.add(t);
				}
				if(!map.containsKey(target))
					map.put(target, result);
				else{
					temp = map.get(target);
					for(List<Integer> arr1 : temp){
						boolean same = false;
						for(List<Integer> arr2 : result){
							if(isSame(arr1, arr2)){
								same = true;
								break;
							}
						}
						if(!same)
							result.add(arr1);
					}
					
					map.put(target, result);
				}
			}
			if(arr[i] == target){
				List<List<Integer>> res = new ArrayList<>();
				if(map.containsKey(target)){
					res = map.get(target);
					List<Integer> temp = new ArrayList<>();
					temp.add(arr[i]); res.add(temp);
					map.put(target, res);
				}
				else{
					List<Integer> temp = new ArrayList<>();
					temp.add(arr[i]); res.add(temp);
					map.put(target, res);
				}
			}
			i++;
		}
		
	}
	
	public static boolean isSame(List<Integer> arr1, List<Integer> arr2){
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int x : arr1){
			if(map.containsKey(x)){
				map.put(x, map.get(x)+1);
			}
			else
				map.put(x, 1);
				
		}
		
		for(int x : arr2){
			if(!map.containsKey(x))
				return false;
			else{
				int count = map.get(x);
				count--;
				if(count == 0)
					map.remove(x);
				else
					map.put(x, count);
			}
		}
		
		return map.size() == 0;
	}
		
}
