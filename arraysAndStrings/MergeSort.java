package arraysAndStrings;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
					mergeSort(arr, 0, n-1);
					System.out.println("Printing sorted array");
					printArray(arr,n);
				}
				sc.close();

	}
	
	public static void mergeSort(int[] arr, int start, int end) {
		//find middle
		int middle = (end+start)/2;
		if (start < end) {
			//partition from start to middle
			mergeSort(arr, start, middle);
			//partition form middle+1 to end
			mergeSort(arr, middle+1, end);
			//merge the two partitions
			merge(arr,start,middle,end);
		}
	}
	
	public static void merge(int[] arr, int start, int middle, int end){
		int[] output = new int[end+1];
		Arrays.fill(output, 0);
		int first = start, second = middle+1;
		int i = 0;
		//compare the two sub arrays and merge after comparison into output array
		while (first <= middle && second <= end){
			if (arr[first] < arr[second]){
				output[i] = arr[first];
				i++;
				first++;
			}
			else {
				output[i] = arr[second];
				i++;
				second++;
			}
		}
		//if first sub array is not scanned completely
		if (first <= middle) {
			while(first <= middle) { 
				output[i] = arr[first];
				i++;
				first++;
			}
		}
		//if second sub array is not scanned completely
		if (second <= end) {
			while(second <= end) { 
				output[i] = arr[second];
				i++;
				second++;
			}
		}
		
		i=0;
		//update the original array
		while(start <= end){
			arr[start] = output[i];
			i++;
			start++;
		}
		
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
