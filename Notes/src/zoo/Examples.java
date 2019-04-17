package zoo;
import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

	Dillo babyDillo = new Dillo(8, false);
	Dillo adultDillo = new Dillo(24, false);
	Dillo hugeDeadDillo = new Dillo(65, true);
	Dillo edgeCaseDillo = new Dillo(60, true);
	Dillo anotherEdgeCaseDillo = new Dillo(61, true);
	
	Boa myBoa = new Boa("Fred", 5, "");
	Boa anotherBoa = new Boa("Wilma", 6, "rabbits");
	Boa aThirdBoa = new Boa("Barney", 6, "");
	
	@Test
	public void testLikesSameFoodIsTrue() {
		assertTrue(myBoa.likesSameFood(aThirdBoa));
	}
	
	@Test
	public void testLikesSameFoodIsFalse() {
		assertFalse(myBoa.likesSameFood(anotherBoa));
	}
	
	
	@Test
	public void testBabyDilloCanShelter() {
		assertFalse(babyDillo.canShelter(babyDillo));
	}

	@Test
	public void testAdultDilloCanShelter() {
		assertFalse(babyDillo.canShelter(adultDillo));
	}
	
	@Test
	public void testHugeDeadDilloCanShelter() {
		assertTrue(babyDillo.canShelter(hugeDeadDillo));
	}
	
	@Test
	public void testEdgeCaseDilloCanShelter() {
		assertFalse(babyDillo.canShelter(edgeCaseDillo));
	}
	
	@Test
	public void testAnotherEdgeCaseDilloCanShelter() {
		assertTrue(babyDillo.canShelter(anotherEdgeCaseDillo));
	}
	
	@Test
	public void testTwoNumbers() {
		assertEquals(4, 4);
	}
	
	//Both boa and dillo
	//test length is below size
	//test length is equal to size
	//test length is above size
	
	Cage aCage = new Cage(10, myBoa);
	
	@Test
	public void testCageAnimalWillFit() {
		assertTrue(aCage.checkResidentFits());
	}
}
