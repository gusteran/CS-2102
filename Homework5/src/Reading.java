/**
 * A weather report
 * @author Gus Teran
 *
 */
public class Reading {

	private Time time;
	private double temp;
	private double rainfall;
	
	public Reading(Time time, double temp, double rainfall) {
		this.time = time;
		this.temp = temp;
		this.rainfall = rainfall;
	}
	
	/**
	 * Gets for the time
	 * @return the time of the report
	 */
	public Time getTime() {
		return time;
	}

	/**
	 * Gets the temperature
	 * @return the temperature as a double
	 */
	public double getTemp() {
		return temp;
	}

	/**
	 * Gets the rainfall since the last reading
	 * @return the rainfall as a double
	 */
	public double getRainfall() {
		return rainfall;
	}


}
