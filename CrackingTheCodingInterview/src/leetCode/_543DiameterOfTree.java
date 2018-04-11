package leetCode;

public class _543DiameterOfTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private int maxSoFar = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        this.getResult(root);
        return maxSoFar;
    }
    
    public int getResult(TreeNode root){
        if(root == null)
            return 0;
        
        int left = getResult(root.left);
        int right = getResult(root.right);
        
        if(maxSoFar < left+right){
            maxSoFar = left+right;
            System.out.println(maxSoFar);
        }
        
        return Math.max(left, right)+1;
    }

}
