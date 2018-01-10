package arraysAndStrings;

import java.util.Scanner;

public class _8RotationSubstring {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		System.out.println(isRotatedString(s1,s2));

	}

	private static boolean isRotatedString(String s1, String s2) {
		
		if (s1.length() == s2.length() && s1.length() > 0){
			StringBuilder sb = new StringBuilder(s2);
			sb.append(s2);
			return sb.toString().contains(s1);
		}
		return false;
	}

}
