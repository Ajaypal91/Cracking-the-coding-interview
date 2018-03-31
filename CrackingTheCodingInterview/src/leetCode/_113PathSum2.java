package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _113PathSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> result = new ArrayList<>();
        findSum(root, sum, result, new ArrayList<>());
        return result;
    }
    
    
    public static void findSum(TreeNode root, int sum, List<List<Integer>> result, List<Integer> temp){
        
        if(root == null)
            return;
        
        temp.add(root.val);
        
        if(root.left == null && root.right == null){
            if(sum == root.val){
                result.add(new ArrayList<>(temp));
            }
        }
        
        findSum(root.left, sum-root.val, result, temp);
        findSum(root.right, sum-root.val, result, temp);
        
        temp.remove(temp.size()-1);
        
    }
	
}
