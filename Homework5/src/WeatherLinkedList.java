import java.util.LinkedList;

/**
 * A linked list of weather reports. 
 * Implements the IWeatherDataStructure
 * @author Gus Teran
 *
 */
public class WeatherLinkedList implements IWeatherDataStructure {

	private LinkedList<DailyWeatherReport> reports;
	
	public WeatherLinkedList() {
		reports = new LinkedList<DailyWeatherReport>();
	}
	
	public WeatherLinkedList(LinkedList<DailyWeatherReport> reports) {
		this.reports = reports;
	}

	@Override
	public void addReport(DailyWeatherReport report) {
		reports.add(report);
	}

	@Override
	public LinkedList<DailyWeatherReport> getReportsForMonth(int month, int year) {
		LinkedList<DailyWeatherReport> forMonth = new LinkedList<DailyWeatherReport>();
		for(DailyWeatherReport report: reports) {
			if(report.isMonth(month, year)) forMonth.add(report);
		}
		return forMonth;
	}
	

}
