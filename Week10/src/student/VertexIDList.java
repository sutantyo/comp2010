package student;

import java.util.*;

public class VertexIDList extends TreeMap<Integer, Boolean> {

	/*
	 * List of vertices, to be used predominantly to represent
	 * the neighbours of a vertex
	 * 
	 * As an extension of TreeMap, inherits its methods, such
	 * as size()
	 */
	
	private Iterator<Map.Entry<Integer, Boolean>> it; 
	
	public VertexIDList() {
		// constructor
		super();
	}
	
	public Integer top() {
		// returns first element of list, treating as a queue
		return this.firstKey();
	}
	
	public void pop() {
		// deletes first element of list, treating as a queue
		this.remove(this.firstKey());
	}
	
	public void push(Integer n) {
		// inserts first element of list, treating as a queue
		this.put(n, true);
	}
	
	public void print() {
		it = this.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Boolean> pairs = it.next();
			System.out.print(" " + pairs.getKey());
		}		
		System.out.println();
	}
	
	public Iterator<Integer> iterator() {
		// returns an iterator to use to iterate over the list
		return this.keySet().iterator();
	}

	public static void main(String[] args) {
		VertexIDList v = new VertexIDList();
		
		v.push(2);
		v.push(5);
		v.push(3);
		v.print();
		v.pop();
		System.out.println(v.top());
		v.print();
		
		Iterator<Integer> vIt = v.iterator();
		
		System.out.println("testing iterator ...");
		while (vIt.hasNext()) {
			System.out.println(vIt.next());
		}
		v.print();
	}
}
