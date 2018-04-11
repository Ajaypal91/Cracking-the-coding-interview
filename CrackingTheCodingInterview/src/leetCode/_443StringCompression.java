package leetCode;


//https://leetcode.com/problems/string-compression/discuss/92559/Simple-Easy-to-Understand-Java-solution
public class _443StringCompression {

	public static void main(String[] args) {
		
		char[] chars = {'b','b','b','b','b','b','b','b','b','b'};
		System.out.println(compress(chars));
		
		for(char c : chars){
			System.out.print(c + " ");
		}
		
	}
	
	public static int compress(char[] chars) {
        
        if(chars.length == 0)
            return 0;
        
        if(chars.length == 1)
            return 1;
        
        int count = 1;
        char prev = chars[0];
        int index = 0;
        for(int i = 1; i < chars.length; i++){
            
            if(prev == chars[i])
                count++;
            else{
            	chars[index] = prev;
                if(count != 1){
                	int exp = (int)Math.log10(count);
                    while(exp >= 0){
                    	index++;
                    	chars[index] = Character.forDigit((int)(count/Math.pow(10, exp)),10);
                        count %= Math.pow(10,exp);
                        exp--;
                    }    
                }
                index++;
                prev = chars[i];
                count = 1;
            }
            
        }
        chars[index] = prev;
        if(count > 1){
        	int exp = (int)Math.log10(count);
        	while(exp >= 0){
        		index++;
            	chars[index] = Character.forDigit((int)(count/Math.pow(10, exp)),10);
                count %= Math.pow(10,exp);
                exp--;
        	}
        }
        
        return index+1;
    }

}
