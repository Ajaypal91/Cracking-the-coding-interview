package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.geeksforgeeks.org/print-paths-root-specified-sum-binary-tree/

public class _9bRootToAnywhereSum {

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

	private static void printSums(Node root, int sum, List<Integer> path) {
		if (root == null)
			return;
		
		path.add(root.value);
		if(root.value == sum)
			System.out.println(path);
		
		printSums(root.left, sum-root.value, path);
		printSums(root.right,sum-root.value,path);
		path.remove(path.size()-1);
	}
	
}
