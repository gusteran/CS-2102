import java.util.Scanner;

import org.junit.Before;

/**
 * A voting machine that handles the user input/output 
 * @author Gus Teran
 *
 */
public class VotingMachine {
	private Scanner sc;
	private ElectionData election;
	
	public VotingMachine() {
		sc = new Scanner(System.in);
		election = new ElectionData();
	}
	
	public VotingMachine(ElectionData election) {
		sc = new Scanner(System.in);
		this.election = election;
	}
	
	/**
	 * A method that counts the vote of the user by acquiring their votes with the scanner
	 * and plugging them into the process vote method from the election data.
	 * It handles unknown candidate and duplicate candidate exceptions respectively before
	 * restarting the method.
	 */
	public void vote() {
		System.out.println("Please enter the name of your top three candidates by entering their name "
				+ "and then hitting enter");
		try {
			election.processVote(sc.nextLine(), sc.nextLine(), sc.nextLine());
		} catch (UnknownCandidateException unkown) {
			System.out.println("You have entered an unknown candidate. If you would like to "
					+ "add this candidate as a write in please enter yes");
			String next = sc.nextLine();
			if(next.startsWith("y") | next.startsWith("Y"))
				writeIn(unkown.getName());
			vote();
		} catch (DuplicateVotesException duplicate) {
			System.out.println("You cannot vote for the same candidate twice");
			vote();
		}
	}
	
	/**
	 * Adds a write in candidate to the election data
	 * @param candidate
	 */
	public void writeIn(String candidate) {
		try {
			election.addCandidate(candidate);
		} catch (CandidateExistsException e) {
			System.out.println("This candidate already exists");
			return;
		}
		System.out.println("The candidate was added successfully");
	}
	
	/**
	 * Implements the same method from the election data class
	 * @return the winner who has more than half of the first place votes
	 */
	public String findWinnerMostFirstVotes() {
		return election.findWinnerMostFirstVotes();
	}
	
	/**
	 * Implements the same method form the election data class
	 * @return the winner who has the most points
	 */
	public String findWinnerMostPoints() {
		return election.findWinnerMostPoints();
	}
	
	public static void main(String[] a) {
//		VotingMachine vote = new VotingMachine();
//		vote.vote();
//		System.out.println("Most First Votes: "+vote.findWinnerMostFirstVotes());
//		System.out.println("Most Points: "+vote.findWinnerMostPoints());
		
		
		ElectionData election = new ElectionData();

		try {
			election.addCandidate("spongebob");
			election.addCandidate("gary");
			election.addCandidate("patrick");
			election.addCandidate("squidward");
		} catch (CandidateExistsException e) {
			System.out.println(e.getName() + " is a duplicate");
		}

		try {
			election.processVote("spongebob", "gary", "patrick");
			election.processVote("spongebob", "gary", "patrick");
			election.processVote("spongebob", "gary", "patrick");
			election.processVote("squidward", "gary", "patrick");
			election.processVote("squidward", "gary", "patrick");
		} catch (UnknownCandidateException | DuplicateVotesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		VotingMachine cartoon = new VotingMachine(election);
		cartoon.vote();
		System.out.println("Most First Votes: "+cartoon.findWinnerMostFirstVotes());
		System.out.println("Most Points: "+cartoon.findWinnerMostPoints());

	}
}
