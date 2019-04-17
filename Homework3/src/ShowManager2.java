import java.util.LinkedList;
/**
 * A class that manages different shows. 
 * It can organize a list of shows into their distinct categories
 * @author Gus Teran
 *
 */
class ShowManager2 {
	
	ShowManager2() {}
	
	/**
	 * Parses through the list of shows and adds them to their relevant list of shows
	 * based on their timeslot. Returns a ShowSummary comprised of these lists
	 * @param shows a list of shows
	 * @return a ShowSummary made up of the lists of daytime, primetime, and latenight shows
	 */
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		LinkedList<Show> daytime = new LinkedList<Show>();
		LinkedList<Show> primetime = new LinkedList<Show>();
		LinkedList<Show> latenight = new LinkedList<Show>();
		
		for(Show show: shows) {
			if(show.episodes.size()<2 | show.broadcastTime < 600 & show.broadcastTime>=100);
			else if(show.broadcastTime<1700) daytime.add(show);
			else if (show.broadcastTime < 2200) primetime.add(show);
			else if(show.broadcastTime >= 2200 | show.broadcastTime< 100)latenight.add(show);
			
		}
		
		return new ShowSummary(daytime, primetime, latenight);
	}
	
}
