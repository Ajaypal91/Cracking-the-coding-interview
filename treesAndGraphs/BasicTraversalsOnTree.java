package treesAndGraphs;

import java.util.Scanner;

public class BasicTraversalsOnTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter values for creating Binary Tree. 0 to exit");
		int v = sc.nextInt();
		BinarySearchTree bst = new BinarySearchTree();
		while(v != 0) {
			bst.insertNode(bst.root, v);
			v = sc.nextInt();
		}
		
		System.out.println("Inorder Traversal");
		bst.inorderTraversal(bst.root);
		System.out.println("Preorder Traversal");
		bst.preorderTraversal(bst.root);
		System.out.println("Postorder Traversal");
		bst.postorderTraversal(bst.root);
		sc.close();
	}

}
