package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicTraversalsOnTree {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> lst = new ArrayList<>();
		System.out.println("Enter values for creating Binary Tree. 0 to exit");
		int v = sc.nextInt();
		while(v != 0) {
			lst.add(v);
			v = sc.nextInt();
		}
		
		
		//Build a Binary Search tree
//		BinarySearchTree bst = new BinarySearchTree();
//		
//		for (Integer x : lst){
//			bst.insertNode(bst.root, x);
//		}
//		
//		System.out.println("Inorder Traversal");
//		TreesOperation.inorderTraversal(bst.root);
//		System.out.println("Preorder Traversal");
//		TreesOperation.preorderTraversal(bst.root);
//		System.out.println("Postorder Traversal");
//		TreesOperation.postorderTraversal(bst.root);
//		System.out.println("Level order traversal");
//		TreesOperation.levelOrderTraversal(bst.root);
		
		
		//build a level order binary tree
		BinaryTree bt = new BinaryTree();
		bt.insertNodeinLevelOrder(lst);
		
		System.out.println("Inorder Traversal");
		TreesOperation.inorderTraversal(bt.root);
		System.out.println("Preorder Traversal");
		TreesOperation.preorderTraversal(bt.root);
		System.out.println("Postorder Traversal");
		TreesOperation.postorderTraversal(bt.root);
		System.out.println("Level order traversal");
		TreesOperation.levelOrderTraversal(bt.root);
//		TreesOperation.levelOrderTraversalUsingLevels(bt.root);
		
		sc.close();
	}

}
