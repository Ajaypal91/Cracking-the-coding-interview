package geeks4geeks.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
//https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/ if elements are only 0 or 1
public class _3LargestSubArray0Sum {

	
	private static int maxSoFar, startInd;

	public static void main(String[] args) {
		int[] arr = {4, 2, 0, -2, -7};
		isSubArray0(arr);
		System.out.println(startInd +" " + maxSoFar);
	}

	private static void isSubArray0(int[] arr) {
		
		int sumSoFar = 0;
		Map<Integer, Integer> hm = new HashMap<>();
		int i = 0;
		for (int x : arr) {
			sumSoFar += x;
			
			if (x == 0 && maxSoFar == 0)
				maxSoFar = 1;
			
			if (sumSoFar == 0) {
				maxSoFar = i+1;
				startInd = 0;
			}
			
			if (hm.containsKey(sumSoFar)) {
				if (maxSoFar <= i-hm.get(sumSoFar)) {
					maxSoFar = i - hm.get(sumSoFar);
					startInd = hm.get(sumSoFar)+1;
				}
			}
			else {
				hm.put(sumSoFar, i);
			}
			
			i+=1;
		}
		
	}

}
