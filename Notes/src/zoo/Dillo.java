package zoo;

public class Dillo extends AbsAnimal implements IAnimal {

	boolean isDead;
	
	public Dillo(int length, boolean isDead) {
		super(length);
		this.isDead = isDead;
	}
	
	public boolean canShelter(Dillo aDillo) {
		if(aDillo.length > 60 && aDillo.isDead == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean lengthBelow(int size) {
		return this.length < size;
	}
	
	public int superReturn4() {
		return getNumberFour();
	}
}
