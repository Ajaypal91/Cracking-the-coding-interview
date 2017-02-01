package arraysAndStrings;

import java.util.Arrays;
import java.util.Scanner;

public class radixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array");
		final int n = sc.nextInt();
		
		if (n>0){
			int[] arr = new int[n];
			System.out.println("Enter values of array");
			int s = 0;
			while(s < n) {
				arr[s] = sc.nextInt();
				s+=1;
			}
			
			System.out.println("Sorting");
			radixSort(arr,n);
			System.out.println("Printing sorted array");
			printArray(arr,n);
		}
		sc.close();
	}
	
	public static int getMax(int[] arr, int n){
		int max = arr[0];
		for (int i= 1; i < n; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		return max;
	}
	
	public static void radixSort(int[] arr,int n) {
		int max = getMax(arr, n);
		int b = 1;
		for (int i = 1; max/i > 0 ; i*=10) {
			countingSort(arr, n, i*10);
			System.out.println("Sorted based on significant digit " + b);
			printArray(arr,n);
			b++;
		}
		
	}
	
	public static void countingSort(int[] arr, int n, int exp) {
		int[] output = new int[n];
		int[] count = new int[10]; // considering the base as 10
		Arrays.fill(output, 0);
		Arrays.fill(count, 0);
		//store the count of each significant bit 
		for (int i = 0; i < n ; i++) {
			int digit = arr[i]%exp;
			digit = digit/(exp/10);
			count[digit]+=1;
		}
		//take cumulative of count to get the desired indexes of each numbers
		for (int i = 1; i < 10 ; i++) {
			count[i] += count[i-1];
		}
		//fill the sorted output array based on the significant digit
		for (int i = n-1; i >= 0 ; i--) {
			int digit = arr[i]%exp;
			digit = digit/(exp/10);
			output[count[digit]-1] = arr[i];
			count[digit] -= 1;
		}
		
		//copy output to original array
		for(int i =0;i < n;i++)
			arr[i] = output[i];
	}
	
	public static void printArray(int[] arr, final int n) {
		int s = 0; 
		while (s < n) {
			System.out.print(arr[s] + " ");
			s+=1;
		}
		System.out.print("\n");
	}
	
	

}
