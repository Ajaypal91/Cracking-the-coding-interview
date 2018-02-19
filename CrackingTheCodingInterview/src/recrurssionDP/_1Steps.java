package recrurssionDP;

public class _1Steps {

	public static void main(String[] args) {
		int n = 36;
		int[] map = new int[n+1];
		for (int i = 0; i <= n ; i++)
			map[i] = -1;
		System.out.println(countWaysDP(n, map));
		for (int i = 0; i <= n ; i++)
			map[i] = -1;
		System.out.println(countSteps(n, map));
	}
	
	private static int countWaysDP(int n, int[] map) {
		
		if (n < 0) {
		return 0;
		} else if (n == 0) {
		return 1;
		} else if (map[n] > -1) {
		return map[n];
		} else {
		map[n] = countWaysDP(n - 1, map) + 	countWaysDP(n - 2, map) +	countWaysDP(n - 3, map);
		return map[n];
		}
	}
	
	private static int countSteps(int n, int[] map) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		if (n==2)
			return 2;
		if (map[n] != -1)
			return map[n];
		map[n] = countSteps(n-1, map) + countSteps(n-2, map) + countSteps(n-3, map);
		return map[n];
					
	}

}
