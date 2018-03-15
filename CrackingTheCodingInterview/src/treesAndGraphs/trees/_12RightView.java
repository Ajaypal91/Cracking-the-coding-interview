package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//https://www.geeksforgeeks.org/print-right-view-binary-tree-2/
public class _12RightView {
	
	static class MaxLevel{
		static int maxLev;
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
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

		printRightView(bt.root, 1);
		
		sc.close();

	}
	
	private static void printRightView(Node root, int currLevel) {
		
		if (root == null)
			return;
		
		if (currLevel > MaxLevel.maxLev) {
			MaxLevel.maxLev = currLevel;
			System.out.println(root.value);
		}
		
		printRightView(root.right, currLevel+1);
		printRightView(root.left, currLevel+1);
		
	}

}
