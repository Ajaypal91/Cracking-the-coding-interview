package treesAndGraphs;

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
	
	public void inorderTraversal(Node curr){
		
		if (curr.leftChild() == null && curr.rightChild() == null) {
			System.out.println(curr.value);
			return;
		}
		if (curr.leftChild() != null) 
			inorderTraversal(curr.leftChild());
		System.out.println(curr.value);
		if (curr.rightChild() != null)
			inorderTraversal(curr.rightChild());
	}
	
	public void preorderTraversal(Node curr) {
		if (curr != null){
			System.out.println(curr.value);
		}
		if(curr.leftChild() != null)
			preorderTraversal(curr.leftChild());
		if (curr.rightChild() != null) 
			preorderTraversal(curr.rightChild());
	}
	
	public void postorderTraversal(Node curr){
		if (curr.leftChild() == null && curr.rightChild() == null) {
			System.out.println(curr.value);
			return;
		}
		if(curr.leftChild() != null) 
			postorderTraversal(curr.leftChild());
		if (curr.rightChild() != null) 
			postorderTraversal(curr.rightChild());
		System.out.println(curr.value);
	}
	 	
}

