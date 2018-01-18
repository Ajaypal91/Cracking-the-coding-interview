package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _5IsBTaBST {

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
		List<Integer> arr = new ArrayList<>();
		isBTaBSTinorder(bt.root, arr);
		int first = arr.get(0);
		boolean status = true;
		for (int i = 1; i < arr.size();i++){
			if (arr.get(i) < first){
				status = false;
				break;
			}
			first= arr.get(i);
		}
		System.out.println(status);
		TreesOperation.inorderTraversal(bt.root);
		
		
		
//		
		System.out.println(isBTaBST(bt.root, bt.root.value, Integer.MAX_VALUE));
//		
		
		
		sc.close();

	}
	
	
	//Store the inorder traversal and the check the increasing order
	private static void isBTaBSTinorder(Node root, List<Integer> arr){
		
		if (root == null)
			return;
		
		isBTaBSTinorder(root.left, arr);
		arr.add(root.value);
		isBTaBSTinorder(root.right, arr);
		
	}
	
	//check binary search tree property at each node property at each node
	private static boolean isBTaBST(Node root, Integer minVal , Integer maxVal){
		
		boolean lStatus = true, rStatus= true;
		if (root.left != null){
			if (root.left.value > minVal){
				lStatus = false;
				return lStatus;
			}
			lStatus = isBTaBST(root.left, root.left.value, minVal);
		}
		if (root.right != null){
			if (root.right.value < minVal || root.right.value > maxVal){
				rStatus = false;
				return rStatus;
			}
			rStatus = isBTaBST(root.right, root.right.value, maxVal);
		}
		
		
		return lStatus & rStatus;
		
	}

}
