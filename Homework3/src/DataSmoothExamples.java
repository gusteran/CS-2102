import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

/**
 * A testing class for the DataSmooth classes
 * 
 * @author Gus Teran
 *
 */
public class DataSmoothExamples {
	LinkedList<Show> shows = new LinkedList<Show>();
	LinkedList<Double> showResults = new LinkedList<Double>();
	LinkedList<Show> shows1 = new LinkedList<Show>();
	LinkedList<Double> showResults1 = new LinkedList<Double>();
	LinkedList<Show> shows2 = new LinkedList<Show>();
	LinkedList<Double> showResults2 = new LinkedList<Double>();
	DataSmooth1 D1 = new DataSmooth1();
	// DataSmooth2 D1 = new DataSmooth2();

	public DataSmoothExamples() {
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));
		shows.add(new Show("Star Trek", 1800, eps1, false));// 60
		shows1.add(new Show("Star Trek", 1800, eps1, false));
		shows2.add(new Show("Star Trek", 1800, eps1, false));

		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		shows.add(new Show("Futurama", 1900, eps2, false));// 22
		shows2.add(new Show("Futurama", 1900, eps2, false));

		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		shows.add(new Show("Animaniacs", 1630, eps3, false));// 7

		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		shows.add(new Show("Sesame Street", 900, eps4, false));// 58
		shows2.add(new Show("Sesame Street", 900, eps4, false));

		showResults.add(60.0);
		showResults.add(29.66);
		showResults.add(29.0);
		showResults.add(58.0);

		showResults1.add(60.0);

		showResults2.add(60.0);
		showResults2.add(46.67);
		showResults2.add(58.0);
	}

	@Test
	public void instructorTestDS() {
		LinkedList<Double> runtimes = D1.dataSmooth(shows);

		for (int i = 0; i < runtimes.size(); i++) {
			assertEquals(runtimes.get(i), showResults.get(i), .01);
		}
	}

	@Test
	public void empty() {
		LinkedList<Double> runtimes = D1.dataSmooth(new LinkedList<Show>());

		assertEquals(new LinkedList<Double>(), runtimes);
	}
	
	@Test
	public void list1() {
		LinkedList<Double> runtimes = D1.dataSmooth(shows1);

		for (int i = 0; i < runtimes.size(); i++) {
			assertEquals(runtimes.get(i), showResults1.get(i), .01);
		}
	}
	
	@Test
	public void list2() {
		LinkedList<Double> runtimes = D1.dataSmooth(shows2);

		for (int i = 0; i < runtimes.size(); i++) {
			assertEquals(runtimes.get(i), showResults2.get(i), .01);
		}
	}

}