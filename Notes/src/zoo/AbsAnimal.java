package zoo;

public abstract class AbsAnimal extends AbsLifeForm implements IAnimal{
	
	int length;
	
	public AbsAnimal(int length) {
		this.length = length;
	}
	
	public boolean isShorterThan(int size) {
		return this.length < size;	
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}	
}
