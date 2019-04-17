
public class RoboticsTeam implements IContestant{

	String school;
	String specialFeature;
	int rank;
	
	public RoboticsTeam(String school, String specialFeature, int rank) {
		this.school = school;
		this.specialFeature = specialFeature;
		this.rank = rank;
	}
	
	public String toString() {
		return school;
	}

	public boolean expectToBeat(RoboticsTeam opponent) {
		return rank > opponent.rank;
	}
}
