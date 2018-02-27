package leetCode;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/description/

public class _20ValidParanthesis {

	public static void main(String[] args) {
		
		String s = "()";
		System.out.println(isValid(s));
	}
	
	private static boolean isValid(String s) {
		
		Stack<Character> stk = new Stack<>();
		
		for (char c : s.toCharArray()) {
			if (c == '(')
				stk.push(')');
			else if (c == '[')
				stk.push(']');
			else if (c == '{')
				stk.push('}');
			else {
				if (stk.empty() || stk.pop()!=c)
					return false;
			}
		}
		
		return stk.isEmpty();
	}
}
