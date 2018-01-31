package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.geeksforgeeks.org/maximum-sum-tree-adjacent-levels-not-allowed/
public class _9fMaxSumNoAdjLevels {

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

		LevelSum res = new LevelSum();
		maxSum(bt.root, res, 1);
		System.out.println(res.evenLevel+" , "+res.oddLevel);
		
		sc.close();
	}
	
	private static void maxSum(Node root, LevelSum res, int currLevel) {
		
		if(root == null)
			return;
		if (currLevel%2==0)
			res.evenLevel+=root.value;
		else
			res.oddLevel+=root.value;
		maxSum(root.left, res, currLevel+1);
		maxSum(root.right, res, currLevel+1);
		
	}

}

class LevelSum{
	int oddLevel;
	int evenLevel;
	LevelSum(){
		oddLevel = 0;
		evenLevel = 0;
	}
}
