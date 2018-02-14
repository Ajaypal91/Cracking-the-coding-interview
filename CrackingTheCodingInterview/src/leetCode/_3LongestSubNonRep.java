package leetCode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

public class _3LongestSubNonRep {

	public static void main(String[] args) {
		String s = "dvdf";
		System.out.println(longSub(s));
	}

	
	private static String longSub(String s) {
		
		int startInd = 0; int endInd = 0;
		Map<Character, Integer> charsSeenSoFar = new HashMap<>();
		int maxLenSoFar = 1;
		int i = 0 , j = i+1;
		int lenOfStr = s.length();
		
		if (lenOfStr == 0)
			return "";
		if (lenOfStr == 1)
			return s;

		charsSeenSoFar.put(s.charAt(i), i);
		
		while(i < lenOfStr) {
			
			if (j == lenOfStr-1) {
				if(!charsSeenSoFar.containsKey(s.charAt(j))) {
					charsSeenSoFar.put(s.charAt(j), j);
					if (maxLenSoFar < charsSeenSoFar.keySet().size()) {
						startInd = i; endInd = j;
						maxLenSoFar = charsSeenSoFar.keySet().size();
					}
				}
				break;
			}
			else if(charsSeenSoFar.containsKey(s.charAt(j))) {
				int t = charsSeenSoFar.get(s.charAt(j));
				if( t != j-1) {
					updateHM(s, i, t, charsSeenSoFar);
				}
				else {
					charsSeenSoFar = new HashMap<>();
				}
				i = t+1;
				charsSeenSoFar.put(s.charAt(j), j);
				j = j+1;
			}
			else {
				charsSeenSoFar.put(s.charAt(j), j);
				if (maxLenSoFar < charsSeenSoFar.keySet().size()) {
					startInd = i; endInd = j;
					maxLenSoFar = charsSeenSoFar.keySet().size();
				}
				j+=1;
			}
			
		}
		
		
		
		return s.substring(startInd, endInd+1);
	}
	
	private static void updateHM(String s, int start, int end, Map<Character, Integer> hm) {
		while(start<=end) {
			hm.remove(s.charAt(start));
			start+=1;
		}
	}
	
	
}
