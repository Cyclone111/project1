import java.util.Comparator;
import java.util.Date;

public class MyComparator implements Comparator{
	
	public int compare(Object obj1, Object obj2) {
		
		CityPeriod c1 = (CityPeriod) obj1;
		CityPeriod c2 = (CityPeriod) obj2;
		
		Date s1 = c1.getSTART_DATE();
		Date s2 = c2.getSTART_DATE();
		
		Date e1 = c1.getEND_DATE();
		Date e2 = c2.getEND_DATE();
		
		if(s1.compareTo(s2) > 0) {
			return +1;
		}
		else if(s1.compareTo(s2) < 0) {
			return -1;
		}
		else{
			if(c1.getPRIORITY() > c2.getPRIORITY()) {
				return -1;
			}
			else if(c2.getPRIORITY() < c1.getPRIORITY()){
				return +1;
			}
			else {
				return 0;
			}
		}
		
	}

}
