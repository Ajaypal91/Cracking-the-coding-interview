package leetCode;

public class _14LongestCommonPrefix {

	private static String maxSofar;
	private static int maxLen;
	
	public static void main(String[] args) {
		String [] strs = {"aba","aab"};
		System.out.println(longCommPrefAmongAll(strs));
	}
	
	private static String longCommPrefAmongAll(String[] strs) {
		
		if (strs.length == 0)
            return "";
		
		int minLen = Integer.MAX_VALUE;
		for (String s : strs) {
			minLen = minLen > s.length() ? s.length() : minLen;
		}
		if (minLen == 0)
			return "";
		
		int i = 0, j, ind = 0;
		boolean matched = true;
		while(i < minLen) {
			j = 1;
			char c = strs[0].charAt(i);
			matched = true;
			while(j < strs.length) {
				if (strs[j].charAt(i)!=c) {
					matched=false;
					break;
				}
				j+=1;
			}
			
			if (!matched)
				break;
			else {
				ind = i+1;
			}
			i+=1;
		}
		
		return strs[0].substring(0, ind);
	}

	private static String longCommPref(String[] strs) {
		maxLen = 0;
		maxSofar = "";
		
		int i = 0, j = i+1;
		if (strs.length == 0 || strs.length == 1)
			return "";
		
		while(i < strs.length-1) {
			j = i+1;
			while(j < strs.length) {
				updatePrefix(strs[i],strs[j]);
				j+=1;
			}
			i+=1;
		}
		
		return maxSofar;
	}
	
	private static void updatePrefix(String s1, String s2) {
		
		if (s1.length() < maxLen || s2.length() < maxLen)
			return;
		
		if( maxLen != 0 && !s1.startsWith(s2.substring(0,maxLen)))
			return;
		
		int i = maxLen < 0 ? 0 : maxLen;
		while(i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i))
			i+=1;
		
		if (maxLen < i) {
			maxLen = i;
			maxSofar = s1.substring(0,maxLen);
		}
		
	}
	
}
