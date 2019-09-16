import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.UNKNOWN;

/**
 * A class to test the election data class
 * @author Gus Teran
 *
 */
public class Examples {

	ElectionData cartoonElection = new ElectionData();
	ElectionData tie = new ElectionData();
	CandidateExistsException e1;
	DuplicateVotesException e2;
	UnknownCandidateException e3;

	@Before
	public void setup() {
		try {
			cartoonElection.addCandidate("spongebob");
			cartoonElection.addCandidate("gary");
			cartoonElection.addCandidate("patrick");
			cartoonElection.addCandidate("squidward");
			tie.addCandidate("bob");
			tie.addCandidate("joe");
			tie.addCandidate("steve");
		} catch (CandidateExistsException e) {
			System.out.println(e.getName() + " is a duplicate");
		}

		try {
			cartoonElection.processVote("spongebob", "gary", "patrick");
			cartoonElection.processVote("spongebob", "gary", "patrick");
			cartoonElection.processVote("spongebob", "gary", "patrick");
			cartoonElection.processVote("squidward", "gary", "patrick");
			cartoonElection.processVote("squidward", "gary", "patrick");
			tie.processVote("bob", "joe", "steve");
			tie.processVote("joe", "bob", "steve");
		} catch (UnknownCandidateException | DuplicateVotesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void exceptions() {
		String name = "test";
		e1 = new CandidateExistsException(name);
		e2 = new DuplicateVotesException(name);
		e3 = new UnknownCandidateException(name);
		assertEquals(e1.getName(), name);
		assertEquals(e2.getName(), name);
		assertEquals(e3.getName(), name);
	}

	@Test
	public void spongebob() {
		assertEquals(cartoonElection.findWinnerMostFirstVotes(), "spongebob");
	}

	@Test
	public void gary() {
		assertEquals(cartoonElection.findWinnerMostPoints(), "gary");
	}
	
	@Test(expected=CandidateExistsException.class)
	public void exoistsException() throws CandidateExistsException
	{
		cartoonElection.addCandidate("gary");
	}
	
	@Test(expected=UnknownCandidateException.class)
	public void unkonwnException() throws UnknownCandidateException, DuplicateVotesException
	{
		cartoonElection.processVote("bob", "gary", "squidward");
	}
	
	@Test(expected=UnknownCandidateException.class)
	public void unkonwnException2() throws UnknownCandidateException, DuplicateVotesException
	{
		cartoonElection.processVote("spongebob", "gary", "bob");
	}
	
	@Test(expected=UnknownCandidateException.class)
	public void unkonwnException3() throws UnknownCandidateException, DuplicateVotesException
	{
		cartoonElection.processVote("gary", "bob", "squidward");
	}
	
	@Test(expected=DuplicateVotesException.class)
	public void duplicateException() throws UnknownCandidateException, DuplicateVotesException
	{
		cartoonElection.processVote("gary", "gary", "spongebob");
	}
	
	@Test(expected=DuplicateVotesException.class)
	public void duplicateException2() throws UnknownCandidateException, DuplicateVotesException
	{
		cartoonElection.processVote("gary", "patrick", "gary");
	}
	
	@Test(expected=DuplicateVotesException.class)
	public void duplicateException3() throws UnknownCandidateException, DuplicateVotesException
	{
		cartoonElection.processVote("squidward", "gary", "gary");
	}
	
	@Test
	public void runoff() {
		assertEquals(tie.findWinnerMostFirstVotes(), "Runoff required");
	}
	
	@Test
	public void equalPoints() {
		assertEquals(tie.findWinnerMostPoints(), "joe");
	}

	// method to set up a ballot and cast votes

	ElectionData Setup1() {

		ElectionData ED = new ElectionData();

		try {
			// put candidates on the ballot

			ED.addCandidate("gompei");
			ED.addCandidate("husky");
			ED.addCandidate("ziggy");

			// cast votes

			ED.processVote("gompei", "husky", "ziggy");
			ED.processVote("gompei", "ziggy", "husky");
			ED.processVote("husky", "gompei", "ziggy");

		} catch (Exception e) {
		}

		return (ED);

	}

	// now run a test on a specific election
	@Test
	public void testMostFirstWinner() {
		assertEquals("gompei", Setup1().findWinnerMostFirstVotes());
	}
	

}
