package zoo;

public class Main {

	public static void main(String[] args) {
		Dillo babyDillo = new Dillo(8, false);
		Dillo adultDillo = new Dillo(24, false);
//		Dillo hugeDeadDillo = new Dillo(65, true);
		
		new Dillo(5, false);
//		Dillo deadDillo = new Dillo(3, true);
//		Dillo anotherDeadDillo = new Dillo(3, true);
		//Dillo anotherDeadDillo = deadDillo;
		//if(deadDillo.isDead == anotherDeadDillo.isDead)

		boolean returnVal = babyDillo.canShelter(adultDillo);
		System.out.println(returnVal);
		
		Boa myBoa = new Boa("Fred", 5, "mice");
		AbsAnimal anotherBoa = new Boa("Wilma", 6, "rabbits");
		
//		myBoa.likesSameFood(anotherBoa);
		anotherBoa.isShorterThan(myBoa.length);
		
		IAnimal aThirdBoa = new Boa("Barney", 7, "mice");
		aThirdBoa.lengthBelow(5);
		
	}

}
