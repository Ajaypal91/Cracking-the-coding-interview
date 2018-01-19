package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _6InOrderSuccessor {

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
		
		List<Node> arr = new ArrayList<>();
		getListNodes(bt.root, arr);
		
		System.out.println("Tell Index of node to find its successor based on level order travesing of tree");
		
		Node n = arr.get(sc.nextInt()-1);
		System.out.println("Node selected = "+ n.value);
		Node res = inOrderSucc(n);
		System.out.println("Inorder Successsor = " + res.value);
		
		sc.close();
	}
	
	private static void getListNodes(Node root, List<Node> arr){
		
		Queue<Node> que = new LinkedList<Node>();
		que.offer(root);
		arr.add(root);
		while(!que.isEmpty()){
			
			Node n = que.poll();
			Node lChild = n.left;
			Node rChild = n.right;
			arr.add(lChild); arr.add(rChild);
			if (lChild != null)
				que.offer(lChild);
			if (rChild != null)
				que.offer(rChild);
		}
		
	}
	
	private static Node inOrderSucc(Node c){
		
		if (c == null)
			return null;
		
		Node succ = null;
		//if right subtree is not empty. Inorder successor is leftmost child in right subtree
		if (c.right != null){
			succ = c.right;
			while(succ.left != null){
				succ = succ.left;
			}
		}
		else{//else the inorder successor is unvisited parent in inorder traversal
			
			Node curr = c;
			Node par = c.parent;
			
			while(par != null && par.right == curr){
				curr = par;
				par = par.parent;
			}
			if(curr.parent == null)
				succ = curr;
			else
				succ = curr.parent;
		}
		
		return succ;
	}
	

}
