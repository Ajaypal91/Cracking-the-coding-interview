package arraysAndStrings;

import java.util.Scanner;

public class _3RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		System.out.println(removeDuplicates(s));
		
		sc.close();

	}
	
	//assuming string only contains a-z characters
	private static String removeDuplicates(String s){
		
		StringBuilder sb =  new StringBuilder();
		int checker = 0;
		for (char c : s.toCharArray()){
			int val = (int)(c-'a');
			if((checker & (1 << val)) == 0)
				sb.append(c);
			checker |= 1 << val;
			
		}
		
		return sb.toString();
	}

}
