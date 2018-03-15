package recrurssionDP;

//https://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/

//similar to longest common subsequence question
public class _13EditDistance {

	public static void main(String[] args) {
		
		String s1 = "sunday";
		String s2 = "saturday";

		System.out.println(editDistance(s1,s2));
	}

	private static int editDistance(String s1,String s2) {
		
		int n = s1.length();
		int m = s2.length();
		
		if (n == 0)
			return m;
		if (m == 0)
			return n;
		
		int[][] dist = new int[n+1][m+1];
		
		for (int i = 0 ; i <=n ; i++) {
			dist[i][0] = i;
		}
		
		for (int i = 0 ; i <=m ; i++) {
			dist[0][i] = i;
		}
		
		for (int i = 1; i <= n; i++) {
			
			for (int j = 1; j <=m ; j++) {
				
				if (s1.charAt(i-1) == s2.charAt(j-1))
					dist[i][j] = dist[i-1][j-1];
				else {
					dist[i][j] = 1 + Math.min(dist[i-1][j-1], Math.min(dist[i-1][j], dist[i][j-1]));
				}
					
			}
			
		}
		
		return dist[n][m];
		
	
	}
}
