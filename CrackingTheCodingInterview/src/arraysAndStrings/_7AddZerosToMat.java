package arraysAndStrings;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _7AddZerosToMat {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] mat = new int[n][m];
		
		for(int i = 0; i < n; i++){
			for (int j = 0; j < m; j++){
				mat[i][j] = sc.nextInt();
			}
		}
		
		addZeros(mat);
		
		for(int i = 0; i < n; i++){
			for (int j = 0; j < m; j++){
				System.out.print(mat[i][j] + " ,");;
			}
			System.out.println();
		}
		
		sc.close();

	}
	
	private static void addZeros(int[][] mat){
		
		int n = mat.length;
		int m = mat[0].length;
		
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		
		for (int i = 0 ; i < n; i++){
			for (int j = 0; j < m; j++){
				if (mat[i][j] == 0){
					rows.add(i); cols.add(j);
				}
					
			}
		}
		
		for (int i = 0; i < rows.size(); i++){
			int row = rows.get(i);
			int col = cols.get(i);
			
			addZerosToRowCol(mat,row,col,n,m);
		}
		
	}
	
	private static void addZerosToRowCol(int[][] mat, int r, int c,int  n,int m){
		
		for (int j = 0; j < m; j++)
			mat[r][j] = 0;
		for (int i = 0 ; i < n; i++)
			mat[i][c] = 0;
		
	}

}
