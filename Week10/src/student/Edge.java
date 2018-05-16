package student;

public class Edge {
	/*
	 * class Edge consists only of a pair of integers, to represent
	 * edges in a graph with vertices labelled with integers; there are
	 * corresponding get and set methods for those
	*/
	 
	private Integer first;
	private Integer second;
	
	public Edge(Integer f, Integer s) {
		first = f;
		second = s;
	}
	
	public Integer getFirst() {
		return first;
	}

	public Integer getSecond() {
		return second;
	}

	public void setFirst(int f) {
		first = f;
	}
	
	public void setSecond(int s) {
		second = s;
	}
}
