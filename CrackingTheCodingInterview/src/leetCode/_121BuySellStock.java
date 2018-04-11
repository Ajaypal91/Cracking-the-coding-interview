package leetCode;


//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39038/Kadane's-Algorithm-Since-no-one-has-mentioned-about-this-so-far-:)-(In-case-if-interviewer-twists-the-input)
public class _121BuySellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  public int maxProfit(int[] prices) {
	        
	        if(prices.length == 0)
	            return 0;
	        
	        int maxSoFar = 0, m = prices[0];
	        
	        
	        for(int i = 1; i < prices.length; i++){
	        
	            if(prices[i] < m){
	                m = prices[i];
	            }
	            else{
	                maxSoFar = Math.max(maxSoFar, prices[i] - m);
	            }
	        }
	        
	        return maxSoFar;
	    }
}
