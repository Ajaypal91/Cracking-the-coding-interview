package recrurssionDP;

public class _0Fib {

	public static void main(String[] args) {
		int n = 6;
		int[] map = new int[n+1];
		System.out.println(fib(n, map));
	}
	
	private static int fib(int n , int[] map) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (map[n] != 0)
			return map[n];
		map[n] = fib(n-1, map)+fib(n-2, map);
		return map[n];
		
	}

}
