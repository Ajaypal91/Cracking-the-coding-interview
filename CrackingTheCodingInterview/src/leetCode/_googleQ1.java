package leetCode;


//this is related to rose blossoms question
public class _googleQ1 {

	public static void main(String[] args) {
		
		int[] P = {3,1,5,4,2};
		int K = 2;
		System.out.println(findMaxDay(P, K));
	}
	
	private static int findMaxDay(int[] P, int K) {
		
		int ans = -1;
		int[] M = new int[P.length];
		//inverse the array wrt to the row position of roses the value represent the day and index the row of the roses
		for (int i = 0; i < P.length; i++) {
			M[P[i]-1] = i+1;
		}
		
		int maxm = Integer.MIN_VALUE;
		
		for (int i = 0; i < K; i++)
			maxm = Math.max(maxm, M[i]);
		
		ans = Math.max(ans, Math.max(maxm, M[K]));
		
		for (int i = K; i < P.length-1; i++) {
			
			int newVal = M[i];
			int oldVal = M[i-K];
			
			if(maxm == oldVal && maxm < newVal) {
				maxm = newVal;
			}
			if (maxm == oldVal) {
				maxm = findNewMax(M, i-K+1, i);
			}
			
			if(oldVal > maxm && M[i+1] > maxm && oldVal > M[i-K+1] && M[i+1] > M[i])
				ans = Math.max(ans, maxm)-1;
			
		}
		
		int newVal = M[P.length-1];
		int oldVal = M[P.length-1-K];
		
		if(maxm == oldVal && maxm < newVal) {
			maxm = newVal;
		}
		if (maxm == oldVal) {
			maxm = findNewMax(M, P.length-1-K, P.length-1);
		}
		
		if(oldVal > maxm && oldVal > M[P.length-1-K] )
			ans = Math.max(ans, Math.max(maxm, M[P.length-1-K]));
		
		
		return ans;
	}
	
	private static int findNewMax(int[] M, int start, int end) {
		int maxm = Integer.MIN_VALUE;
		
		for (int i = start; i <= end; i++)
			maxm = Math.max(maxm, M[i]);
		
		return maxm;
	}

}
