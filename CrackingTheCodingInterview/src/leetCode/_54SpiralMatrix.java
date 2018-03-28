package leetCode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/description/
public class _54SpiralMatrix {

	
	public static void main(String[] args) {
	
		int[][] arr =	{
						 { 1 } ,{ 2}, {6 },{12 }
						 
						};
		
		System.out.println(spiralOrder(arr));
		
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
        
		List<Integer> res = new ArrayList<>();
		if(matrix.length == 0)
			return res;
		
		int n = matrix.length-1;
		int m = matrix[0].length-1;
		int i = 0;
		int j = 0;
		
		while(i <= n && j <= m){
			
			for(int k = j; k <= m; k++)
				res.add(matrix[i][k]);
			i++;
			
			
			for(int k = i; k <= n; k++)
				res.add(matrix[k][m]);
			m--;
			
			if(i<=n){
				for(int k = m; k >= j; k--)
					res.add(matrix[n][k]);
				n--;
			}
			
			if(j<=m){
			for(int k = n; k >= i; k--)
				res.add(matrix[k][j]);
				j++;
			}
				
		}
		
		
		
		return res;
    }

}
