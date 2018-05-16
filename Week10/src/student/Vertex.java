package student;

import java.util.Iterator;

public class Vertex {
	/*
	 * class Vertex represents a vertex in a graph, containing the
	 * vertex label and other fields
	 * 
	 * contains a list of the vertex's neighbours, giving an adjacency
	 * list representation for the graph
	 */

	Integer id; // Vertex label
	VertexIDList adjs; // List of neighbours
	Boolean marked;  // Used to indicate previously visited
	Integer num;  // Used by Drozdek to indicate order of visit in traversal
	
	public Vertex(Integer n) {
		// Constructor
		id = n;
		marked = false;
		adjs = new VertexIDList();
		num = 0;
	}
	
	public void setMarked() {
		marked = true;
	}

	public void setUnmarked() {
		marked = false;
	}
	
	public boolean isMarked() {
		return marked;
	}
	
	public void addAdj (Integer n) {
		// Adds a neighbour n to the current vertex 
		adjs.push(n);
	}
	
	public VertexIDList getAdjs() {
		return adjs;
	}

	public Integer getID() {
		return id;
	}
	
	public Integer getNum() {
		return num;
	}
	
	public void setNum(Integer n) {
		num = n;
	}
	
	public void print() {
		System.out.print("Node " + id + " (" + marked + "," + num + ") :");
		adjs.print();
	}
	
	public static void main(String[] args) {
		Vertex v = new Vertex(2);
		v.addAdj(3);
		v.addAdj(6);
		v.print();

		System.out.println("testing iterator ...");
		VertexIDList vAdjs = v.getAdjs();
		Iterator<Integer> it = vAdjs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
