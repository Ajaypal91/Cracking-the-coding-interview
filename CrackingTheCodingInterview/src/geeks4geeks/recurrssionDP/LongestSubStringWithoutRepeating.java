package geeks4geeks.recurrssionDP;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeating {

	public static void main(String[] args) {
		String s = "ABDEFGABEF";
		System.out.println(LSWR(s));
	}
	
	
	private static int LSWR(String s){
		
		int result = 0;
		
		Map<Character, Integer> temp = new HashMap<>();
		
		int count = 0;
		int i = 0;
		for(char c : s.toCharArray())
		{
			
			if(!temp.containsKey(c)){
				count++;
				temp.put(c, i);
			}
			else{
				result = Math.max(count, result);
				int index = temp.get(c);
				count -= index+1;
				temp.put(c, i);
			}
			i++;
		}
		
		return result;
	}

}
