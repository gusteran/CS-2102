import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * A class that processes data for an election by storing the candidate
 * and their votes (of three rankings) in a hashtable
 * @author Gus Teran
 *
 */
public class ElectionData {
	//a hash table that stores the candidates name as the key
	// and the number of votes for them of each rank {1, 2, 3} as an array of integers
	private Hashtable<String,int[]> totalVotes = new Hashtable<String, int[]>();

	ElectionData() {}

	
	/**
	 * Processes the votes of three candidates by incrementing their vote
	 * count for the rank they got
	 * @param cand1 the first candidate voted for
	 * @param cand2 the second candidate voted for
	 * @param cand3 the third candidate voted for
	 * @throws UnknownCandidateException an unknown candidate is entered
	 * @throws DuplicateVotesException duplicate candidates are entered
	 */
	public void processVote(String cand1, String cand2, String cand3) 
	throws UnknownCandidateException, DuplicateVotesException {
		if(!totalVotes.containsKey(cand1))
			throw new UnknownCandidateException(cand1);
		else if(!totalVotes.containsKey(cand2))
			throw new UnknownCandidateException(cand2);
		else if(!totalVotes.containsKey(cand3))
			throw new UnknownCandidateException(cand3);
		else if (cand1.equals(cand2) | cand1.equals(cand3))
			throw new DuplicateVotesException(cand1);
		else if (cand2.equals(cand3))
			throw new DuplicateVotesException(cand2);
		else {
			totalVotes.get(cand1)[0]++;
			totalVotes.get(cand2)[1]++;
			totalVotes.get(cand3)[2]++;
		}
	}

	/**
	 * Adds a candidate to the voting process
	 * @param string the candidates name
	 * @throws CandidateExistsException the given candidate already exists
	 */
	public void addCandidate(String candidate) throws CandidateExistsException {
		if(!totalVotes.containsKey(candidate)) totalVotes.put(candidate, new int[3]);
		else throw new CandidateExistsException(candidate);
	}
	
	/**
	 * Finds the winner by choosing the candidate with more than
	 * 50% of the first place votes. If not candidate meets such requirement
	 * it returns "Runoff required"
	 * @return the name of the candidate that won or "Runoff required"
	 */
	public String findWinnerMostFirstVotes() {
		int sumAllVotes = 0;
		for(int[] array: totalVotes.values()) {
			sumAllVotes += array[0];
		}
		for(String candidate: totalVotes.keySet()) {
			if(totalVotes.get(candidate)[0] * 2 > sumAllVotes)
				return candidate;
		}
		return "Runoff required";
	}

	/**
	 * Finds the winner by choosing the candidate with the most total points
	 * ranked as a first place vote is 3 points, second place vote is 2 points, 
	 * and third place vote is one point
	 * @return the candidate with the most points
	 */
	public String findWinnerMostPoints() {
		Hashtable<String, Integer> points = new Hashtable<String, Integer>();
		totalVotes.forEach((candidate, voting) -> points.put(candidate, voting[0]*2+voting[1]*2+voting[2]));
		int max = 0;
		for(int point: points.values()) {
			if(point>max) max = point;
		}
		for(String candidate: points.keySet()) {
			if(points.get(candidate) == max)
				return candidate;
		}
		return "no winner";
	}
}
