package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.geeksforgeeks.org/find-level-maximum-sum-binary-tree/
public class _9eMaxLevelSum {

	public static void main(String[] args) {
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

		System.out.println(maxLevelSum(bt.root));
		
		sc.close();
	}
	
	private static int maxLevelSum(Node root) {
		int h = height(root);
		int[] arr = new int[h];
		maxSum(root, arr, 0);
		int max = arr[0];
		for (int i = 1; i < h; i++) {
			if(max<arr[i])
				max = arr[i];
		}
		return max;
	}
	
	private static void maxSum(Node root, int[] arr, int currLevel) {
		if(root == null)
			return;
		arr[currLevel]+=root.value;
		maxSum(root.left, arr, currLevel+1);
		maxSum(root.right, arr, currLevel+1);
	}
	
	private static int height(Node root) {
		
		if(root == null)
			return 0;
		
		return Math.max(height(root.left), height(root.right))+1;
	}

}
