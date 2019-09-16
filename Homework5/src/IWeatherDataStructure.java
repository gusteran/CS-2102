import java.util.LinkedList;

/**
 * An interface for the data structure of the weather reports
 * @author Gus Teran
 *
 */
public interface IWeatherDataStructure {
	
	/**
	 * Adds a daily report to the list
	 * @param report the daily weather report
	 */
	public void addReport(DailyWeatherReport report);
	
	/**
	 * Gives a separate list of all the daily weather reports from a certain month of a given year
	 * @param month the month as an integer
	 * @param year the year
	 * @return a linked list of all the daily weather reports from the month
	 */
	public LinkedList<DailyWeatherReport> getReportsForMonth(int month, int year);
}
