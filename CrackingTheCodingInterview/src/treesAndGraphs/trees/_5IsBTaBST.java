package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _5IsBTaBST {

	public static void main(String[] args) {
		
		//create a BT
		Scanner sc = new Scanner(System.in);
		List<Integer> lst = new ArrayList<>();
		System.out.println("Enter values for creating Binary Tree. 0 to exit");
		int v = sc.nextInt();
		while(v != 0) {
			lst.add(v);
			v = sc.nextInt();
		}
		
		//build a level order binary tree
		BinaryTree bt = new BinaryTree();
		bt.insertNodeinLevelOrder(lst);
		System.out.println(isBTaBST(bt.root));
		sc.close();

	}
	
	//check binary search tree property at each node property at each node
	private static boolean isBTaBST(Node root){
		
		if (root == null)
			return true;
		boolean status = true;
		
		if(root.left != null && root.left.value >= root.value)
			status= false;
		if (root.right != null && root.right.value <= root.value)
			status = false;
		
		return status & isBTaBST(root.left) & isBTaBST(root.right);
		
	}

}
