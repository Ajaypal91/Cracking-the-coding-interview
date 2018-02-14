package leetCode;

public class _5LongestPalindrome {

	private static int low, maxLen;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbbd";
		System.out.println(longPalindrom(s));
	}
	
	
	private static String longPalindrom(String s) {

		String res = s;
        try{
		if (s.length() == 0)
			return "";
		if (s.length() == 1)
			return s;
		
		int i = 0;
		while(i <= s.length()-2) {
			findMaxPalindromAround(s, i, i);
			findMaxPalindromAround(s, i, i+1);
			i+=1;
		}
		
		res = s.substring(low, low+maxLen);
        }
        catch(Exception e){
            System.out.println("exception e" + s);
        }
        return res;
	}
	
	private static void findMaxPalindromAround(String s, int i, int j) {
		
		while (i>= 0 && j <= s.length()-1 && s.charAt(i) == s.charAt(j)) {
			i-=1;
			j+=1;
		}
		if(j == i+1)
			j-=1;
		else {
			i+=1;
			j-=1;
		}
		if (maxLen < j-i+1) {
			maxLen = j-i+1;
			low = i;
		}
	}
}
