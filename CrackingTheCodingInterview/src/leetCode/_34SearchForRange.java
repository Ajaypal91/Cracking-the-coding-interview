package leetCode;

//https://leetcode.com/problems/search-for-a-range/description/
//check this solution
//https://leetcode.com/problems/search-for-a-range/discuss/14699/Clean-iterative-solution-with-two-binary-searches-(with-explanation)


public class _34SearchForRange {

	public static void main(String[] args) {
		
		int arr[] = {5,5};
		int target = 5;
		int[] res = searchRange(arr, target);
		System.out.println(res[0] +", " + res[1]);
	}
	
	public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
		
        int mid = find(nums, target, 0, nums.length-1);
        
        if(mid == -1)
        {
        	res[0] = -1;
        	res[1] = -1;
        	return res;
        }
        
        int start = mid, end = mid;
        int temp = start;
        while(temp != -1){
        	temp = find(nums, target, 0, temp-1);
        	if(temp!=-1)
        		start = temp;
        }
        temp = mid;
        while(temp!= -1){
        	temp = find(nums, target, temp+1, nums.length-1);
        	if(temp!=-1)
        		end = temp;
        }
        
        res[0] = start;
        res[1] = end;
        
        
        return res;
    }
	
	public static int find(int[] nums, int target, int low, int high){
		
		if (low > high)
			return -1;
		int mid = (low+high)/2;
		if (nums[mid] == target)
			return mid;
		
		if (nums[mid] > target)
			return find(nums,target,low, mid-1);
		else
			return find(nums, target, mid+1,high);
		
	}

}
