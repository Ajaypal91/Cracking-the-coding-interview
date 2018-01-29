package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/ 

public class _9aRootToLeafSum {

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
			System.out.println(doesSumExists(bt.root,s,0));
			System.out.println("enter next sum to check 0 to exit");
			s = sc.nextInt();
		}
		
		sc.close();
	}

	private static boolean doesSumExists(Node root, int sum, int currSum) {
		
		if (root == null)
			return false;
		
		if (root.left == null && root.right == null) {
			if (sum == currSum+root.value)
				return true;
			else
				return false;
		}
		
		return doesSumExists(root.left, sum, currSum+root.value) || doesSumExists(root.right, sum, currSum+root.value);
		
	}
}
