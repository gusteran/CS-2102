
import java.util.LinkedList;
/**
 * A class that smooths the numbers in a linked list of doubles
 * 
 * @author Gus Teran
 *
 */
class DataSmooth1 {
	DataSmooth1() {
	}
	/**
	 * Returns a smoothed version of the average runtime of the shows in the list
	 * using the getSmooth and setAverageRuntime helper methods. 
	 * It parses through the list and calls getSmooth on each
	 * @param shows a list of shows
	 * @return a list of doubles of the smoothed average runtimes of the list of shows
	 */
	public LinkedList<Double> dataSmooth(LinkedList<Show> shows) {

		LinkedList<Double> smoothList = new LinkedList<Double>();
		if (shows.size() < 1)
			return smoothList;

		setAverageRuntime(shows);

		for(Show show: shows) {
			smoothList.add(getSmooth(shows, shows.indexOf(show)));
		}
		return smoothList;
	}

	/**
	 * Returns the smoothed value of an index within the list of shows. 
	 * Requires that the avgLength values of the show are set. 
	 * Returns the same value for the first and last indexes of the string.
	 * Returns the average of the value and its negihbors for the rest.
	 * @param shows a list of shows
	 * @param index the index within the list
	 * @return the smoothed value of the average runtime for the given index within the list of shows
	 */
	public double getSmooth(LinkedList<Show> shows, int index) {
		if (index > 0 & index + 1 < shows.size())
			return (shows.get(index - 1).avgLength + shows.get(index).avgLength 
					+ shows.get(index + 1).avgLength) / 3;
		if(index == 0 | index + 1 == shows.size())
			return shows.get(index).avgLength;
		return 0;
	}

	/**
	 * Sets the average runtime for all the shows in the list
	 * 
	 * @param shows a list of shows
	 */
	public void setAverageRuntime(LinkedList<Show> shows) {
		for (Show show : shows) {
			setAverageRuntime(show);
		}
	}

	/**
	 * Sets the average runtime for a show based on its episodes' runtimes
	 * 
	 * @param show a show
	 */
	public void setAverageRuntime(Show show) {
		int count = 0;
		int sum = 0;
		for (Episode episode : show.episodes) {
			count++;
			sum += episode.runTime;
		}
		if (count == 0)
			show.setAvgLength(0);
		else
			show.setAvgLength(sum / count);
	}
}