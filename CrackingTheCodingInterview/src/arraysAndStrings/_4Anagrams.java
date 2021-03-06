package arraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _4Anagrams {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		System.out.println(isAnagram(s1, s2));
		System.out.println(isPermutationMethod1(s1,s2));
		
		sc.close();
	}
	
	private static boolean isAnagram(String s1, String s2){
		
		//if one of them is null
		if(s1 == null || s2 == null)
			return false;
		
		//if both are empty
		if (s1.length() == 0 && s2.length() == 0)
			return true;
		
		//if one of them is empty
		if (s1.length() == 0 || s2.length() == 0)
			return false;
		
		if (s1.length() != s2.length())
			return false;
		
		boolean isAnagram = true;
		
		int[] hit = new int[256];
		
		for (char c : s1.toCharArray()){
			hit[(int)c] = ++hit[(int)c];
		}
		
		for (char c : s2.toCharArray()){
			if (hit[(int)c] > 0){
				hit[(int)c] = --hit[(int)c];
			}
			else{
				isAnagram = false;
			}
		}
		
		return isAnagram;
	}
	
	private static boolean isPermutationMethod1(String s1, String s2){
		
		boolean isPermutation = true;
		
		if (s1.length() != s2.length())
			return false;
		
		Map<Character, Integer> map = new HashMap<>();
		for(Character c: s1.toCharArray()){
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}
			else{
				map.put(c, 1);
			}
		}
		
		for (Character c: s2.toCharArray()){
			if (map.containsKey(c) && map.get(c) > 0){
				map.put(c, map.get(c)-1);
			}
			else{
				isPermutation = false;
				break;
			}
		}
		
		
		return isPermutation;
	}

}
