package leetCode;

public class _55JumpGameOrArrayHopper {

	public static void main(String[] args) {
		
		int[] arr = {3,2,1,0,4};
		System.out.println(canJump(arr));
	}
	
	public static boolean canJump(int[] nums) {
        
        if(nums.length == 0)
            return true;
        
        boolean[] jumps = new boolean[nums.length];
        
        if(nums.length == 1)
        	return true;
        
        if(nums[0] == 0)
            return false;
        
        jumps[0] = true;
        
        for(int i = 1; i < nums.length; i++){
            
            boolean temp = false;
            for(int j = 0; j < i; j++){
                
                if(jumps[j] && i-j<=nums[j]){
                    temp = true;
                    break;
                }
                
            }
            jumps[i] = temp;
        }
        
        return jumps[nums.length-1];
        
    }
	
	public static boolean canJump2(int A[], int n) {
	    int i = 0;
	    for (int reach = 0; i < n && i <= reach; ++i)
	        reach = Math.max(i + A[i], reach);
	    return i == n;
	}
	
	
	
}
