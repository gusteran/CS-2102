import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * A class to test the functionality of a weather monitor
 * @author Gus Teran
 *
 */
public class Examples {
	LinkedList<Reading> initialReadings = new LinkedList<Reading>();
	LinkedList<Reading> newReadings = new LinkedList<Reading>();
	GregorianCalendar day = new GregorianCalendar(2000, 10, 10);
	GregorianCalendar day2 = new GregorianCalendar(2000, 10, 15);
	DailyWeatherReport report = new DailyWeatherReport(day, new LinkedList<Double>(), new LinkedList<Double>());
	WeatherMonitor test = new WeatherMonitor(new WeatherLinkedList());
	
	
	@Before
	public void setup() {
		initialReadings.add(new Reading(new Time(10, 10), 50.0, 5.0));
		test.addDailyReport(day , initialReadings);
	}
	
	@Test
	public void rainTest() {
		assertEquals(test.totalRainfallForMonth(10, 2000), 5.0, 0.1);
	}
	
	@Test
	public void tempTest() {
		assertEquals(test.averageTempForMonth(10, 2000), 50.0, 0.1);
	}
	
	@Test
	public void raintest2() {
		newReadings.add(new Reading(new Time(10, 10), 60.0, 9.0));
		test.addDailyReport(day , newReadings);
		assertEquals(test.totalRainfallForMonth(10, 2000), 14.0, 0.1);
	}
	
	@Test
	public void tempTest2() {
		newReadings.add(new Reading(new Time(10, 10), 60.0, 9.0));
		test.addDailyReport(day , newReadings);
		assertEquals(test.averageTempForMonth(10, 2000), 55.0, 0.1);
	}
	
	@Test
	public void rainTestDiffMonth() {
		assertEquals(test.totalRainfallForMonth(11, 2000), 0.0, 0.1);
	}
	
	@Test
	public void tempTestDiffMonth() {
		assertEquals(test.averageTempForMonth(10, 2001), 0.0, 0.1);
	}
	
	@Test
	public void rainTestDayBalancing() {
		newReadings.add(new Reading(new Time(10, 10), 100.0, 10.0));
		newReadings.add(new Reading(new Time(10, 10), 90.0, 20.0));
		test.addDailyReport(day2 , newReadings);
		assertEquals(test.totalRainfallForMonth(10, 2000), 35.0, 0.1);
	}
	
	@Test
	public void tempTestDayBalancing() {
		newReadings.add(new Reading(new Time(10, 10), 100.0, 10.0));
		newReadings.add(new Reading(new Time(10, 10), 90.0, 20.0));
		test.addDailyReport(day2 , newReadings);
		assertEquals(test.averageTempForMonth(10, 2000), 72.5, 0.1);
	}
	
	@Test
	public void rainTestEmpty() {
		assertEquals(new WeatherMonitor(new WeatherLinkedList()).totalRainfallForMonth(10, 2000), 0.0, 0.1);
	}
	
	@Test
	public void tempTestEmpty() {
		assertEquals(new WeatherMonitor(new WeatherLinkedList()).averageTempForMonth(10, 2000), 0.0, 0.1);
	}
	
	

}
