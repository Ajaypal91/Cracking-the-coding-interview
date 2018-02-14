package leetCode;

public class _7RevInteger {

	public static void main(String[] args) {
		int x = -2147483648;
	
		System.out.println(revInt(x));
	}

	private static int revInt(int x) {
		long res = 0;
		
		
		int sign = 1;
		if (x < 0) {
			sign = -1;
			if(x == Integer.MIN_VALUE)
				return 0;
			x = x*-1;
		}
		
		int i = (int)Math.log10(x);
		int base = 10;
		int exp = i;
		
		
		while(exp >= 0) {
			long num = (int)Math.pow(base, exp);
			res += num*(x%10);
			x = x/10;
			exp-=1;
		}
		if (res > Integer.MAX_VALUE)
			return 0;
		return (int)res*sign;
	}
}
