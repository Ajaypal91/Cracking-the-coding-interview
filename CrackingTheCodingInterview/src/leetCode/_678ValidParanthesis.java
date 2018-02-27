package leetCode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/valid-parenthesis-string/description/
public class _678ValidParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
//		String s = "()()";
		String s = "(*()";
		System.out.println(isStringValid(s));
	}

	private static boolean isStringValid(String s) {
		int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low++;
                high++;
            } else if (s.charAt(i) == ')') {
                if (low > 0) {
                    low--;
                }
                high--;
            } else {
                if (low > 0) {
                    low--;
                }
                high++;
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
	}
}
