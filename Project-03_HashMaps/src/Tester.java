import java.util.HashMap;

/**
 * 
 * For this project you are to code the empty methods 
 * in the Data and HashMap274 classes.  Some methods 
 * have been written for you and the video will cover
 * the details on how everything works together. 
 *
 */

public class Tester {
	
	public static void main(String[] args) {
		
		System.out.println("STARTING");
		
		// This puts all the data from the file into a list
		Data data = new Data("covid-data.txt");
		
		//data.export("output.txt", data.allContinents());
		//data.export("output.txt", data.getLocationsInThisContinent("North America"));
		//System.out.println(data.getLocationsInThisContinent("North America"));
		//System.out.println(data.casesByLocation());
		System.out.println(data.casesByLocation(3));
		
		

		System.out.println("DONE");
	}

}
