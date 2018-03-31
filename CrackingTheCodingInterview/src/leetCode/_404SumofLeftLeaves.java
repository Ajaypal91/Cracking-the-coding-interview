package leetCode;

public class _404SumofLeftLeaves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private int sum = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        this.sumLL(root,null);
        return sum;
    }
    
    public void sumLL(TreeNode child, TreeNode par){
        
        if(child == null)
            return;
        
        if(child.left == null && child.right == null && par != null && par.left == child)
            sum += child.val;
        
        sumLL(child.left, child);
        sumLL(child.right, child);
        
    }

}
