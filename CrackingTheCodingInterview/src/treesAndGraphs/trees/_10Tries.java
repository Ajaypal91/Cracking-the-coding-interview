package treesAndGraphs.trees;

import java.util.HashMap;
import java.util.Map;

public class _10Tries {
	
	public static class Node{
		
		Map<Character, Node> children = new HashMap<>();
		boolean isCompleteWord;
		int size = 0;
		
		public Node getChild(char c) {
			return children.get(c);
		}
		
		public void insert(String s) {
			insertString(s, 0);
		}
		
		public void insertString(String s, int index) {
			
			size++;
			if(s.length() == index)
				return;
			
			if(s.length() == index-1)
				isCompleteWord = true;
			
			if (!children.containsKey(s.charAt(index))) {
				Node newNode = new Node();
				children.put(s.charAt(index), newNode);
			}
			Node n = children.get(s.charAt(index));
			n.insertString(s, index+1);
			
		}
		
		public boolean find(String s) {
			
			return doesExist(s, 0);
					
		}
		
		public boolean doesExist(String s, int index) {
			
			if(s.length() == index) {
				return isCompleteWord;
			}
				
			if (!children.containsKey(s.charAt(index)))
				return false;
			
			Node n = children.get(s.charAt(index));
			return n.doesExist(s, index+1);
			
		}
		
		public int count(String s) {
			return getCount(s, 0);
		}
		
		public int getCount(String s, int index) {
			
			if (s.length() == index)
				return size;
			
			if (!children.containsKey(s.charAt(index)))
				return 0;
			
			return getCount(s, index+1);
		}
		
		
	}

	public static void main(String[] args) {
		
	}

}
