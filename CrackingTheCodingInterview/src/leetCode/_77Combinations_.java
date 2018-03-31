package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _77Combinations_ {

	public static void main(String[] args) {
		
		int n = 4, k = 3;
		System.out.println(combine(n, k));
	}
	
	public static List<List<Integer>> combine(int n, int k) {
		
		List<List<Integer>> result = new ArrayList<>();
		
		combinations(result, new ArrayList<>(), 1, n, k);
		
		return result;
    }
	
	
	public static void combinations(List<List<Integer>> result, List<Integer> temp, int curr, int n, int k){
		
		if(temp.size() == k){
			List<Integer> t = new ArrayList<>(temp);
			result.add(t);
			return;
		}
		
		if(curr > n)
			return;
		
		
		for(int i = curr; i <= n; i++){
			
			temp.add(i);
			combinations(result, temp, i+1, n, k);
			temp.remove(temp.size()-1);
			
		}
		
		
	}

}
