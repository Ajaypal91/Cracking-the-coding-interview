package treesAndGraphs.graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleGraph {
	
//	HashMap<Vertex,Edge[]> connections;
	ArrayList<Vertex> vertices;
	ArrayList<ArrayList<Edge>> connections;
	
	public SimpleGraph(){
		this.vertices = new ArrayList<Vertex>();
		this.connections = new ArrayList<ArrayList<Edge>>();
	}
	
	public boolean checkVertexPresent(int data){
		for (Vertex x : vertices) {
			if (x.data == data) 
				return true;
		}
		return false;
	}
	
	public int getVertexIndex(int data){
		for (int i = 0 ;i< vertices.size(); i ++) {
			if (vertices.get(i).data == data) 
				return i;
		}
		return -1;
	}
	
	public void addVertex(int data){
		
		if (checkVertexPresent(data)) {
			System.out.println("Vertex already present.");
			return;
		}
		Vertex n = new Vertex(data);
		vertices.add(n);
		
	}
	
	public void addEdge(int start, int end) {
		int index = getVertexIndex(start);
		if (index == -1) {
			System.out.println("No such node with this data exists.!!");
			return;
		}
		Vertex first = vertices.get(index);
		if (connections.size() -1 < index) {
			connections.add(index, new ArrayList<Edge>());
		}
		int index2 = getVertexIndex(end);
		if (index2 == -1) {
			System.out.println("No such node with this data exists.!!");
			return;
		}
		Vertex second = vertices.get(index2);
		Edge e = new Edge(first,second,1);
		connections.get(index).add(e);
	}
	
	
	public void printVertexesInGraph() {
		for(Vertex x : vertices){
			System.out.println(x.data);
		}
	}
	
	public void printEdgesInGraph() {
		for (int i = 0 ; i< connections.size() ; i++) {
			for (int j = 0; j < connections.get(i).size() ; j++){
				System.out.println("" + connections.get(i).get(j).start.data + "--> " + connections.get(i).get(j).end.data);
			}
		}
	}
}
