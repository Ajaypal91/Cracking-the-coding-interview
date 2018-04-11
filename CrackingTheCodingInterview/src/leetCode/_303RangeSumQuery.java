package leetCode;

public class _303RangeSumQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int[] nums;

	public _303RangeSumQuery(int[] nums) {
	    for(int i = 1; i < nums.length; i++)
	        nums[i] += nums[i - 1];
	    
	    this.nums = nums;
	}

	public int sumRange(int i, int j) {
	    if(i == 0)
	        return nums[j];
	    
	    return nums[j] - nums[i - 1];
	}

}
