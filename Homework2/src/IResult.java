
public interface IResult {

	/**
	 * Returns whether the result is expected
	 */
	public boolean isValid();
	
	/**
	 * Returns the team that won the contest
	 * based on the stored scores
	 */
	public IContestant getWinner();
	
}
