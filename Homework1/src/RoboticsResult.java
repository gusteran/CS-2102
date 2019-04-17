
public class RoboticsResult implements IResult{
	RoboticsTeam team1;
	RoboticsTeam team2;
	double team1points;
	int team1tasks;
	boolean team1fell;
	double team2points;
	int team2tasks;
	boolean team2fell;

	public RoboticsResult(RoboticsTeam team1, RoboticsTeam team2, double team1points, int team1tasks, boolean team1fell,
			double team2points, int team2tasks, boolean team2fell) {
		this.team1 = team1;
		this.team2 = team2;
		this.team1points = team1points;
		this.team1fell = team1fell;
		this.team1tasks = team1tasks;
		this.team2points = team2points;
		this.team2fell = team2fell;
		this.team2tasks = team2tasks;
	}

	@Override
	public boolean isValid() {
		return team1points <= 16 & team2points <= 16 &
				team1tasks < 8 & team2tasks < 8;
	}
	
	/**
	 * Calculates the score for each team based on their points, tasks completed, 
	 * and with a penalty if they fell
	 */
	public double getScore(double points, int tasks, boolean fell) {
		return points + tasks - (fell ? 5:0);
	}

	@Override
	public IContestant getWinner() {
		double team1score = this.getScore(team1points, team1tasks, team1fell);
		double team2score = this.getScore(team2points, team2tasks, team2fell);
		
		if(team1score > team2score) return team1;
		else if (team2score > team1score) return team2;
		else return null;
	}
	
	
}
