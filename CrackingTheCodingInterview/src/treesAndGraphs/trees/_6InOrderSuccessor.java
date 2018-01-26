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
		TreesOperation.getListNodes(bt.root, arr);
		
		System.out.println("Tell Index of node to find its successor based on level order travesing of tree");
		
		Node n = arr.get(sc.nextInt()-1);
		System.out.println("Node selected = "+ n.value);
		Node res = inOrderSucc(n);
		System.out.println("Inorder Successsor = " + res.value);
		
		sc.close();
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
	
	//incase of inorder predecessor
	//if the left subtree is non empty then it is the rightmost node in the left child's subtree
	//else it is its parent
	private static Node inorderPred(Node c){
		
		Node pred = null;
		
		if (c.left != null){
			pred = c.left;
			while(pred.right != null){
				pred = pred.right;
			}
		}
		else{
			pred = c.parent;
		}
		
		return pred;
	}
	
	

}
