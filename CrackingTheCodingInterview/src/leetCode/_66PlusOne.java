package leetCode;

public class _66PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = {9,9,9, 7};
		int[] res = plusOne(digits);
		for(int x : res)
			System.out.print(x + " ");
	}
	
	public static int[] plusOne(int[] digits) {
        
        int carry = 1;
        for(int i = digits.length-1; i >= 0 ; i--){
            int sum = digits[i]+carry;
            digits[i] = sum%10;
            carry = sum/10;
            if(carry == 0)
                break;
        }
        
        if(carry != 0){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        else
            return digits;
        
    }

}
