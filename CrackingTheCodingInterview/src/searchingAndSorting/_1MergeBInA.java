package searchingAndSorting;

public class _1MergeBInA {

	public static void main(String[] args) {
		int[] A = { 3,4,5 , 6 ,10, 0, 0, 0 ,0 };
		int[] B = {1, 2,7,11};

		merge(A,B,4,3);
		
		for (int x : A)
			System.out.println(x);
		
	}
	
	//trick is to start from end
	private static void merge(int[] A, int[] B, int n1, int n2) {
		
		int s1 = n1, s2 = n2;
		int end = A.length-1;
		while(s1>=0 && s2 >= 0) {
			
			if(A[s1]>= B[s2]) {
				A[end] = A[s1];
				s1-=1;
			}
			else {
				A[end] = B[s2];
				s2-=1;
			}
			end-=1;
		}
		while(s2>=0 && end>=0) {
			A[end] = B[s2];
			s2-=1;end-=1;
		}
		
	}

}
