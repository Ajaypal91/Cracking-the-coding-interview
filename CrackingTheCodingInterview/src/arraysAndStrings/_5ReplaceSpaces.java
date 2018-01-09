package arraysAndStrings;

import java.util.Scanner;

public class _5ReplaceSpaces {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		System.out.println(replaceSpaces(s,"%20"));
		
		sc.close();
			
	}
	
	private static String replaceSpaces(String s, String add){
		
		
		StringBuilder sb = new StringBuilder();
		
		for (char c: s.toCharArray()){
			if (c == ' ')
				sb.append(add);
			else
				sb.append(c);
		}
		
		
		return sb.toString();
		
	}

}
