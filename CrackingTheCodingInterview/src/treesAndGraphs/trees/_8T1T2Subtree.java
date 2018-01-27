package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _8T1T2Subtree {

	public static void main(String[] args) {
		//create a BT
		Scanner sc = new Scanner(System.in);
		List<Integer> lst = new ArrayList<>();
		System.out.println("Enter values for creating first Binary Tree, -1 for null and 0 to exit");
		int v = sc.nextInt();
		while(v != 0) {
			lst.add(v);
			v = sc.nextInt();
		}
		
		//build a level order binary tree
		BinaryTree bt1 = new BinaryTree();
		bt1.insertNodeinLevelOrder(lst);
		
		//create a BT
		lst = new ArrayList<>();
		System.out.println("Enter values for creating second Binary Tree, -1 for null and 0 to exit");
		v = sc.nextInt();
		while(v != 0) {
			lst.add(v);
			v = sc.nextInt();
		}
		
		//build a level order binary tree
		BinaryTree bt2 = new BinaryTree();
		bt2.insertNodeinLevelOrder(lst);
		
		System.out.println(isT1T2Subtree(bt1.root, bt2.root));
		
		sc.close();

	}
	
	private static boolean isT1T2Subtree(Node r1, Node r2){
		
		if (r2 == null)
			return true;
		
		return findT2(r1, r2);
	}
	
	private static boolean findT2(Node r1, Node r2){
		
		if(r1 == null)
			return false;
		
		if (r1.value == r2.value)
			if (checkSubtree(r1,r2))
				return true;
		
		return findT2(r1.left,r2) || findT2(r1.right,r2);
		
	}
	
	private static boolean checkSubtree(Node r1, Node r2){
		
		if (r1 == null && r2 ==null)
			return true;
		if (r1 == null || r2 == null)
			return false;
		if(r1.value != r2.value)
			return false;
		
		return checkSubtree(r1.left, r2.left) && checkSubtree(r1.right, r2.right);
		
	}

}
