import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * A weather monitor that can find the average temperature
 * and total rainfall for a given month of daily weather reports.
 * It can add reports based on a day and a list of readings.
 * @author Gus Teran
 *
 */
public class WeatherMonitor{

	private IWeatherDataStructure reports;
	
	public WeatherMonitor(IWeatherDataStructure reports) {
		this.reports = reports;
	}

	/**
	 * Finds the average temperature for a given month and year using the daily weather reports
	 * from that month
	 * @param month the month as an integer
	 * @param year the year
	 * @return the average temperature as a double for the given month of weather reports
	 */
	public double averageTempForMonth(int month, int year) {
		double sum = 0;
		int count = 0;
		for(DailyWeatherReport report: reports.getReportsForMonth(month, year)) {
			sum += report.avgTempForDay();
			count++;
		}
		if(count == 0) return 0;
		return sum / count;
	}
	
	/**
	 * Finds the total rainfall for a month and year using the daily weather reports from that month
	 * @param month the month as an integer
	 * @param year the year
	 * @return the total rainfall as a double for the given month of weather reports
	 */
	public double totalRainfallForMonth(int month, int year) {
		double sum = 0;
		for(DailyWeatherReport report: reports.getReportsForMonth(month, year)) {
			sum += report.totalRainfallForDay();
		}
		return sum;
	}
	
	/**
	 * Adds a weather report to the weather data structure using a date and a list of readings from
	 * that given day
	 * @param date the day of the readings
	 * @param readings a list of all the readings from that day
	 */
	public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings) {
		LinkedList<Double> temps = new LinkedList<Double>();
		LinkedList<Double> rains = new LinkedList<Double>();
		for(Reading reading: readings) {
			temps.add(reading.getTemp());
			rains.add(reading.getRainfall());
		}
		reports.addReport(new DailyWeatherReport(date, temps, rains));
	}
	
}
