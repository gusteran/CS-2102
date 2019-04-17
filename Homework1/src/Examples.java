/*
 * Homework 1
 * CS 2102
 * Gus Teran
 */

import static org.junit.Assert.*;

import org.junit.Test;

class Examples {

	static RoboticsTeam rbe1 = new RoboticsTeam("AB", "everything", 1);
	static RoboticsTeam rbe2 = new RoboticsTeam("CC", "nothing", 2);
	RoboticsResult rbeR1 = new RoboticsResult(rbe1, rbe2, 10, 4, false, 8, 3, true);
	RoboticsResult rbeR2 = new RoboticsResult(rbe1, rbe2, 10, 0, false, 8, 3, false);
	Match rbeM1 = new Match(rbe1, rbe2, rbeR1);
	Match rbeM2 = new Match(rbe1, rbe2, rbeR2);

	static RugbyTeam rug1 = new RugbyTeam("New Zealand", "black", true, 0, 2);
	static RugbyTeam rug2 = new RugbyTeam("USA", "black", false, 3, 5);
	static RugbyTeam rug3 = new RugbyTeam("Britain", "black", false, 5, 5);
	RugbyResult rugR1 = new RugbyResult(rug1, rug2, 100, 50);
	RugbyResult rugR2 = new RugbyResult(rug2, rug3, 40, 60);
	RugbyResult rugR3 = new RugbyResult(rug1, rug3, 170, 0);
	Match rugM1 = new Match(rug1, rug2, rugR1);
	Match rugM2 = new Match(rug2, rug3, rugR2);

	// rbe valid
	@Test
	void rbeInvalidPoints() {
		assertFalse(new RoboticsResult(rbe1, rbe2, 17, 2, false, 0, 0, false).isValid());
	}

	@Test
	void rbeInvalidTasks() {
		assertFalse(new RoboticsResult(rbe1, rbe2, 4, 8, false, 0, 0, false).isValid());
	}

	@Test
	void rbeValid() {
		assertTrue(rbeR1.isValid());
	}

	// rugby valid
	@Test
	void rugEdgeInvalid() {
		assertFalse(new RugbyResult(rug1, rug2, 150, 0).isValid());
	}

	@Test
	void rugInvalid() {
		assertFalse(rugR3.isValid());
	}

	@Test
	void rugValid() {
		assertTrue(rugR2.isValid());
	}

	// rbe getScore
	@Test
	void rbe1Score() {
		assertEquals(rbeR1.getScore(rbeR1.team1points, rbeR1.team1tasks, rbeR1.team1fell), 14, 0.1);
	}

	@Test
	void rbe2Score() {
		assertEquals(rbeR1.getScore(rbeR1.team2points, rbeR1.team2tasks, rbeR1.team2fell), 6, 0.1);
	}

	// rbe getWinner
	@Test
	void rbeResult() {
		assertEquals(rbeR1.getWinner(), rbe1);
	}

	@Test
	void rbeResult2() {
		assertEquals(rbeR2.getWinner(), rbe2);
	}

	// rugby getWinner
	@Test
	void rug1Result() {
		assertEquals(rugR1.getWinner(), rug1);
	}

	@Test
	void rug2Result() {
		assertEquals(rugR2.getWinner(), rug3);
	}

	// rugby match winner
	@Test
	void rugbyComp1() {
		assertEquals(rugM1.winner(), rug1);
	}

	@Test
	void rugbyComp2() {
		assertEquals(rugM2.winner(), rug3);
	}

	// rbe match winner
	@Test
	void robotComp() {
		assertEquals(rbeM1.winner(), rbe1);
	}

	@Test
	void robotComp2() {
		assertEquals(rbeM2.winner(), rbe2);
	}

	// rugby expect to beat
	@Test
	void rugExpectBeat1() {
		assertTrue(rug1.expectToBeat(rug2));
	}

	@Test
	void rugExpectBeat2() {
		assertFalse(rug2.expectToBeat(rug3));
	}

	@Test
	void rugExpectBeat3() {
		assertFalse(rug3.expectToBeat(rug1));
	}

	// rbe expect to beat
	@Test
	void rbe1ExpectBeat() {
		assertFalse(rbe1.expectToBeat(rbe2));
	}

	@Test
	void rbe2ExpectBeat() {
		assertTrue(rbe2.expectToBeat(rbe1));
	}
}
