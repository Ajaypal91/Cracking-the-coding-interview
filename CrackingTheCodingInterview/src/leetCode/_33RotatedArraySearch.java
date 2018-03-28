package leetCode;


//check following solution
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
//https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14425/Concise-O(log-N)-Binary-search-solution
public class _33RotatedArraySearch {

	public static void main(String[] args) {
		
		int[] arr = {1};
		int target = 0;
		System.out.println(search(arr, target));
		
	}
	
	public static int search(int[] nums, int target) {
	        
		return findTarget(nums, target, 0, nums.length-1);
		
	}
	
	public static int findTarget(int[] arr, int target, int low, int high){
		
		if(low > high)
			return -1;
		
		if(low == high)
			return arr[low] == target ? low : -1;
		
		int mid = (low+high)/2;
		
		if(arr[mid] == target)
			return mid;
		
		if(arr[mid] > arr[low]){
			if(arr[mid] > target && arr[low] <= target)
				return findTarget(arr, target, low, mid-1);
			else
				return findTarget(arr, target, mid+1, high);
		}
		else if(arr[mid] < arr[high]){
			if(arr[mid] < target && arr[high] >= target)
				return findTarget(arr, target, mid+1, high);
			else
				return findTarget(arr, target, low, mid-1);
		}
		else{
			if(arr[mid] == arr[low] && arr[mid] == arr[high]) {
				int left = findTarget(arr, target, low, mid);
				int right = findTarget(arr, target, mid, high);
				return left == target ? left : right;
			}
			else if(arr[mid] == arr[low]) {
				return findTarget(arr, target, mid+1, high);
			}
			else
				return findTarget(arr, target, low, mid-1);
		}
		
	}
	

	//**************
	// * CHECK THIS*
	//**************
	
//	public int search(int[] nums, int target) {
//	    int minIdx = findMinIdx(nums);
//	    if (target == nums[minIdx]) return minIdx;
//	    int m = nums.length;
//	    int start = (target <= nums[m - 1]) ? minIdx : 0;
//	    int end = (target > nums[m - 1]) ? minIdx : m - 1;
//	    
//	    while (start <= end) {
//	        int mid = start + (end - start) / 2;
//	        if (nums[mid] == target) return mid;
//	        else if (target > nums[mid]) start = mid + 1;
//	        else end = mid - 1;
//	    }
//	    return -1;
//	}
//
//	public int findMinIdx(int[] nums) {
//	    int start = 0, end = nums.length - 1;
//	    while (start < end) {
//	        int mid = start + (end -  start) / 2;
//	        if (nums[mid] > nums[end]) start = mid + 1;
//	        else end = mid;
//	    }
//		return start;
//	}

	
}
