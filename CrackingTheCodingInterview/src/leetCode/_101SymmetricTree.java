package leetCode;


//https://leetcode.com/problems/symmetric-tree/description/
public class _101SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSym(root.left, root.right);
    }
    
    
    public static boolean isSym(TreeNode left,TreeNode right){
        
        if(left == null || right == null){
            
            return left == right;
            
        }
        if(left.val != right.val)
            return false;
        
        
        return isSym(left.left, right.right) && isSym(left.right, right.left);
         
    }
}
