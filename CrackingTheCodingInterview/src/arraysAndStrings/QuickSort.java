package arraysAndStrings;

import java.util.Scanner;

public class QuickSort {

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
			quicksort(arr,0,n-1);
			System.out.println("Printing sorted array");
			printArray(arr,n);
		}
	}
	
	public static void printArray(int[] arr, final int n) {
		int s = 0; 
		while (s < n) {
			System.out.println(arr[s]);
			s+=1;
		}
	}
	
	public static void quicksort(int[] arr, int start, int end){
		if (start < end) {
			int splitPoint = partition(arr,start,end);
			quicksort(arr, start, splitPoint-1);
			quicksort(arr, splitPoint+1, end);
		}
	}
	
	public static int partition(int[] arr, int start, int end) {
		
		int splitPoint = start;
		start +=1;
		
		while (start < end) {
			while (start <= end && arr[start] < arr[splitPoint])
				start++;
			while(start <= end && arr[end] > arr[splitPoint])
				end--;
			if (start < end)
				arr[start] = (arr[start] + arr[end]) - (arr[end] = arr[start]); 
		}
		if (arr[splitPoint] > arr[end])
			arr[splitPoint] = (arr[splitPoint] + arr[end]) - (arr[end] = arr[splitPoint]);
		
		return end;
	}

}
