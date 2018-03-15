package arraysAndStrings;

import java.util.Scanner;

public class _6RotateMatrix {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] mat = new int[n][n];
		
		for(int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				mat[i][j] = sc.nextInt();
			}
		}
		
		rotate(mat);
		
		for(int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				System.out.print(mat[i][j] + " ,");;
			}
			System.out.println();
		}
		
		sc.close();

	}
	
	private static void rotateMatClockwise(int[][] mat){
		
		int n = mat.length;
		int m = mat[0].length;
		
		int row =0;
		for (int j = m-1 ; j >= 0; j--){
			for (int i = n-1; i >= 0; i--){
				if (i==(n-1)-j)
					break;
				int temp = mat[i][j];
				mat[i][j] = mat[row][(n-1)-i];
				mat[row][(n-1)-i] = temp;
			}
			row+=1;
		}
		
		for (int i = 0 ; i < n/2; i++){
			int firstRow = i;
			int lastRow = n-i-1;
			for (int j = 0; j < m; j++){
				int temp = mat[firstRow][j];
				mat[firstRow][j] = mat[lastRow][j];
				mat[lastRow][j] = temp;
			}
		}
	}
	
	private static void rotate(int[][] mat) {
		
		int n = mat.length;
		
		for (int layer = 0; layer < n/2; layer++) {
			
			int first = layer;
			int last = n-1-layer;
			
			for (int i = first; i < last; i++) {
				
				//top-left
				int top = mat[first][i];
				
				//bottom-left to top-left
				mat[first][i] = mat[last-i+first][first];
				
				//bottom-right to bottom-left
				mat[last-i+first][first] = mat[last][last-i+first];
				
				//top-right to bottom-right
				mat[last][last-i+first] = mat[i][last];
				
				//top-left to top-right
				mat[i][last] = top;
			}
			
		}
		
		
	}

}
