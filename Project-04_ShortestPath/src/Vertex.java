import java.util.Map; 


public class Vertex implements Comparable<Vertex> {

	public String name;
	
	public Vertex(String name) {
		super();
		this.name = name;
	}

	@Override
	public int compareTo(Vertex v) {
		return name.compareTo(v.name);
	}
	public String toString() {
		return name;	
		}

}
