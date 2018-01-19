package treesAndGraphs.trees;

class Node {
    public int value;
    public Node left;
    public Node right;
    public Node parent;
    
    public Node(int val) {
    	this.value = val;
    	this.left = null;
    	this.right = null;
    	this.parent = null;
    }
    
    public Node leftChild(){
        return this.left;
    }
    
    public Node rightChild(){
        return this.right;
    }
}
