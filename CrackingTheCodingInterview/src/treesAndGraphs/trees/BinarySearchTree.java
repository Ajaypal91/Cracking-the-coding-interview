package treesAndGraphs.trees;

public class BinarySearchTree {

	Node root;
	
	public void insertNode(Node curr, int val) {
		
		if (curr == null) {
			Node n = new Node(val);
			root = n;
			return;
		}
		else {
			if (curr.value >= val) {
				if (curr.leftChild() == null) {
					Node n = new Node(val);
					curr.left = n;
					return;
				}
				else {
					insertNode(curr.leftChild(), val);
				}
			}
			else {
				if (curr.rightChild() == null) {
					Node n = new Node(val);
					curr.right = n;
					return;
				}
				else {
					insertNode(curr.rightChild(), val);
				}
			}
		}
		
	}

}

