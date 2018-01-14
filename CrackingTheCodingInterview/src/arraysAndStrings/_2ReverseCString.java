package arraysAndStrings;

import java.util.Scanner;

public class _2ReverseCString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		System.out.println(reverseCString(s));
		
		sc.close();
	}
	
	private static String reverseCString(String s){
		
		StringBuilder sb = new StringBuilder(s);
		
		int l = sb.length();
		for (int i = 0; i < l/2; i++){
			char temp = sb.charAt(l-i-1);
			sb.setCharAt(l-i-1, sb.charAt(i));
			sb.setCharAt(i, temp);
		}
		
		return sb.toString();
	}

}
