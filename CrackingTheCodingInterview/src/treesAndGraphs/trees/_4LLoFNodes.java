package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _4LLoFNodes {

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
		
//		List<LinkedList<Node>> res = createLLForLevels(bt.root);
//		for (LinkedList<Node> r : res){
//			for (int i = 0; i < r.size(); i++)
//				System.out.print(r.get(i).value + " -- > ");
//			System.out.println();
//		}
		
		List<LinkedList<Node>> res = new ArrayList<>();
		updateLLpreOrder(bt.root, res, 1);
		
		for (LinkedList<Node> r : res){
			for (int i = 0; i < r.size(); i++)
				System.out.print(r.get(i).value + " -- > ");
			System.out.println();
		}
		
		sc.close();
	}
	
	//for each level create a linkedlist of nodes
	public static List<LinkedList<Node>> createLLForLevels(Node root){
		
		List<LinkedList<Node>> res = new ArrayList<>();
		
		int height = heightOfTree(root, 1, 1);
		
		for (int i = 1; i <= height; i++){
			LinkedList<Node> lst = new LinkedList<>();
			updateLLatLevel(root, lst, 1, i);
			res.add(lst);
		}
		
		return res;
	}
	
	private static void updateLLatLevel(Node root, LinkedList<Node> lst, int currLevel, int level){
		
		if (root==null)
			return;
		if (currLevel == level){
			lst.add(root);
			return;
		}
		
		updateLLatLevel(root.left, lst, currLevel+1, level);
		updateLLatLevel(root.right, lst, currLevel+1, level);
	}
	
	private static int heightOfTree(Node root, int currLevel, int maxLevel){
		if (root == null)
			return 0;
		
		if (currLevel>maxLevel)
			maxLevel = currLevel;
		
		int lMaxLevel = heightOfTree(root.left,currLevel+1,maxLevel) ;
		int rMaxLevel = heightOfTree(root.right, currLevel+1, maxLevel);
		
		return Math.max(lMaxLevel, Math.max(rMaxLevel, maxLevel));
	}
	
	private static void updateLLpreOrder(Node root, List<LinkedList<Node>> res, int currLevel){
		
		if (root == null)
			return;
		
		if(res.size() < currLevel){
			res.add(new LinkedList<>());
		}
		LinkedList<Node> t = res.get(currLevel-1);
		t.add(root);
		updateLLpreOrder(root.left, res, currLevel+1);
		updateLLpreOrder(root.right, res, currLevel+1);
		
	}

}
