import java.util.LinkedList;

/**
 * A tournament comprised of rounds, either initial or advanced. 
 * This class can determine if a team is a winner of the tournament
 * 
 * @author Gus Teran
 *
 */
public class Tournament {

	LinkedList<AbsRound> rounds;
	
	public Tournament() {
		rounds = new LinkedList<AbsRound>();
	}
	
	public Tournament(LinkedList<AbsRound> rounds) {
		this.rounds = rounds;
	}
	
	/**
	 * Determines whether a given contestant is a winner of the tournament
	 * @param team the given contestant
	 * @return a boolean of whether the team is a winner
	 */
	public boolean finalWinnerIsValid(IContestant team) {
		if(rounds.size()<1) return false;
		int wins = 0;
		int roundNum = 0;
		for(IWinner round : rounds) {
			if(round.isWinner(team))
				wins++;
			roundNum++;
		}
		return wins*2 >= roundNum;
	}
	
}
