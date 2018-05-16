package student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {

	/*
	 * Represents a graph using an adjacency list.
	 */
	
	private TreeMap<Integer, Vertex> m;
	// Graph implemented using a TreeMap: key is vertex id label,
	// value is the vertex object, which contains the adjacency list
	// for that vertex
	private Integer numEdges;
	private Iterator<Map.Entry<Integer, Vertex>> gIt;
	
	public Graph() {
		m = new TreeMap<Integer, Vertex>();
		numEdges = 0;
	}
	
	public Integer numVertices() {
		return m.size();
	}
	
	public Integer numEdges() {
		return numEdges;
	}
	
	public Vertex getVertex(Integer n) {
		// Used for accessing vertex to e.g. add neighbours
		return m.get(n);
	}
	
	public NavigableSet<Integer> getVertexSet() {
		// Returns set of all vertices in the graph
		return m.navigableKeySet();
	}
	
	public void addVertex(Integer n) {
		// Adds a new vertex n to the graph
		Vertex v = new Vertex(n);
		m.put(n, v);
	}
	
	public void deleteVertex(Integer n) {
		// Deletes a vertex n from the graph
		m.remove(n);  // Deletes vertex key from TreeMap
		gIt = m.entrySet().iterator(); // must come after remove
		// Also remove vertex n from list of neighbours
		while (gIt.hasNext()) {
			Map.Entry<Integer, Vertex> pairs = gIt.next();
			pairs.getValue().getAdjs().remove(n);
		}		
	}
	
	public void print() {
		gIt = m.entrySet().iterator();
		
		System.out.println("Number of nodes is " + m.size());
		System.out.println("Number of edges is " + numEdges);

		while (gIt.hasNext()) {
			Map.Entry<Integer, Vertex> pairs = gIt.next();
			pairs.getValue().print();
		}		
		System.out.println();
	}

	public void setUnmarked() {
		// Sets all vertices to be unmarked e.g. after traversal
		gIt = m.entrySet().iterator();
		while (gIt.hasNext()) {
			Map.Entry<Integer, Vertex> pairs = gIt.next();
			pairs.getValue().setUnmarked();
			pairs.getValue().setNum(0);
		}				
	}
	
	public Integer getFirstVertexID() {
		// Returns first vertex ID in TreeMap ordering
		// e.g. for starting a traversal
		return m.firstKey();
	}
	
	public boolean containsVertex(Integer n) {
		// Checks if n is a vertex in the graph
		return m.containsKey(n);
	}
	
	public void setDirected(Vector<Edge> eList) {
		// Instantiates a directed graph based on a list of edges
		m.clear();
		numEdges = eList.size();
		
		Iterator<Edge> eIt = eList.iterator();
		while (eIt.hasNext()) { // iterate through edges
			Edge curEdge = eIt.next();
			Integer key1 = curEdge.getFirst();
			Integer key2 = curEdge.getSecond();
			// Insert both vertices in the edge
			if (!m.containsKey(key1)) {
				Vertex v = new Vertex(key1);
				m.put(key1, v);
			}
			if (!m.containsKey(key2)) {
				Vertex v = new Vertex(key2);
				m.put(key2, v);
			}
			// Put second vertex in neighbour list of first vertex
			m.get(key1).addAdj(key2);
		}
	}
	
	public void setUndirected(Vector<Edge> eList) {
		// Instantiates an undirected graph based on a list of edges
		Vector<Edge> eList2 = (Vector<Edge>) eList.clone();
		Iterator<Edge> eIt = eList.iterator();
		// Extends list by reversing edges and adding them,
		// to get both directions (i.e. have symmetric adjacency lists)
		while (eIt.hasNext()) {
			Edge curEdge = eIt.next();
			eList2.add(new Edge(curEdge.getSecond(), curEdge.getFirst()));
		}	
		this.setDirected(eList2);
		
		numEdges = numEdges / 2;
	}
	
	public void setDefault () {
		// A sample undirected graph used in workshop questions
		Vector<Edge> eList = new Vector<Edge>();
		
		eList.add(new Edge(1,2));
		eList.add(new Edge(1,3));
		eList.add(new Edge(1,7));
		eList.add(new Edge(2,5));
		eList.add(new Edge(4,5));
		eList.add(new Edge(4,7));
		eList.add(new Edge(4,8));
		eList.add(new Edge(5,6));
		eList.add(new Edge(5,7));
		eList.add(new Edge(7,8));
		
		this.setUndirected(eList);
	}
	
	public void setDefaultDir () {
		// A sample directed graph used in workshop questions
		Vector<Edge> eList = new Vector<Edge>();
		
		eList.add(new Edge(1,2));
		eList.add(new Edge(1,4));
		eList.add(new Edge(2,3));
		eList.add(new Edge(2,5));
		eList.add(new Edge(4,5));
		eList.add(new Edge(5,3));
		eList.add(new Edge(5,6));
		eList.add(new Edge(7,4));
	
		this.setDirected(eList);
	}
	
	public Vector<Edge> readFromFile(String fInName) throws IOException {
		// Reads list of edges from a file, one pair of integers per line 
		BufferedReader fIn = new BufferedReader(
							 new FileReader(fInName));
		String s;
		Vector<Edge> eList = new Vector<Edge>();
		Integer x, y;
		
		while ((s = fIn.readLine()) != null) {
			java.util.StringTokenizer line = new java.util.StringTokenizer(s);
			while (line.hasMoreTokens()) {
				x = Integer.parseInt(line.nextToken());
				y = Integer.parseInt(line.nextToken());
				eList.add(new Edge(x,y));
			}
		}
		fIn.close();
		
		return eList;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph();
		Vector<Edge> eList;
		
		g.setDefault();
		g.print();
		g.setUnmarked();
		
		try {
			eList = g.readFromFile("C:/Users/mark/My Documents/madras/12comp225/mixed/wk9/graph-sample.txt");
			g.setUndirected(eList);
			g.print();
		}
		catch (IOException e) {
			System.out.println("in exception: " + e);
		}
		
		Set<Integer> s;
		s = g.getVertexSet();
		System.out.println(s);
		
	}
}
