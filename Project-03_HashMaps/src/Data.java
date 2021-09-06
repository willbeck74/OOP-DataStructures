
import java.io.File; 
import java.io.PrintWriter;
import java.util.*;

/**
 * 
 * TO-DO: Fill in the code for the following methods: 
 *
 *		public Set<String> allContinents()
 * 		public Set<String> getLocationsInThisContinent(String continent)
 * 		public MapInterface<String, Integer> casesByLocation()
 * 		public MapInterface<String, Integer> casesByLocation(int month)
 * 		public MapInterface<String, Set<String>> locationsByContinent()
 * 		public MapInterface<String, Integer> codeCounts()
 * 		public MapInterface<Date, Integer> casesByDate()
 * 		public MapInterface<Integer, Integer> casesByMonth()
 * 
 */

public class Data<T> {

	/***********************************************************************************************/
	/**************************** DON'T MODIFY ANYTHING IN THIS SECTION ****************************/
	/***********************************************************************************************/
	/***/ 	/* A global array list of Event objects */											/***/
	/***/	private ArrayList<DataPoint> dataPoints = new ArrayList<DataPoint>();				/***/
	/***/																						/***/
	/***/	/* Constructor */																	/***/
	/***/	/* Reads file data into an ArrayList of Event objects. DON'T CHANGE THIS. */		/***/
	/***/	public Data(String filename) {														/***/
	/***/		try(Scanner fin = new Scanner(new File(filename))){								/***/
	/***/			fin.nextLine();																/***/
	/***/			while(fin.hasNextLine())													/***/
	/***/				dataPoints.add(new DataPoint(fin.nextLine()));							/***/
	/***/		} catch (Exception e) {															/***/
	/***/			e.printStackTrace();														/***/
	/***/		}																				/***/
	/***/	}																					/***/
	/***/																						/***/
	/***/	/* Writes a collection (list, set) to a specified file. DON'T CHANGE THIS. */		/***/
	/***/	public static <T> void display(PrintWriter pw, Collection<T> items) {				/***/
	/***/		if (items == null) {															/***/
	/***/			pw.println("null");															/***/
	/***/			return;																		/***/
	/***/		}																				/***/
	/***/		int LEN = 80, curr = 0;															/***/
	/***/		String line = "";																/***/
	/***/		for (T item : items) {															/***/
	/***/			line += ", ";																/***/
	/***/			curr += item.toString().length();											/***/
	/***/			if (curr >= LEN) {															/***/
	/***/				curr = 0;																/***/
	/***/				line += "\n";															/***/
	/***/			}																			/***/
	/***/			line += item.toString();													/***/
	/***/		}																				/***/
	/***/		pw.println("[" + line.substring(2) + "]");										/***/
	/***/	}																					/***/
	/***/																						/***/
	/***/	/* Writes a map to a specified file DON'T CHANGE THIS. */							/***/
	/***/	@SuppressWarnings("unchecked")														/***/
	/***/	public static <K, V> void display(PrintWriter pw, MapInterface<K, V> items) {		/***/
	/***/		if (items == null) {															/***/
	/***/			pw.println("null");															/***/
	/***/			return;																		/***/
	/***/		}																				/***/
	/***/																						/***/
	/***/		for (K key : items.keySet()) {													/***/
	/***/			pw.print(key + " ----------> ");											/***/
	/***/			Object o = items.get(key);													/***/
	/***/			if (o instanceof Collection) {												/***/
	/***/				pw.println();															/***/
	/***/				display(pw, (Collection<Object>) items.get(key));						/***/
	/***/			} else {																	/***/
	/***/				pw.println(items.get(key));												/***/
	/***/			}																			/***/
	/***/		}																				/***/
	/***/	}																					/***/
	/***/																						/***/
	/***/	public void export(String fileName, Collection<T> items) {							/***/
	/***/		try(PrintWriter pw = new PrintWriter(fileName)){								/***/
	/***/			display(pw, items);															/***/
	/***/		} catch (Exception e) {															/***/
	/***/			e.printStackTrace();														/***/
	/***/		}																				/***/
	/***/	}																					/***/
	/***/																						/***/
	/***/	public void export(String fileName, MapInterface<?, ?> items) {						/***/
	/***/		try(PrintWriter pw = new PrintWriter(fileName)){								/***/
	/***/			display(pw, items);															/***/
	/***/		} catch (Exception e) {															/***/
	/***/			e.printStackTrace();														/***/
	/***/		}																				/***/
	/***/	}																					/***/
	/***/																						/***/
	/***********************************************************************************************/
	/***********************************************************************************************/

	
	/**
	 * Returns a set of all location names in the database
	 */
	public Set<String> allContinents() {
		Set<String> ret = new TreeSet<String>();
		for(DataPoint dp : dataPoints) {
			if(dp.getContinent().length() > 0)
				ret.add(dp.getLocation());
		}
		return ret;
	}

	/**
	 * Returns all the locations in a particular continent. The empty set is
	 * returned if the continent does not have any locations.
	 */
	public Set<String> getLocationsInThisContinent(String continent) {
		Set<String> ret = new TreeSet<String>();
		for(DataPoint dp : dataPoints)
			if(dp.getContinent().equals(continent))
				ret.add(dp.getLocation());
		return ret;
	}

