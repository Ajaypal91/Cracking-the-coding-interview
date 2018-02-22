package geeks4geeks.recurrssionDP;

//https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/

public class _1MaxSubSquareMat {

	private static int maxLen;
	
	public static void main(String[] args) {

		int M[][] = {{0, 1, 1, 0, 1}, 
	                {1, 1, 1, 1, 1}, 
	                {0, 1, 1, 1, 1},
	                {1, 1, 1, 1, 1},
	                {1, 1, 1, 1, 1},
	                {0, 0, 0, 0, 0}};
		
		System.out.println(maxSubMatrixLen(M));
		
	}
	
	private static int maxSubMatrixLen(int[][] M) {
		int n = M.length;
		int m = M[0].length;
		
		int[][] map = new int[n][m];
		
		for(int i =0 ;i < n; i++)
			map[i][0] = M[i][0];
		
		for (int i = 0 ; i<m; i++)
			map[0][i] = M[0][i];
		
		for (int i = 1; i < n; i++) {
			
			for (int j = 1; j < m; j++) {
				
				if(M[i][j] == 1) {
					map[i][j] = Math.min(map[i-1][j], Math.min(map[i][j-1], map[i-1][j-1]))+1;
					maxLen = Math.max(map[i][j], maxLen);
				}
				else {
					map[i][j] = 0;
				}
			}
			
		}
		
		for (int i =0; i < n; i++) {
			for (int j =0; j<m; j++) {
				System.out.print(map[i][j] +", ");
			}
			System.out.println();
		}
		
		return maxLen;
	}

}
