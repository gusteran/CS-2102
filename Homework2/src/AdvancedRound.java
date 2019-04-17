import java.util.LinkedList;

/**
 * An advanced round of matches that also contains a list of the previous winners
 * 
 * @author Gus Teran
 *
 */
public class AdvancedRound extends AbsRound {

	LinkedList<IContestant> winners;
	
	public AdvancedRound() {
		super();
		winners = new LinkedList<IContestant>();
	}
	
	public AdvancedRound(LinkedList<Match> matches, LinkedList<IContestant> winners) {
		super(matches);
		this.winners = winners;
	}
	
	/**
	 * Determines whether a contestant is a winner from the list of previous winners.
	 * Implemented from the interface IWinner
	 * @param team the given contestant
	 * @return a boolean of whether the team is in the list of winners
	 */
	public boolean isWinner(IContestant team) {
		return winners.contains(team);
	}
	
}
