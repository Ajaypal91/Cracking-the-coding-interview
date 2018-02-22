package geeks4geeks.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
public class _4DistinctElementsKWindow {

	public static void main(String[] args) {
	
		int[] arr = {1, 2, 1, 3, 4, 2, 3};
		int k = 4;
		printElements(arr, k);
	}
	
	private static void printElements(int[] arr, int k) {
		
		if (arr.length < k)
			return;
		
		Map<Integer, Integer> hm = new HashMap<>();
		
		for (int i = 0 ; i < k; i++) {
			if(hm.containsKey(arr[i])) {
				hm.put(arr[i], hm.get(arr[i])+1);
			}
			else {
				hm.put(arr[i], 1);
			}
		}
		
		
		System.out.println(hm.size());
		
		for (int i = k ; i < arr.length; i++) {
			int lastElem = arr[i-k];
			int newElem = arr[i];
			
			if (newElem == lastElem) {
				System.out.println(hm.size());
			}
			else {
				if(hm.get(lastElem) == 1) {
					hm.remove(lastElem);
				}
				else {
					hm.put(lastElem, hm.get(lastElem)-1);
				}
				if(hm.containsKey(newElem))
					hm.put(newElem, hm.get(newElem)+1);
				else
					hm.put(newElem, 0);
				System.out.println(hm.size());
			}
		}
	}

}
