package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/

public class _9cAllPathsToSum {

	public static void main(String[] args) {
		//create a BT
		Scanner sc = new Scanner(System.in);
		List<Integer> lst = new ArrayList<>();
		System.out.println("Enter values for creating Binary Tree, -1 for null and 0 to exit");
		int v = sc.nextInt();
		while(v != 0) {
			lst.add(v);
			v = sc.nextInt();
		}
		
		//build a level order binary tree
		BinaryTree bt = new BinaryTree();
		bt.insertNodeinLevelOrder(lst);
		
		System.out.println("Enter sum 0 to exit");
		int s = sc.nextInt();
		while(s!=0) {
			List<Integer> arr = new ArrayList<>();
			printSums(bt.root,s, arr);
			System.out.println("enter next sum to check 0 to exit");
			s = sc.nextInt();
		}
		
		sc.close();
	}

	private static void printSums(Node root, int sum, List<Integer> arr) {
		
		if (root == null)
			return;
		
		arr.add(root.value);
		int sumSoFar = 0;
		for(int i = arr.size()-1; i>=0; i--) {
			sumSoFar += arr.get(i);
			if(sum == sumSoFar) {
				printPath(arr, i);
			}
		}
		
		printSums(root.left, sum, arr);
		printSums(root.right,sum,arr);
		
		arr.remove(arr.size()-1);
		
	}
	
	private static void printPath(List<Integer> arr, int start) {
		while(start <= arr.size()-1) {
			System.out.print(arr.get(start)+" , ");
			start+=1;
		}
		System.out.println();
	}
}
