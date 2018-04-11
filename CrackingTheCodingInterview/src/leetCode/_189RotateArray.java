package leetCode;

public class _189RotateArray {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3};
		int k = 5;
		
		rotate(nums, k);
		
		for(int x : nums){
			System.out.print(x + " ");
		}
	}
	
	public static void rotate(int[] nums, int k) {
        
        if(k != 0 && k >= nums.length)
                k = k%nums.length;
        
        if (k > 0){
            
            int[] temp = new int[k];
        
            int j =0;
            for(int i = nums.length-k; i < nums.length; i++){
                temp[j] = nums[i];
                j++;
            }

            j = 0;
            for(int i = 0; i < nums.length; i++){

                if((i)%k == 0)
                    j = 0;

                int t = nums[i];
                nums[i] = temp[j];
                temp[j] = t;

                j++;
            }
        }
        
    }

}
