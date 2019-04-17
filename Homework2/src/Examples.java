import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;


/**
 * A class for testing the classes Tournament, AbsRound, InitRound, AdvancedRound, and IWinner
 * for Homework 2
 * 
 * @author Gus Teran
 *
 */
public class Examples {

	static RugbyTeam rug1 = new RugbyTeam("New Zealand", "black", true, 0, 2);
	static RugbyTeam rug2 = new RugbyTeam("USA", "black", false, 3, 5);
	static RugbyTeam rug3 = new RugbyTeam("Britain", "black", false, 5, 5);
	RugbyResult rugR1 = new RugbyResult(rug1, rug2, 100, 50);
	RugbyResult rugR2 = new RugbyResult(rug2, rug3, 40, 60);
	RugbyResult rugR3 = new RugbyResult(rug1, rug3, 120, 0);
	Match rugM1 = new Match(rug1, rug2, rugR1);
	Match rugM2 = new Match(rug2, rug3, rugR2);
	Match rugM3 = new Match(rug1, rug3, rugR3);
	
    LinkedList<String> linkedlist = new LinkedList<String>();
	
	LinkedList<Match> rugbyMatchesEmpty = new LinkedList<Match>();
	LinkedList<Match> rugMList1 = new LinkedList<Match>();
	InitRound rugRound1 = new InitRound(rugbyMatchesEmpty);
	InitRound rugRound2 = new InitRound(rugMList1);
	
	LinkedList<IContestant> winTeams = new LinkedList<IContestant>();
	AdvancedRound rugAdv0 = new AdvancedRound(rugbyMatchesEmpty, winTeams);
	AdvancedRound rugAdv1 = new AdvancedRound(rugMList1, winTeams);
	
	LinkedList<AbsRound> rounds = new LinkedList<AbsRound>();
	Tournament tourney = new Tournament(rounds);
	
	
	@Before
	public void setup() {
		rugMList1.add(rugM1);rugMList1.add(rugM2);rugMList1.add(rugM3);
	}
	
	@Test
	public void linkedList() {
		assertEquals(new LinkedList<String>(), new LinkedList<String>().add("ravioli"));
	}
	
	@Test
	public void advRoundNoWinners() {
		assertEquals(rugAdv0.getMatchWinners(), new LinkedList<IContestant>());
	}
	
	@Test
	public void advRoundEmptyWinners() {
		assertFalse(rugAdv1.isWinner(rug1));
		assertFalse(rugAdv1.isWinner(rug2));
		assertFalse(rugAdv1.isWinner(rug3));
	}
	
	@Test
	public void advRoundWin() {
		LinkedList<IContestant> win = new LinkedList<IContestant>();
		win.add(rug1);win.add(rug3);
		rugAdv1 = new AdvancedRound(rugMList1, winTeams);
		assertEquals(rugAdv1.getMatchWinners(), win);
	}
	
	@Test
	public void length0() {
		assertEquals(rugRound1.getNumWinners(),0);
	}
	
	@Test
	public void length1() {
		assertEquals(rugRound2.getNumWinners(), 2);
	}
	
	@Test
	public void noWinners() {
		assertEquals(rugRound1.getMatchWinners(), new LinkedList<IContestant>());
	}
	
	@Test
	public void winners() {
		LinkedList<IContestant> win = new LinkedList<IContestant>();
		win.add(rug1);win.add(rug3);
		rugRound2 = new InitRound(rugMList1);
		assertEquals(rugRound2.getMatchWinners(), win);
	}
	
	@Test
	public void emptyWinner() {
		assertFalse(rugRound1.isWinner(rug1));
	}
	
	@Test
	public void roundWinner() {
		assertTrue(rugRound2.isWinner(rug1));
	}
	
	@Test
	public void notWinner() {
		assertFalse(rugRound2.isWinner(rug2));
	}
	
	@Test
	public void emptyTourney() {
		assertFalse(tourney.finalWinnerIsValid(rug1));
	}
	
	@Test
	public void smallTourney() {
		rounds.add(rugRound1);rounds.add(rugRound2);
		tourney = new Tournament(rounds);
		assertTrue(tourney.finalWinnerIsValid(rug1));
	}
	
	@Test
	public void smallTourney2() {
		rounds.add(rugRound1);rounds.add(rugRound2);
		tourney = new Tournament(rounds);
		assertFalse(tourney.finalWinnerIsValid(rug2));
	}
	
	@Test
	public void smallTourney3() {
		rounds.add(rugRound1);rounds.add(rugRound2);
		tourney = new Tournament(rounds);
		assertTrue(tourney.finalWinnerIsValid(rug3));
	}
	
	@Test
	public void tourney1() {
		winTeams.add(rug1);
		rounds.add(rugRound1);rounds.add(rugRound2);rounds.add(rugAdv1);
		tourney = new Tournament(rounds);
		assertTrue(tourney.finalWinnerIsValid(rug1));
	}
	
	@Test
	public void tourney2() {
		winTeams.add(rug1);
		rounds.add(rugRound1);rounds.add(rugRound2);rounds.add(rugAdv1);
		tourney = new Tournament(rounds);
		assertFalse(tourney.finalWinnerIsValid(rug2));
	}
	
	@Test
	public void tourney3() {
		winTeams.add(rug1);
		rounds.add(rugRound1);rounds.add(rugRound2);rounds.add(rugAdv1);
		tourney = new Tournament(rounds);
		assertFalse(tourney.finalWinnerIsValid(rug3));
	}
	

}
