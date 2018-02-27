package leetCode;

//https://leetcode.com/problems/word-search/description/
public class _79WordSearch {

	public static void main(String[] args) {
		char[][] mat = {
					{'A','B','C','E'},
					{'S','F','C','S'},
					{'A','D','E','E'}
						};
		String s = "ABCCED";
		System.out.println(exist(mat, s));
	}
	
	private static boolean exist(char[][] board, String word) {
		
		int n = board.length;
		int m = board[0].length;
		boolean[][] checker = new boolean[n][m];
		
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < m; j ++) {
				if(board[i][j] == word.charAt(0)) {
					if (checkPresent(board, checker, word, 0, i, j))
						return true;
				}
			}
		}
		
		return false;
	}
	
	private static boolean checkPresent(char[][] board, boolean[][] checker, String word, int index, int i, int j) {
		
		if (index == word.length())
			return true;
		
		int n = board.length;
		int m = board[0].length;
		
		if (i < 0 || j <0 || i == n || j == m)
			return false;
		
		if (checker[i][j] || board[i][j] != word.charAt(index))
			return false;
		
		checker[i][j] = true;
		boolean status  = checkPresent(board, checker, word, index+1, i-1, j) ||
				checkPresent(board, checker, word, index+1, i, j-1) ||
				checkPresent(board, checker, word, index+1, i+1, j) ||
				checkPresent(board, checker, word, index+1, i, j+1);
		checker[i][j] = false;
		return status;
	}

}
