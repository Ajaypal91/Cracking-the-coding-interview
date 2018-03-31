package leetCode;

public class _111MInDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDepth(TreeNode root) {
        
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
            return 1;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if(left == 0)
            return right+1;
        else if(right == 0)
            return left+1;
        else
            return Math.min(left,right)+1;
        
        
    }
	
}
