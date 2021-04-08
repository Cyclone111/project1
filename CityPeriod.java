import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CityPeriod {
	
	private int CITY_ID;
	private String NAME;
	private Date START_DATE;
	private Date END_DATE;
	private int PRIORITY;
	
	public int getCITY_ID() {
		return this.CITY_ID;
	}

	public void setCITY_ID(int cITY_ID) {
		this.CITY_ID = cITY_ID;
	}

	public String getNAME() {
		return this.NAME;
	}

	public void setNAME(String nAME) {
		this.NAME = nAME;
	}

	public Date getSTART_DATE() {
		return this.START_DATE;
	}

	public void setSTART_DATE(Date sTART_DATE) {
		this.START_DATE = sTART_DATE;
	}

	public Date getEND_DATE() {
		return this.END_DATE;
	}

	public void setEND_DATE(Date eND_DATE) {
		this.END_DATE = eND_DATE;
	}

	public int getPRIORITY() {
		return this.PRIORITY;
	}

	public void setPRIORITY(int pRIORITY) {
		this.PRIORITY = pRIORITY;
	}
	
	public CityPeriod(int CITY_ID, String NAME, Date START_DATE, Date END_DATE, int PRIORITY) {
		
		this.CITY_ID = CITY_ID;
		this.NAME = NAME;
		this.START_DATE = START_DATE;
		this.END_DATE = END_DATE;
		this.PRIORITY = PRIORITY;
	}
	
	public static List<CityPeriod> getPrioritizedPeriods(List<CityPeriod> cityPeriods){
		
		System.out.println("cityPeriods before sort");
		System.out.println(cityPeriods);
		
		Collections.sort(cityPeriods,new MyComparator());
		
		System.out.println("cityPeriods after sort");
		System.out.println(cityPeriods);
		
		List<CityPeriod> l = new ArrayList<CityPeriod>();
		
		int size = cityPeriods.size();
		for(int i = 0; i<size ; i++) {
			for (int j = 1; j < size; j++) {
				Date d1 = cityPeriods.get(j-1).getSTART_DATE();
				Date d2 = cityPeriods.get(j-1).getEND_DATE();
				Date d3 = cityPeriods.get(j).getSTART_DATE();
				
				if ((d2.compareTo(d3) > 0)) {
					l.add(cityPeriods.get(j));
				}
			}
		}
		
		cityPeriods.removeAll(l);
		System.out.println("removed elements");
		System.out.println(l);
		System.out.println("final list");
		return cityPeriods;
	}
	
	public String toString() {
		return "City id: " + this.CITY_ID +" Start date: "+this.START_DATE.toString()+ " End date: "+this.END_DATE.toString()+" Priority: "+ this.PRIORITY + "\r";
	}
	
	public static void main(String[] args) throws ParseException {
		
		String sDate1 = "1-JAN-2021";	String eDate1 = "15-JAN-2021";
		String sDate2 = "1-JAN-2021";	String eDate2 = "15-FEB-2021";
		String sDate3 = "1-MAR-2021";	String eDate3 = "15-MAY-2021";
		String sDate4 = "15-FEB-2021";	String eDate4 = "28-FEB-2021";
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		
		List<CityPeriod> l = new ArrayList<CityPeriod>();
		
		l.add(new CityPeriod(1,"Pune",formatter.parse(sDate1),formatter.parse(eDate1),10));
		l.add(new CityPeriod(2,"Mumbai",formatter.parse(sDate2),formatter.parse(eDate2),20));
		l.add(new CityPeriod(3,"Mumbai",formatter.parse(sDate3),formatter.parse(eDate3),50));
		l.add(new CityPeriod(4,"Delhi",formatter.parse(sDate4),formatter.parse(eDate4),30));
		
		System.out.println(l);
		
		System.out.println(getPrioritizedPeriods(l));
		
	}

}
