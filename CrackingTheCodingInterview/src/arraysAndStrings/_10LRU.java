package arraysAndStrings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//http://androidsrc.net/lru-cache-java-implementation/
//https://www.geeksforgeeks.org/lru-cache-implementation/
public class _10LRU {
	
	//should probably contain key val for page and value
	public static class Node{
		int val;
		Node(int v){
			val = v;
		}
	}
	
	public static LinkedList<Node> q = new LinkedList<>();
	public static Map<Integer, Node> map = new HashMap<>();
	public static int size = 3;
	
	public static void add(int val) {
		
		if(!map.containsKey(val)) {
			if(map.size() == size) {
				Node removed = q.removeLast();
				map.remove(removed.val);
			}
			Node n = new Node(val);
			map.put(val, n);
			q.addFirst(n);
		}
		else {
			Node n = map.get(val);
			q.remove(n);
			q.addFirst(n);
		}
		
		
		
	}
	
	public static int refer(int val) {
		
		if (!map.containsKey(val))
			return -1;
		else {
			Node n = map.get(val);
			q.remove(n);
			q.addFirst(n);
			return n.val;
		}
		
	}
	
	public static void printCache() {
		
		for (Node n : q) {
			System.out.print(n.val + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
	
		add(1);add(2);add(3);
		printCache();
		refer(2);add(4);
		printCache();
		
	}
	
	

}
