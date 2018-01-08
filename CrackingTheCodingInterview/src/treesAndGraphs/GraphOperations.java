package treesAndGraphs;

import java.util.Scanner;

public class GraphOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter integer values for vertexes of nodes. 0 to exit");
		SimpleGraph sg = new SimpleGraph();
		
		int val = sc.nextInt();
		while(val != 0){
			sg.addVertex(val);
			val = sc.nextInt();
		}
		
		System.out.println("Enter edges from vertex start to end. 0 to exit");
		System.out.println("Enter start Vertex");
		int v1 = sc.nextInt();
		System.out.println("Enter end Vertex");
		int v2 = sc.nextInt();
		
		while(v1 != 0 && v2 != 0){
			
			sg.addEdge(v1, v2);
			System.out.println("Enter start Vertex");
			v1 = sc.nextInt();
			System.out.println("Enter end Vertex");
			v2 = sc.nextInt();
			
		}
		
		System.out.println("Printing Vertices in Graph");
		sg.printVertexesInGraph();
		System.out.println("Printing edges in Graph");
		sg.printEdgesInGraph();
		
		sc.close();
		
	}

}
