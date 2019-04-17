import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {

	
	@Test
    public void smallFish() {
    	assertFalse(new Fish(0,3).isNormalSize());
    }
	
	@Test
    public void normalFish() {
    	assertTrue(new Fish(3,3).isNormalSize());
    }
	
	@Test
    public void smallShark() {
    	assertFalse(new Shark(3,3).isNormalSize());
    }
	
	@Test
    public void normalShark() {
    	assertTrue(new Shark(23,3).isNormalSize());
    }
	
	@Test
	public void isSharkDanger() {
		assertTrue(new Shark(0,1).isDangerToPeople());
	}
	
	@Test
	public void isGoodSharkDanger() {
		assertFalse(new Shark(0,0).isDangerToPeople());
	}
	
	@Test
	public void isFishDanger() {
		assertFalse(new Fish(0,1).isDangerToPeople());
	}
	
	@Test
	public void isBoaDanger() {
		assertTrue(new Boa("bad", 100, "people").isDangerToPeople());
	}
	
	@Test
	public void isGoodBoaDanger() {
		assertFalse(new Boa("bad", 100, "not people").isDangerToPeople());
	}

}