	/**
	 * Returns a map keyed to a location, where the value is the total number of
	 * cases for that location. The map should only contain locations that had at
	 * least 1 case.
	 */
	public MapInterface<String, Integer> casesByLocation() {
		MapInterface<String, Integer> ret = new HashMap274<String, Integer>();
		
		for(DataPoint dp : dataPoints)
			ret.put(dp.getLocation(), dp.getNew_cases() + ret.getOrDefault(dp.getLocation(), 0) );
		
//		Set<String> loc = allLocations();
//		int totalCases = 0;
//		for(String l : loc) {
//			for(DataPoint dp : dataPoints) {
//				if(dp.getLocation().equals(l) && dp.getNew_cases() > 0)
//					totalCases += dp.getNew_cases();
//			}
//			ret.put(l, totalCases);
//			totalCases = 0;
//		}
		return ret;
	}

	/**
	 * For a specified month (0 is January, 1 is February, and so on), returns a map
	 * keyed to a location, where the value is the total number of cases for that
	 * location. The map should only contain locations that had at least one case.
	 * If there are no cases for a given month, returns an empty map. NOTE: Date has
	 * a getMonth() method you can use. You may get a warning that getMonth() is a
	 * deprecated method, but that's ok.
	 */
	public MapInterface<String, Integer> casesByLocation(int month) {
		MapInterface<String, Integer> ret = new HashMap274<String, Integer>();
		for(DataPoint dp : dataPoints)
			if(dp.getDate().getMonth() == month)
				ret.put(dp.getLocation(), dp.getNew_cases() + ret.getOrDefault(dp.getLocation(), 0));
		
//		Set<String> loc = allLocations();
//		int totalCases = 0;
//		for(String l : loc) {
//			for(DataPoint dp : dataPoints)
//				if(dp.getLocation().equals(l) && dp.getDate().getMonth() == month)
//					totalCases += dp.getNew_cases();
//			if(totalCases > 0) {
//				ret.put(l, totalCases);
//				totalCases = 0;
//			}
//		}
		return ret;
	}
	
	/**
	 * Returns a map keyed to the continent, where the value for each continent is a
	 * set of all locations in that continent.
	 */
	public MapInterface<String, Set<String>> locationsByContinent() {
		MapInterface<String, Set<String>> ret = new HashMap274<String, Set<String>>();
		Set<String> contLoc = new TreeSet<String>();
		Set<String> cont = allContinents();
		for(DataPoint dp : dataPoints) {
			for(String c : cont)
				if(dp.getContinent().equals(c))
					contLoc.add(dp.getLocation());
			ret.put(dp.getContinent(), contLoc);
		}
		return ret;
	}

	/**
	 * Returns a map keyed to a location's iso_code, where the value is the
	 * total number of times that iso_code appears in the data.
	 */
	public MapInterface<String, Integer> codeCounts() {
		MapInterface<String, Integer> ret = new HashMap274<String, Integer>();
		Set<String> loc = new TreeSet<String>();
		for(DataPoint dp : dataPoints)
			loc.add(dp.getIso_code());
		int totalIso = 0;
		for(String l : loc) {
			for(DataPoint dp : dataPoints)
				if(dp.getIso_code().equals(l))
					totalIso++;
			ret.put(l, totalIso);
			totalIso=0;
		}
		return ret;
	}

	/**
	 * Returns a map keyed to the date, where the value is the total number of cases
	 * for that date.
	 */
	public MapInterface<Date, Integer> casesByDate() {
		Set<Date> dates = new TreeSet<Date>();
		MapInterface<Date, Integer> ret = new HashMap274<Date, Integer>();
		for(DataPoint dp : dataPoints)
			dates.add(dp.getDate());
		int totalCases = 0;
		for(Date d : dates) {
			for(DataPoint dp : dataPoints)
				if(dp.getDate().equals(d))
					totalCases += dp.getNew_cases();
			ret.put(d, totalCases);
			totalCases = 0;
		}
		return ret;
	}

	/**
	 * Returns a map keyed to a month (0=January, 1=February, and so on), where the
	 * value is the number of reported cases for that month. Only include months
	 * that are listed in the data. NOTE: Date has a getMonth() method you can use.
	 * You may get a warning that getMonth() is a deprecated method, but that's ok.
	 */
	public MapInterface<Integer, Integer> casesByMonth() {
		MapInterface<Integer, Integer> ret = new HashMap274<Integer, Integer>();
		int cases = 0;
		for(DataPoint dp : dataPoints) {
			int month = dp.getDate().getMonth();
			ret.put(month, dp.getNew_cases());
		}
		return null;
	}
	

	//=============================================================== Completed for you
	/** 
	 * Returns a set of all location names in the database
	 */
	public Set<String> allLocations() {	//===================== Done in video
		Set<String> ret = new HashSet<String>();
		for(DataPoint dp : dataPoints) {
			String loc = dp.getLocation();
			if(loc.length() > 0)
				ret.add(loc);
		}
		return ret;
	}

	/**
	 * Returns a map keyed to a continent, where the value is the total number of deaths in that continent.
	 */
	public MapInterface<String, Integer> deathsByContinent() {	//===================== Done in video
		MapInterface<String, Integer> ret = new HashMap274<String, Integer>();
		for(DataPoint dp : dataPoints) {
			String cont = dp.getContinent();
			if(cont.length() > 0)
			ret.put(cont, dp.getNew_deaths() + ret.getOrDefault(cont, 0));
		}
		return ret;
	}

}
