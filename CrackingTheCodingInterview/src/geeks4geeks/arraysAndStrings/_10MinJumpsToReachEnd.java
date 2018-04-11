package geeks4geeks.arraysAndStrings;
//https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
public class _10MinJumpsToReachEnd {

	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(minJumps(arr));
	}

	public static int minJumps(int[] nums){
		
		int[] jumps = new int[nums.length];
		
		if(nums[0] == 0)
			return 0;
		
		for(int i = 1; i < nums.length; i++)
			jumps[i] = Integer.MAX_VALUE;
		
		for(int i = 1; i < nums.length; i++){
			
			for(int j = 0; j <	i; j++){
				if(nums[j] >= i-j){
					jumps[i] = Math.min(jumps[i], jumps[j]+1);
				}
			}
			
		}
		
		return jumps[nums.length-1];
	}
}
