package recrurssionDP;

//https://www.geeksforgeeks.org/longest-common-subsequence/
public class _11LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ABCDGH";
		String s2 = "AEDFHR";
		System.out.println(LCS(s1,s2));
		System.out.println(lcsRec(s1, s2, s1.length()-1, s2.length()-1));
	}
	
	private static int LCS(String s1, String s2) {
		
		int rows = s1.length();
		int cols = s2.length();
		int[][] lcs = new int[rows+1][cols+1];
		
		for (int i = 1; i <= rows; i++) {
			
			for (int j = 1; j <= cols; j++) {
				
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					lcs[i][j] = 1+lcs[i-1][j-1];
				}
				else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
			
		}
		
		
		return lcs[rows][cols];
	}
	
	private static int lcsRec(String s1, String s2, int index1, int index2) {
		
		if (index1 < 0 || index2 < 0)
			return 0;
		
		
		if(s1.charAt(index1) == s2.charAt(index2))
			return 1+lcsRec(s1, s2, index1-1, index2-1);
		else {
			return Math.max(lcsRec(s1, s2, index1-1, index2), lcsRec(s1, s2, index1, index2-1));
		}
		
	}

}
