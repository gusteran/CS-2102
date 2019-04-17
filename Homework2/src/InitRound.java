import java.util.LinkedList;

/**
 * An initial round of matches
 * 
 * @author Gus Teran
 *
 */
public class InitRound extends AbsRound {

	public InitRound() {
		super();
	}
	
	public InitRound(LinkedList<Match> matches) {
		super(matches);
	}

	/**
	 * Determines whether a contestant is a winner in one of the matches.
	 * Implemented from the interface IWinner
	 * @param team the given contestant
	 * @return a boolean of whether the team won a match
	 */
	public boolean isWinner(IContestant team) {
		return getMatchWinners().contains(team);
	}
}
