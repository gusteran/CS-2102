import java.util.LinkedList;
/**
 * A class that simulates earthquake data
 * It can return a list of the MaxHzReports from the data for a certain month
 * @author Gus Teran
 *
 */
class Earthquake2 {
  Earthquake2(){}
      
  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

  /**
   * Parses through the data and returns a list of the MaxHzReport of 
   * the highest value for each day of the chosen month
   * @param data the earthquake data preempted by the dates
   * @param month the month for the data
   * @return a LinkedList of MaxHzReports of the highest reading for each day in the data within the month
   */
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
                                                  int month) {
	  LinkedList<MaxHzReport> maxreads = new LinkedList<MaxHzReport>();
	  
	  for(int i = 0; i < data.size(); i++) {
		  if(isDate(data.get(i)) && month == extractMonth(data.get(i))) {
			  double max = 0;
			  double date = data.get(i++);
			  while(i<data.size() && !isDate(data.get(i))) {
				  if(data.get(i)>max) {
					  max = data.get(i);
				  } 
				  i++;
			  }
			  i--;
			  maxreads.add(new MaxHzReport(date, max));
		  }
	  }
	  
	  return maxreads;
  }
}