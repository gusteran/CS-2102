
public class RugbyTeam implements IContestant {

	String country;
	String jerseyColor;
	boolean ritual;
	int wins;
	int losses;

	public RugbyTeam(String country, String jerseyColor, boolean ritual, int wins, int losses) {
		this.country = country;
		this.jerseyColor = jerseyColor;
		this.ritual = ritual;
		this.wins = wins;
		this.losses = losses;
	}
	
	public String toString() {
		return country;
	}
	
	public boolean expectToBeat(RugbyTeam opponent) {
		if(ritual & !opponent.ritual) return true;
		else if (!ritual & opponent.ritual) return false;
		else return (wins - losses) > (opponent.wins - opponent.losses);
	}
}
