package geeks4geeks.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
public class _6LargestSubArrayEqual0And1 {

	private static int startInd, maxLen;
	private static List<Integer> zeross; //to store indexes of zeroes in continuous subarray
	private static List<Integer> oness; //to store indexes of oness in continuous subarray
	
	public static void main(String[] args) {

		int[] arr = {0, 0, 0, 2, 0, 1, 1};
		zeross = new ArrayList<>();
		oness = new ArrayList<>();
		largestSubArray(arr);
		System.out.println(startInd + " " + maxLen);
	}
	
	private static void largestSubArray(int[] arr) {
		
		if(arr.length == 0)
			return;
		
		for (int i = 0; i < arr.length; i++) {
		
			if(arr[i] != 0 && arr[i] != 1) {
				zeross = new ArrayList<>();
				oness = new ArrayList<>();
			}
			else {
				if(arr[i] == 0) {
					zeross.add(i);
					if(oness.size() != 0) {
						int equalElems = Math.min(zeross.size(),oness.size());
						if (2*equalElems > maxLen) {
							int endIndex = Math.max(zeross.get(equalElems-1), oness.get(equalElems-1));
							startInd = endIndex-2*equalElems+1;
							maxLen = 2*equalElems;
						}
					}
				}
				else {
					oness.add(i);
					if(zeross.size() != 0) {
						int equalElems = Math.min(zeross.size(),oness.size());
						if (2*equalElems > maxLen) {
							int endIndex = Math.max(zeross.get(equalElems-1), oness.get(equalElems-1));
							startInd = endIndex-2*equalElems+1;
							maxLen = 2*equalElems;
						}
					}
				}
			}
			
		}
		
	}
	
}
