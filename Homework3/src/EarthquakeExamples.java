import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;
/**
 * A test class for the Earthquake classes
 * @author Gus Teran
 *
 */
public class EarthquakeExamples {
	Earthquake1 E1 = new Earthquake1();
//	Earthquake2 E1 = new Earthquake2();
	LinkedList<Double> noData = new LinkedList<Double>();
	LinkedList<Double> threeDates = new LinkedList<Double>();
	LinkedList<Double> manyDates = new LinkedList<Double>();
	LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
	LinkedList<MaxHzReport> OctReports = new LinkedList<MaxHzReport>();
	LinkedList<MaxHzReport> JanReports = new LinkedList<MaxHzReport>();


	public EarthquakeExamples() {
		threeDates.add(20151013.0);
		threeDates.add(10.0);
		threeDates.add(5.0);
		threeDates.add(20151020.0);
		threeDates.add(40.0);
		threeDates.add(50.0);
		threeDates.add(45.0);
		threeDates.add(20151101.0);
		threeDates.add(6.0);
		NovReports.add(new MaxHzReport(20151101.0, 6.0));
		OctReports.add(new MaxHzReport(20151013.0, 10.0));
		OctReports.add(new MaxHzReport(20151020.0, 50.0));
		
		
		manyDates.add(20190113.0);
		manyDates.add(10.0);
		manyDates.add(3.0);
		manyDates.add(2.0);
		manyDates.add(10.0);JanReports.add(new MaxHzReport(20190113.0,10.0));
		manyDates.add(20190120.0);
		manyDates.add(40.0);JanReports.add(new MaxHzReport(20190120,40.0));
		manyDates.add(20190121.0);
		manyDates.add(6.0);JanReports.add(new MaxHzReport(20190121,6.0));
		manyDates.add(20190123.0);
		manyDates.add(10.0);JanReports.add(new MaxHzReport(20190123.0,10.0));
		manyDates.add(20190124.0);
		manyDates.add(40.0);
		manyDates.add(100.0);JanReports.add(new MaxHzReport(20190124,100.0));
		manyDates.add(20190126.0);
		manyDates.add(94.0);JanReports.add(new MaxHzReport(20190126,94.0));
	}

	@Test
	public void instructorTestEQ() {
		assertEquals(NovReports, E1.dailyMaxForMonth(threeDates, 11));
	}

	@Test
	public void october() {
		assertEquals(OctReports, E1.dailyMaxForMonth(threeDates, 10));
	}
	@Test
	public void badMonth() {
		assertEquals(new LinkedList<MaxHzReport>(), E1.dailyMaxForMonth(threeDates, 9));
		assertEquals(new LinkedList<MaxHzReport>(), E1.dailyMaxForMonth(manyDates, 12));
	}
	@Test
	public void january() {
		assertEquals(JanReports, E1.dailyMaxForMonth(manyDates, 1));
	}

}
