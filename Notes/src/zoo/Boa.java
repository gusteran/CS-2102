package zoo;

public class Boa extends AbsAnimal implements IAnimal, IStatus {

	String name;
	String eats;
	
	public Boa(String name, int length, String eats) {
		super(length);
		this.name = name;
		this.eats = eats;
	}
	
	public boolean likesSameFood(Boa otherBoa) {
		return this.eats.equals(otherBoa.eats);
	}
	
	public boolean isShorterLength(Boa otherBoa) {
		return this.length < otherBoa.length;
	}
	
	public boolean lengthBelow(int size) {
		return this.length / 2 < size;
	}

	@Override
	public boolean isItWorthStealing() {
		return false;
	}
}
