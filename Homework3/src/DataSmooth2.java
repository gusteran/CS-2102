import java.util.LinkedList;
/**
 * A class that smooths the numbers in a linked list of doubles
 * 
 * @author Gus Teran
 *
 */
class DataSmooth2 {
  DataSmooth2(){}
  /**
	 * Returns a smoothed version of the average runtime of the shows in the list
	 * using the average and episodeRuntimes helper methods. 
	 * It parses through the list and averages the average runtime with its neighbors
	 * using the helpers
	 * @param shows a list of shows
	 * @return a list of doubles of the smoothed average runtimes of the list of shows
	 */
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  {
	  LinkedList<Double> smooth = new LinkedList<Double>();
	  if(shows.size()>0) {
		  smooth.add(average(episodeRuntimes(shows.getFirst())));
		  for(int i = 1; i+1 < shows.size(); i++) {
			  smooth.add(
					  (average(episodeRuntimes(shows.get(i-1)))
							  +average(episodeRuntimes(shows.get(i)))
							  +average(episodeRuntimes(shows.get(i+1)))
							  )/3);
		  }
		  if(shows.size()>1) 
			  smooth.add(average(episodeRuntimes(shows.getLast())));
	  }
	  return smooth;
  }
  
  /**
   * Returns the list of episode runtimes of a show
   * @param show a show
   * @return a list of doubles of the runtimes of the show
   */
  public LinkedList<Double> episodeRuntimes(Show show){
	  LinkedList<Double> numbers = new LinkedList<Double>();
	  for(Episode episode: show.episodes) {
		  numbers.add(episode.runTime);
	  }
	  return numbers;
	  
  }
  /**
   * Averages a list of doubles
   * @param numbers a list of doubles
   * @return the average of the list
   */
  public double average(LinkedList<Double> numbers) {
	  if(numbers.size()==0) return 0;
	  int sum = 0;
	  for(double num:numbers) {
		  sum+=num;
	  }
	  return sum / numbers.size();
  }
}