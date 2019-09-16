
/**
 * The time in hours and minutes. 
 * It uses a 24 hour system
 * @author Gus Teran
 *
 */
public class Time {
	private int hour;
	private int minute;
	
	public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	/**
	 * Gets the hour (military time system)
	 * @return the hour as an integer
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * Gets the minute
	 * @return the minute as an integer
	 */
	public int getMinute() {
		return minute;
	}
	
}
