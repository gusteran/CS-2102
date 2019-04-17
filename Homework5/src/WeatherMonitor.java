import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherMonitor<TDATA> {

	private LinkedList<TDATA> reports;
	TDATA data;
	
	public WeatherMonitor(TDATA data) {
		this.data = data;
	}
	
	public double averageTempForMonth(int month, int year) {
		return 0;
	}
	
	public double totalRainfallForMonth(int month, int year) {
		return 0;
	}
	
	public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings) {
		LinkedList<Double> temps = new LinkedList<Double>();
		LinkedList<Double> rains = new LinkedList<Double>();
		for(Reading reading: readings) {
			temps.add(reading.getTemp());
			rains.add(reading.getRainfall());
		}
		reports.add(new DailyWeatherReport(date, temps, rains));
	}
	
}
