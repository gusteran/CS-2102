import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Examples {

	EventGuests bst = new EventGuests(new DataBST("Boris"));
	EventGuests avl = new EventGuests(new DataAVL("Natasha"));
	EventGuests linkedList = new EventGuests(new MyLinkedList().addElt("Ivan"));
	
	@Before
	public void setup() {
		bst.addGuest("Rocky");
		avl.addGuest("Rocky");
		linkedList.addGuest("Rocky");
	}
	
	@Test
	public void isComingRocky() {
		assertTrue(bst.isComing("Rocky"));
		assertTrue(avl.isComing("Rocky"));
		assertTrue(linkedList.isComing("Rocky"));
	}
	
	@Test
	public void isComingBoris() {
		assertTrue(bst.isComing("Boris"));
		assertFalse(avl.isComing("Boris"));
		assertFalse(linkedList.isComing("Boris"));
	}
	
	@Test
	public void numGuests() {
		avl.addGuest("Other1");avl.addGuest("Other2");avl.addGuest("Other3");avl.addGuest("Other4");avl.addGuest("Other5");
		assertEquals(bst.numGuests(), 2);
		assertEquals(avl.numGuests(), 7);
		assertEquals(linkedList.numGuests(), 2);
	}

}
