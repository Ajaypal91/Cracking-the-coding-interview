package geeks4geeks.arraysAndStrings;

//https://www.geeksforgeeks.org/minimum-swaps-required-group-1s-together/

public class _9MinSwapsToGroup1s {

	public static void main(String[] args) {
		int arr[] = {1, 0, 1, 0, 1, 1, 0, 1};
		System.out.print(minSwaps(arr));
	}

	private static int minSwaps(int[] arr) {
		
		
		int slidingWindow = 0;
		for (int x : arr) {
			if (x==1)
			slidingWindow +=1;
		}
		
		int[] map = new int[arr.length];
		
		map[0] = arr[0] == 1?1:0;
		
		int max1s = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++) {
			map[i] = arr[i] == 1? map[i-1]+1 : map[i-1];
		}
		
		int numOnes;
		for (int i = slidingWindow-1; i < arr.length; i++) {
			if (i == slidingWindow-1)
				numOnes = map[i];
			else
				numOnes = map[i] - map[i-slidingWindow];
			max1s = Math.max(max1s, numOnes);
		}
		
		return slidingWindow-max1s;
		
	}
}
