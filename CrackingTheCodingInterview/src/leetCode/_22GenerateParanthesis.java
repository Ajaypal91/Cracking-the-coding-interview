package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _22GenerateParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		System.out.println(generate(n));
	}
	
	private static List<String> generate(int n){
		
		List<String> res = new ArrayList<>();
		
		char[] str = new char[n*2];
		
		getRes(str, 0, 0, 0, n, res);
		
		return res;
		
	}
	
	private static void getRes(char[] str, int lC, int rC, int index, int n, List<String> res) {
		
		if (index == 2*n) {
			res.add(new String(str));
		}
		if (lC < n) {
			str[index] = '(';
			getRes(str, lC+1, rC, index+1, n, res);
		}
		if (rC < lC) {
			str[index] = ')';
			getRes(str, lC, rC+1, index+1, n, res);
		}
	}

}
