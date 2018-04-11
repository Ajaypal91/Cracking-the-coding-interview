package geeks4geeks.recurrssionDP;


//https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
public class MinHopsRequired {

	public static void main(String[] args) {
		int arr[] = {1, 5, 6, 1, 0, 9};
        
	    System.out.println("Minimum number of jumps to reach end is : "+
	                                  minJumps(arr,arr.length));
   }
	
	public static int minJumps(int[] arr, int n){
		
		
		int[] jumps = new int[n];
		
		
		if(n == 0 || arr[0] == 0)
			return Integer.MAX_VALUE;
		
		for(int i =1; i < n; i++){
			
			int minVal = Integer.MAX_VALUE;
			int jump = 1;
			for(int j = i-1; j >= 0 && jump <= arr[i]; j--, jump++){
				
				if(arr[j] >= jump){
					minVal = Math.min(minVal, jumps[j]+1);
				}
				
			}
			
			jumps[i] = minVal;
			
		}
		
		
		return jumps[n-1];
	}
}
