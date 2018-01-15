package treesAndGraphs.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class GraphTraversalsMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter integer values for vertexes of nodes. 0 to exit");
		
		SimpleAdjListGraph sag = new SimpleAdjListGraph();
		Map<Integer,Vertex> map = new HashMap<>();
		
		int val = sc.nextInt();
		while(val != 0){
			map.put(val, new Vertex(val));
			val = sc.nextInt();
		}
		
		System.out.println("Enter integer to define edges for the following. 0 to exit");
		
		for(int key : map.keySet()){
			System.out.println(key);
			val = sc.nextInt();
			LinkedList<Vertex> lst = new LinkedList<>();
			while(val!=0){
				if (map.containsKey(val))
					lst.add(map.get(val));
				else
					System.out.println("No such vertex exists");
				val = sc.nextInt();
			}
			sag.insertIntoAdjList(map.get(key), lst);
		}
		
		System.out.println("DFS Traversal of Graph:");
		GraphTraversals.DFSTraversal(sag.adjList);
		System.out.println("BFS Traversal of Graph:");
		sag.resetGraph();
		GraphTraversals.BFSTraversal(sag.adjList);
		sc.close();

	}

}
