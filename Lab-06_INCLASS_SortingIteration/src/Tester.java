import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Tester {

	static ArrayList<Person> people = new ArrayList<Person>();
	
	public static void main(String[] args) {
		loadData("MOCK_DATA.txt");
		//printReport();
		customPrint();
		
	}
	
	private static void customPrint() {
//		Comparator<Person> lnSort = new Comparator<Person>() {
//			public int compare(Person o1, Person o2) {
//				return(o1.last_name + "~" + o1.first_name).toUpperCase()
//						.compareTo(  (o2.last_name + "~" + o2.first_name).toUpperCase()  );
//			}
//		};
		Collections.sort(people, new Comparator<Person>(){
			public int compare(Person o1, Person o2) {
				return o2.ssn.compareTo(o1.ssn);
			}
		});
		for(Person p : people)
			System.out.println(p);
	}

	private static void printReport() {
		
		Collections.sort(people);
		
		for(Person p : people)
			System.out.println(p);
	}

	private static void loadData(String fileName) {
		try(Scanner fin = new Scanner(new File(fileName))){
			fin.nextLine();
			
			while(fin.hasNextLine())
				people.add(new Person(fin.nextLine().split("\t")));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
