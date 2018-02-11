package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://leetcode.com/problems/find-mode-in-binary-search-tree/submissions/1

public class _10ModeOfBST {

	private static int currCount, maxCount;
	private static Node prevNode;
	private static List<Integer> res;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> lst = new ArrayList<>();
		System.out.println("Enter values for creating Binary Tree, -1 for null and 0 to exit");
		int v = sc.nextInt();
		while(v != 0) {
			lst.add(v);
			v = sc.nextInt();
		}
		
		//build a level order binary tree
		BinaryTree bt = new BinaryTree();
		bt.insertNodeinLevelOrder(lst);

		findMode(bt.root);
		
		sc.close();
	}
	
	
	 private static int[] findMode(Node root) {
	        
	        Result2 r = new Result2();
	        res = new ArrayList<>();
	        prevNode = root;
	        
	        findRes(root);
	        int[] output = new int[res.size()];
	        int i = 0;
	        for (int x : res){
	            output[i] = x;
	            i+=1;
	        }
	        System.out.println(res);
	        return output;
	    }
	    
	    private static void findRes(Node root){
	        
	        if (root == null)
	            return;
	        
	        findRes(root.left);
	        	
	        if(prevNode.value == root.value)
	        	currCount+=1;
	        else
	        	currCount =1;
	        
	        if (currCount == maxCount) {
	        	res.add(root.value);
	        }
	        if (currCount>maxCount) {
	        	res = new ArrayList<>();
	        	res.add(root.value);
	        	maxCount = currCount;
	        }
	        prevNode = root;
	        findRes(root.right);
	        
	        
	        
	    }

}


class Result2{
    
    int maxVal;
    List<Integer> res;
    Result2(){
        maxVal = 0;
        res = new ArrayList<>();
    }
    
}
