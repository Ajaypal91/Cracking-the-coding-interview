package leetCode;

public class _112PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

 public boolean hasPathSum(TreeNode root, int sum) {
	    
        if(root == null)
            return false;
        
        if(root.left == null && root.right == null)
            return sum == root.val;
        
        boolean l = false, r = false;
        if(root.left != null)
            l = hasPathSum(root.left, sum - root.val);
        if(root.right != null)
            r = hasPathSum(root.right, sum - root.val);
        
        return l || r;
        
    }
}
