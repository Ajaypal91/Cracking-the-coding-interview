package arraysAndStrings;

import java.util.Scanner;

public class _9StringCompression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		System.out.println(stringCompression(s));
		
		sc.close();
			
	}

	private static String stringCompression(String s){
		
		if (s.length() == 0)
			return null;
		
		StringBuilder sb = new StringBuilder();
		
		char c = s.charAt(0);
		int count = 1;
		sb.append(c);
		for (int i = 1; i < s.length(); i++){
			
			if (c != s.charAt(i)){
				sb.append(Integer.toString(count)).append(s.charAt(i));
				count = 1;
				c = s.charAt(i);
			}
			else{
				count+=1;
			}
			
		}
		sb.append(Integer.toString(count));
		return sb.toString();
	}
	
}
