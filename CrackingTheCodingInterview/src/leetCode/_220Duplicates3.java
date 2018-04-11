package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _220Duplicates3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {-1,2147483647};
		int t = 1, k = 2147483647;
		
		System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
	}
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
		List<Integer> arr = new ArrayList<>();
        
        int i = 0;
        for(int x : nums){
            
            if(i-k-1>=0){
                arr.remove(0);
            }
            
            for (int y : arr){
            	long res = (long)Math.abs(y-x);
            	System.out.println(res);
                if( res <= t)
                    return true;
            }
            
            arr.add(x);
            i++;
        }
        
        return false;
    }
    
    public static boolean check(List<Integer> arr, int t, int val){
        
        for (int x : arr){
            if(Math.abs(x-val) <= t)
                return true;
        }
        
        return false;
        
    }

}
