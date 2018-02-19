package leetCode;

public class _11CointainerMaxWater {

	public static void main(String[] args) {
		
		int[] height = {2,2,3,2,5,1};
		System.out.println(maxWater(height));
	}

	private static int maxWater(int[] height) {
		
		if (height.length == 0 || height.length == 1)
			return 0;
		
		int res = 0;
		int i = 0, j = height.length-1;
		
		while(i<j) {
			
			int minH = Math.min(height[i], height[j]);
			res = res < ((j-i)*minH) ?  ((j-i)*minH) : res;
			while(height[j] <= minH && j > i)
				j--;
			while(height[i] <= minH && i < j)
				i+=1;
			
		}
		
		return res;
	}
}
