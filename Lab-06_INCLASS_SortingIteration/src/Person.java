import java.util.Scanner;

public class Person implements Comparable<Person>{
	public String first_name, last_name;
	public int age;
	public String ssn;
	
	public Person(Scanner fin) {
		this(fin.nextLine());
	}
	
	public Person(String ln) {
		this(ln.split("\t"));
	}
	
	public Person(String[] parts) {
		first_name = parts[0];
		last_name = parts[1];
		age = Integer.parseInt( parts[2] );
		ssn = parts[3];
	}
	
	public String fullName() {
		return first_name + " " + last_name;
	}
	
	public String toString() {
		return String.format("%-35s %3d %15s", fullName(), age, ssn);
	}

	@Override
	public int compareTo(Person p) {
		return age - p.age;
	}
}
