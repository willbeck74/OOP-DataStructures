import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Tester {

	static ArrayList<Student> alStudents = new ArrayList<Student>();
    static DoublyLinkedCollectionIteration<Student> dlStudents = new DoublyLinkedCollectionIteration<Student>();
    
    public static void main(String[] args) {
    	loadData("StudentData.txt");
    	//getTotalAverage();
    	//getTop10();
    	//getBottom();
    	
    	//for(Student s : alStudents)
    	//	System.out.println(s);
    	
    }

	private static void loadData(String fileName) {
		try(Scanner fin = new Scanner(new File(fileName))){
			fin.nextLine();
			while(fin.hasNextLine()) {
				alStudents.add(new Student(fin.nextLine().split("\t")));
				dlStudents.add(new Student(fin.nextLine()));
			}
				
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Collections.sort(alStudents, new Comparator<Student>(){
			public int compare(Student s1, Student s2) {
				return s1.fullName().compareTo(s2.fullName());
			}
		});
		
	}
	
	private static void getTotalAverage() {
		Iterator<Student> ret = dlStudents.iterator();
		double totalAvg = 0;
		while(ret.hasNext()) {
			totalAvg += ret.next().average();
		}
		System.out.println("Total Avg: " + totalAvg/dlStudents.size());
	}
	
	private static void getTop10() {
		Collections.sort(alStudents, new Comparator<Student>(){
			public int compare(Student s1, Student s2) {
				return (int) (s1.average() - s2.average());
			}
		});
		for(Student s : alStudents)
			System.out.println(s);
	}
    private static void getBottom() {
    	Collections.sort(alStudents, new Comparator<Student>(){
			public int compare(Student s1, Student s2) {
				return (int) (s2.average() - s1.average());
			}
		});
		for(Student s : alStudents)
			System.out.println(s);
    }
}
