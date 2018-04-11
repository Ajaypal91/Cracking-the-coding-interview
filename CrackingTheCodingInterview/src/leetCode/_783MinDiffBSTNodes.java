package leetCode;

public class _783MinDiffBSTNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private TreeNode prev = null;
    private int minSum = Integer.MAX_VALUE;
    
    public int minDiffInBST(TreeNode root) {
        
        if(root == null)
            return minSum;
        
        int left = minDiffInBST(root.left);
        
        if(prev != null)
            minSum = Math.min(root.val - prev.val, minSum);
        prev = root;
        
        int right = minDiffInBST(root.right);
        
        return minSum;
    }
    
}
