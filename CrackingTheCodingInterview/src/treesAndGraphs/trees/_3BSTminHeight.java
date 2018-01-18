package treesAndGraphs.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _3BSTminHeight {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		List<Integer> lst = new ArrayList<>();
		System.out.println("Enter values for creating Binary Search Tree, -1 for null and 0 to exit");
		int v = sc.nextInt();
		while(v != 0) {
			lst.add(v);
			v = sc.nextInt();
		}	

		Node root = createBSTFromList(lst, 0, lst.size()-1);
		System.out.println("Level order traversal");
		TreesOperation.levelOrderTraversal(root);
		
		sc.close();
		

	}
	
	private static Node createBSTFromList(List<Integer> lst, int low, int high){
		
		Node m = null;
		if(low < high){
			
			int mid = low+(high-low)/2;
			m = new Node(lst.get(mid));
			m.left = createBSTFromList(lst, low, mid-1);
			m.right = createBSTFromList(lst, mid+1, high);
			
		}
		if (low == high)
			m = new Node(lst.get(low));
		return m;
		
	}

}
