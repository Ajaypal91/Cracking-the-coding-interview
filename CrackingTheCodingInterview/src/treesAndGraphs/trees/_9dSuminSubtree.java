package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _9dSuminSubtree {

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
			SumResult res = new SumResult();
			doesSumExist(bt.root,s, res);
			System.out.println(res.res);
			System.out.println("enter next sum to check 0 to exit");
			s = sc.nextInt();
		}
		
		sc.close();
	}
	
	private static int doesSumExist(Node root, int sum, SumResult res) {
		
		if (root == null)
			return 0;
		
		int leftSum = doesSumExist(root.left, sum, res);
		int rightSum = doesSumExist(root.right, sum, res);
		
		if (leftSum+rightSum+root.value == sum)
			res.res = true;
		
		return leftSum+rightSum+root.value;
	}

}

class SumResult{
	boolean res;
}
