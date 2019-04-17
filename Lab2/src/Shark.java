
public class Shark extends Fish {
	int attacks;

	public Shark(int length, int attacks) {
		super(length, 3.75);
		this.attacks = attacks;
	}

	public boolean isNormalSize() {
		return 6 <= this.length;
	}
	
	@Override
	public boolean isDangerToPeople() {
		return attacks>0;
	}
}