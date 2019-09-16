/**
 * An exception if duplicate candidates are entered
 * @author Gus Teran
 *
 */
public class DuplicateVotesException extends Exception {


	private String name;

	public DuplicateVotesException(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
