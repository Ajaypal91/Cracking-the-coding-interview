package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
public class _11MirrorTree {

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

		mirrorTree(bt.root);
		
		TreesOperation.inorderTraversal(bt.root);
		sc.close();

	}
	
	private static void mirrorTree(Node root) {
		
		if (root == null)
			return;
		
		mirrorTree(root.left);
		mirrorTree(root.right);
		
		Node temp = root.right;
		root.right = root.left;
		root.left = temp;
		
	}

}
