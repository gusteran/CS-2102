import java.util.LinkedList;

/**
 * An abstract class that defines a round of matches
 * 
 * @author Gus Teran
 *
 */
public abstract class AbsRound implements IWinner{

	LinkedList<Match> matches;
	
	public AbsRound() {
		matches = new LinkedList<Match>();
	}
	
	public AbsRound(LinkedList<Match> matches) {
		this.matches = matches;
	}
		
	/**
	 * Goes through all of the matches and creates a linked list of the winners of all of the matches
	 * @return a linked list of the winners of the matches
	 */
	public LinkedList<IContestant> getMatchWinners() {
		LinkedList<IContestant> winners = new LinkedList<IContestant>();
		for(Match match: matches) {
			if(!winners.contains(match.winner())) winners.add(match.winner());
		}
		return winners;
	}
	
	/**
	 * Finds the number of winners of a round based on getMatchWinners()
	 * @return the number of winners
	 */
	public int getNumWinners() {
		return getMatchWinners().size();
	}
}
