import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.stream.Stream;

/**
 * An accumulation of all the weather reports for one day
 * @author Gus Teran
 *
 */
public class DailyWeatherReport{

	private GregorianCalendar date;
	private LinkedList<Double> temps;
	private LinkedList<Double> rains;
	
	public DailyWeatherReport(GregorianCalendar date, LinkedList<Double> temps, LinkedList<Double> rains) {
		this.date = date;
		this.temps = temps;
		this.rains = rains;
	}
	
	public DailyWeatherReport(GregorianCalendar date) {
		this.date = date;
		temps = new LinkedList<Double>();
		rains = new LinkedList<Double>();
	}

	/**
	 * Gives the average temperature for the day
	 * @return the average temperature
	 */
	public double avgTempForDay() {
		return temps.stream().mapToDouble(num -> num).sum()/temps.size();
	}

	/**
	 * Gives the total rainfall for the day
	 * @return the total rainfall
	 */
	public double totalRainfallForDay() {
		return rains.stream().mapToDouble(num -> num).sum();
	}

	/**
	 * Determines if the date is of a certain month and year
	 * @param month the month as an integer
	 * @param year the year
	 * @return a boolean of whether the date of the report is within the given month and year
	 */
	public boolean isMonth(int month, int year) {
		return date.get(date.YEAR) == year && date.get(date.MONTH) == month;
	}

	/**
	 * Adds a weather reading to the daily report
	 * @param reading the weather reading
	 */
	public void addReading(Reading reading) {
		temps.add(reading.getTemp());
		rains.add(reading.getRainfall());
	}

	
	
}
