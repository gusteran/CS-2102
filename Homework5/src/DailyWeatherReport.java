import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyWeatherReport {

	private GregorianCalendar date;
	private LinkedList<Double> temps;
	private LinkedList<Double> rains;
	
	public DailyWeatherReport(GregorianCalendar date, LinkedList<Double> temps, LinkedList<Double> rains) {
		this.date = date;
		this.temps = temps;
		this.rains = rains;
	}
	
	
	
	
}
