import java.util.LinkedList;
/**
 * A class that manages different shows. 
 * It can organize a list of shows into their distinct categories
 * @author Gus Teran
 *
 */
class ShowManager1 {
	
	ShowManager1() {}

	/**
	 * Organizes the shows by creating a ShowSummary comprised of 
	 * each timeslot using the timeSlot helper method
	 * @param shows a list of shows
	 * @return a ShowSummary containing lists of the daytime, primetime, and latenight shows
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		return new ShowSummary(timeSlot(600, 1700, shows), 
				timeSlot(1700, 2200, shows), 
				timeSlot(2200, 100, shows));
	}
	
	/**
	 * Parses through the shows and returns a new list of all the shows whose broadcast time is at 
	 * or after begin and before end
	 * @param begin The earliest time a show can start to fit in the timeslot (inclusive)
	 * @param end The latest time a show can start to fit in the timeslot (exclusive)
	 * @param shows a list of shows
	 * @return a list of shows that broadcast within the given timeslot
	 */
	public LinkedList<Show> timeSlot(int begin, int end, LinkedList<Show> shows){
		LinkedList<Show> showsAtTime = new LinkedList<Show>();
		for(Show show: shows) {
			if(show.episodes.size()>1 &
					((begin < end & show.broadcastTime >= begin & show.broadcastTime < end)
					| (begin > end & (show.broadcastTime >= begin | show.broadcastTime < end))))
				showsAtTime.add(show);
		}
		return showsAtTime;
	}
	
}
