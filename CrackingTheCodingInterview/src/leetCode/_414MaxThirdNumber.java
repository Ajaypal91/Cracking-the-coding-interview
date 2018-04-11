package leetCode;

public class _414MaxThirdNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2};
		System.out.println(thirdMax(nums));
	}

	public static int thirdMax(int[] nums) {
        
        int n = nums.length;
        
        int maxNum = 0, firstMax = Integer.MIN_VALUE, res = 0;
        
        int i = 0;
        while(i != n && maxNum != 3){
            
            int m = Integer.MIN_VALUE;
            int currInd = i;
            for(int j = i; j < n; j++){
                if(m < nums[j]){
                    m = nums[j];
                    currInd = j;
                }
            }
            
            int temp = nums[currInd];
            nums[currInd] = nums[i];
            nums[i] = temp;
            
            if(i==0){
                firstMax = nums[0];
                maxNum++;
            }
            else if(nums[i] != nums[i-1]){
                maxNum++;
            }
            
            if(maxNum == 3)
                res = nums[i];
            i++;
        }
        
        if(maxNum != 3)
            return firstMax;
        return res;
    }
}
