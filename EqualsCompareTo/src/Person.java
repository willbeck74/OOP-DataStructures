
public class Person implements Comparable<Person>{
	public String fname, lname, email;
	public int age;
	
	public Person(String fname, String lname, String email, int age) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.age = age;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Person)) return false;
		Person p = (Person)obj;
		return fname.equals(p.fname) &&
			   lname.equals(p.lname) &&
			   email.equals(p.email) &&
			   age == p.age;
		//return data().equals(((Person)obj).data());
	}
	
	public int compareTo(Person p) {
		//return age - p.age
		//return fname.compareTo(p.fname)
		//return lname.compareTo(p.lname);
		return email.substring(email.indexOf("@")).compareTo(p.email.substring(p.email.indexOf("@")));
	}
	
	private String data() {
		return fname + "~" + lname + "~" + email + "~" + age;
	}
	
	@Override
	public String toString() {
		return data();
	}
	
}












