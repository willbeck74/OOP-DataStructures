

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataPoint implements Comparable<DataPoint> {
	//========================================================================= Properties
	private String iso_code, continent, location;
	private Date date;
	private int total_cases, new_cases, total_deaths, new_deaths;
	private static int isoLen = 5, contLen = 5, locLen = 5;
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
	
	//========================================================================= Constructors
	public DataPoint(String line) throws Exception {
		this(line.split("\t"));
	}
	
	public DataPoint(String[] parts) throws Exception {
			this(parts[0], parts[1], parts[2],
				simpleDateFormat.parse(parts[3]),
				Integer.parseInt(("0" + parts[4]).replace("0-", "-")),
				Integer.parseInt(("0" + parts[5]).replace("0-", "-")),
				Integer.parseInt(("0" + parts[6]).replace("0-", "-")),
				Integer.parseInt(("0" + parts[7]).replace("0-", "-"))
				
			);
	}
	//
	public DataPoint(String iso_code, String continent, String location, Date date, 
					 int new_cases, int new_deaths,int total_cases, int total_deaths ) {

		setIso_code(iso_code);				isoLen = Math.max(isoLen, iso_code.length());
		setContinent(continent);			contLen = Math.max(contLen, continent.length());
		setLocation(location);				locLen = Math.max(locLen, location.length());
		setDate(date);
		setTotal_cases(total_cases);
		setNew_cases(new_cases);
		setTotal_deaths(total_deaths);
		setNew_deaths(new_deaths);		
	}
	
	//========================================================================= Methods
	@Override
	public String toString() {
		return String.format("%-" + isoLen + "s %-" + contLen + "s %-" + locLen + "s %12s %,10d %,10d %,10d %,10d", 
				iso_code, continent, location, date, total_cases, new_cases, total_deaths, new_deaths);
	}

	@Override
	public int compareTo(DataPoint dp) {
		return total_deaths - dp.total_deaths;
	}
	
	//========================================================================= Getters / Setters
	public String getIso_code() 					{	return iso_code;					}
	public String getContinent() 					{	return continent;					}
	public String getLocation() 					{	return location;					}
	public Date getDate() 							{	return date;						}
	public int getTotal_cases() 					{	return total_cases;					}
	public int getNew_cases() 						{	return new_cases;					}
	public int getTotal_deaths() 					{	return total_deaths;				}
	public int getNew_deaths() 						{	return new_deaths;					}

	public void setIso_code(String iso_code) 		{	this.iso_code = iso_code;			}
	public void setContinent(String continent)		{	this.continent = continent;			}
	public void setLocation(String location) 		{	this.location = location;			}
	public void setDate(Date date) 					{	this.date = date;					}
	public void setTotal_cases(int total_cases) 	{	this.total_cases = total_cases;		}
	public void setNew_cases(int new_cases) 		{	this.new_cases = new_cases;			}
	public void setTotal_deaths(int total_deaths) 	{	this.total_deaths = total_deaths;	}
	public void setNew_deaths(int new_deaths) 		{	this.new_deaths = new_deaths;		}
}
