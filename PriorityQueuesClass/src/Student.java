
public class Student implements Comparable<Student> {

	private String name;
	private int actScore;
	private boolean legacy;
	
	public Student() {
		this.name = name;
		this.actScore = actScore;
		this.legacy = legacy;
	}
	
	public Student(String name, int act, boolean leg) {
		this.name = name;
		this.actScore = act;
		this.legacy = leg;
	}

	private int getNewACT() {
		return actScore + (legacy ? 2 : 0);
	}
	
	@Override
	public int compareTo(Student o) {
		if(actScore != o.actScore)
			return actScore - o.actScore;
		return name.compareTo(o.name);
	}
	
	public String toString() {
		return String.format("<%-5s %d>", name, actScore);
	}

}
