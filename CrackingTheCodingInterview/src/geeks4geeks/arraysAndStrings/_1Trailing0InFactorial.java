package geeks4geeks.arraysAndStrings;


//https://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
public class _1Trailing0InFactorial {

	public static void main(String[] args) {
		int n = 28;
		System.out.println(num0sInFac(n));
	}
	
	private static int num0sInFac(int n) {
		
		int count = 0;
		
		for (int i = 1; n/i >= 1; i*=5) {
			count+=n/(5*i);
		}
		return count;
	}

}
