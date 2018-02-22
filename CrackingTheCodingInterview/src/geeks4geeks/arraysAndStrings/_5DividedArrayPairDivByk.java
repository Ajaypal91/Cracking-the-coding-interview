package geeks4geeks.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/
public class _5DividedArrayPairDivByk {

	public static void main(String[] args) {
		int[] arr = {91, 74, 66, 48};
		int k  = 10;
		System.out.println(canBeDivided(arr, k));
	}

	private static boolean canBeDivided(int[] arr, int k) {
		
		//odd length
		if (arr.length%2 != 0)
			return false; 
		
		Map<Integer, Integer> hm = new HashMap<>();
		
		for (int i = 0;i < arr.length; i++) {
			
			int modLeft = arr[i]%k;
			if(hm.containsKey(k-modLeft)) {
				hm.put(k-modLeft, hm.get(k-modLeft)-1);
				if(hm.get(k-modLeft) == 0)
					hm.remove(k-modLeft);
			}
			else {
				if(hm.containsKey(modLeft)) {
					hm.put(modLeft, hm.get(modLeft)+1);
				}
				else {
					hm.put(modLeft, 1);
				}
			}
		}
		
		if (hm.size() == 0)
			return true;
		return false;
	}
}
