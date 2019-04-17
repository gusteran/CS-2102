
/**
 * An interface to find if there is a winner
 * 
 * @author Gus Teran
 *
 */
public interface IWinner{

	/**
	 * Determines whether a contestant is a winner
	 * @param team the given contestant
	 * @return a boolean of whether the team is a winner
	 */
	public boolean isWinner(IContestant team);
	
}
