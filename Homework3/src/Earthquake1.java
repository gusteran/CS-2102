import java.util.LinkedList;
/**
 * A class that simulates earthquake data
 * It can return a list of the MaxHzReports from the data for a certain month
 * @author Gus Teran
 *
 */
class Earthquake1 {
  Earthquake1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }
 
  /**
   * Finds the maximum hz value for each day within a certain month
   * using the dailyMax helper
   * @param data the earthquake data preempted by the dates
   * @param month the month for the data
   * @return a LinkedList of MaxHzReports of the highest reading for each day in the data within the month
   */
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
                                                  int month) {
	  LinkedList<MaxHzReport> maxreads = new LinkedList<MaxHzReport>();
	  for(double num: data) {
		  if(isDate(num) & month == extractMonth(num)) {
			  maxreads.add(dailyMax(data, (int)num));
		  }
	  }
	  return maxreads;
  }
  
  /**
   * Finds the max value for a certain date by parsing through the earthquake data
   * @param data the earthquake data arranged as a date followed by the value
   * @param date the specific date for which to find the max value
   * @return a max hz report using the date and the max reading
   */
  public MaxHzReport dailyMax(LinkedList<Double> data, int date) {
	  double maxread = 0;
	  boolean isDay = false;
	  for(double num: data) {
		  if(num == date) isDay = true;
		  else if(isDate(num)) isDay = false;
		  else if(isDay) {
			  if(num > maxread) maxread = num;
		  }
	  }
	  return new MaxHzReport(date, maxread);
  }
}  

