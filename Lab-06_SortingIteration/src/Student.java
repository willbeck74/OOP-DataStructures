import java.util.Collections;
import java.util.Scanner;

public class Student implements Comparable<Student>{
	public String fName, lName;
	public int age;
	public double test1, test2, test3, test4;
	
	public Student(Scanner in) {
		this(in.nextLine());
	}
	
	public Student(String ln) {
		this(ln.split("\t"));
	}

	public Student(String[] parts) {
		fName = parts[0];
		lName = parts[1];
		age = Integer.parseInt(parts[2]);
		test1 = Double.parseDouble(parts[3]); 
		test2 = Double.parseDouble(parts[4]);
		test3 = Double.parseDouble(parts[5]);
		test4 = Double.parseDouble(parts[6]);
	}
	
	public double average() {
		double total = test1 + test2 + test3 + test4;
		return (total/4.0);
	}
	
	public String fullName() {
		return fName + " " + lName;
	}
	
	public String toString() {
		return fullName() + " " + average();
	}

	@Override
	public int compareTo(Student o) {
		return age - o.age;  
	}

	
}
