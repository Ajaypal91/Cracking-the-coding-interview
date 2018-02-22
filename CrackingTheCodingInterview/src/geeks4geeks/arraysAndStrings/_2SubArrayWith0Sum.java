package geeks4geeks.arraysAndStrings;

import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/ 

public class _2SubArrayWith0Sum {

	public static void main(String[] args) {
		int[] arr = {4, 2, 3, 1, -10};
		System.out.println(isSubArray0(arr));
	}

	private static boolean isSubArray0(int[] arr) {
		
		int sumSoFar = 0;
		Set<Integer> hs = new HashSet<>();
		for (int x : arr) {
			sumSoFar += x;
			if (sumSoFar == 0 || hs.contains(sumSoFar))
				return true;
			hs.add(sumSoFar);
		}
		
		
		return false;
	}
}
