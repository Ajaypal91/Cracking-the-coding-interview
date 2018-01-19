package treesAndGraphs.trees;

import java.util.*;


//http://www.ida.liu.se/opendsa/OpenDSA/Books/OpenDSA/html/CompleteTree.html
public class BinaryTree {
	
	Node root;
	
	//#levels : 2^n-1 = #nodes
	// -1 means to insert a null
	public void insertNodeinLevelOrder(List<Integer> vals){
		
		int len = vals.size();
		
		Queue<Node> que = new LinkedList<>();
		
		if (vals.size() == 0)
			return;
		
		root = new Node(vals.get(0));
		que.add(root);
		
		for (int i = 0; i<len; i++){
			
			if (vals.get(i) != -1){
				Node n = que.remove();
				
				int leftChild = 2*i + 1;
				int rightChild = 2*i + 2;
				
				//left child is present
				if (leftChild < len){
					Node lChild  = null;
					if (vals.get(leftChild) != -1){
						lChild = new Node(vals.get(leftChild));
						lChild.parent = n;
					}
					n.left = lChild;
					if (lChild != null)
						que.add(lChild);
				}
				//right child is present
				if (rightChild < len){
					Node rChild  = null;
					if (vals.get(rightChild) != -1){
						rChild = new Node(vals.get(rightChild));
						rChild.parent = n;
					}
					n.right = rChild;
					if (rChild != null)
						que.add(rChild);
				}
				
			}
		}
		
	}

}
