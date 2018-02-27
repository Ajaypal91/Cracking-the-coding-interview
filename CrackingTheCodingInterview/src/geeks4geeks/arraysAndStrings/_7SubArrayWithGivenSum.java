package geeks4geeks.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
public class _7SubArrayWithGivenSum {

	public static void main(String[] args) {
		
		int[] arr = {10, 2, -2, -20, 100};
		int sum = 101;
		System.out.println(isSumPresent(arr, sum));
	}

	private static boolean isSumPresent(int[] arr, int sum) {
		
		if (arr.length == 0)
			return false;
		
		int currSum = 0;
		Map<Integer,Integer> hm = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];
			
			if(currSum == sum) {
				return true;
			}
			if(hm.containsKey(currSum-sum)) {
				return true;
			}
			hm.put(currSum, i);
			
		}
		
		return false;
	}

}
