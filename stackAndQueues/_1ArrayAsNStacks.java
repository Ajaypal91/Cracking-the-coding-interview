package stackAndQueues;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _1ArrayAsNStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//considering stacks only contains integers
		System.out.println("How many stacks do you want to create from one array");
		
		int n = sc.nextInt();
		NStacksFromArray stks = null;
		
		if (n > 0) {
			stks = new NStacksFromArray(n);	
		}
		else {
			System.out.println("Invalid number of stacks entered.");
			return;
		}
		
		int val, stackNo, con = -1;
				
		System.out.println("Enter 0 to stop 1 to continue");
		System.out.println("Do you want to continue");
		con = sc.nextInt();
		
		while (con == 1) {
			System.out.println("Enter Stack No > 0 and less than " + (n+1));
			stackNo = sc.nextInt();
			System.out.println("Enter value");
			val = sc.nextInt();
			stks.push(val, stackNo);
			System.out.println("Do you want to continue");
			con = sc.nextInt();
		}
		
		//printing stacks
		System.out.println("Printing Stacks");
		for (int i = n ; i > 0 ; i-- ) {
			System.out.println("Printing Stack " + (i));
			stks.printStack(i);
		}
		
		System.out.println("Do you want to pop any stack");
		con = sc.nextInt();
		
		while(con == 1) {
			System.out.println("Enter Stack No > 0 and less than " + (n+1));
			stackNo = sc.nextInt();
			System.out.println("Item: "+ stks.pop(stackNo));
			System.out.println("Do you want to pop any stack");
			con = sc.nextInt();
		}

		//printing stacks
		System.out.println("Printing Stacks");
		for (int i = n ; i > 0 ; i-- ) {
			System.out.println("Printing Stack " + (i));
			stks.printStack(i);
		}
		
		sc.close();
	}

}

class NStacksFromArray {
	
	int[] topOfStacks;
	ArrayList<Integer> arr;
	int[] sizeOfStacks;
	
	public NStacksFromArray(int n){
		this.topOfStacks = new int[n];
		Arrays.fill(this.topOfStacks,-1);
		this.sizeOfStacks = new int[n];
		Arrays.fill(this.sizeOfStacks,0);
		this.arr = new ArrayList<Integer>();
	}
	
	//helper method to find position or index where new item needs to be inserted
	public int findPosition(int stackNo, int n){
		
		int position = -1;
		if (topOfStacks[stackNo-1] != -1){
			position = topOfStacks[stackNo-1]+1;
				
		}
		else {
			for (int i = (stackNo-2); i>= 0 ; i-- ) {
				if (topOfStacks[i] != -1) {
					position = topOfStacks[i] +1;
					break;
				}
			}
			if (position == -1) {
				position = topOfStacks[stackNo-1]+1;
			}
		}
		
		return position;
	}
	
	public void push(int value, int stackNo) {
		
		int n = topOfStacks.length;
		//if value needs to be added on last stack
		
		//if it is last stack
		if (stackNo == n) {
			arr.add(value);
			
			int position = findPosition(stackNo, n);
			
			// if there is only one stack
			if (n == 1) 
				topOfStacks[n-1] += 1;
			// if it is -1 then add 1 to top of previous top of stack
			else 
				topOfStacks[n-1] = position;
			sizeOfStacks[n-1] += 1;
		}
		else {	
//			shiftArrayValues(value, topOfStacks[stackNo-1]+1, arr);
			//ArrayList automatically shifts values from the given index
			//find position to insert the element
			int position = findPosition(stackNo, n);
			
			//add value at position
			arr.add(position,value);
			
			//update size of stack
			sizeOfStacks[stackNo-1] += 1;
			
			//update pointer of stack
			topOfStacks[stackNo-1] = position;
			
			for (int i = stackNo ;i < n; i++) {
				if (topOfStacks[i] != -1) 
					topOfStacks[i] += 1;
			}
		}
		
	}
	
	//this is helper method to shift values in array. Since I am using java's ArrayList which automatically shifts values
	//on addition at a given position this is not needed yet.
	private void shiftArrayValues(int value, int position, ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		int temp;
		
		for (int i = position ; i < arr.size(); i ++) {
			temp = arr.get(position);
			arr.add(position, value);
			value = temp;
		}
		arr.add(value);		
	}
	
	//print the given stack
	public void printStack(int stackNo) {
		
		int size = sizeOfStacks[stackNo - 1];
		int i  = topOfStacks[stackNo - 1];
		
		if (size == 0) {
			System.out.println("Stack Empty ");
			return;
		}
		
		while (size != 0) {
			System.out.println(arr.get(i));
			i -= 1;
			size -= 1;
		}
	}

	public int pop(int stackNo) {
		
		if (sizeOfStacks[stackNo-1] > 0) {
			int item  = arr.get(topOfStacks[stackNo-1]);
			arr.remove(topOfStacks[stackNo-1]);
			//adjust pointers
			int n = topOfStacks.length;
			if (stackNo != n){
				for(int i = stackNo; i < n; i ++){
					if(topOfStacks[i] != -1)
						topOfStacks[i] -= 1;
				}
			}
			topOfStacks[stackNo-1] -= 1;
			//adjust size
			sizeOfStacks[stackNo-1] -= 1;
			return item;
		}
		else {
			System.out.println("Stack empty");
			return -1;
		}
	}
}