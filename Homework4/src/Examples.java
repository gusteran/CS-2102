import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A test class for HeapChecker
 * 
 * @author Gus Teran
 *
 */
public class Examples {

	HeapChecker check = new HeapChecker();
	IHeap empty = new MtHeap();
	IHeap heap1 = new DataHeap(5);
	IHeap badHeap1 = new DataHeap(7, heap1, new DataHeap(3, new DataHeap(1), new DataHeap(2)));
	IHeap heap2 = new DataHeap(4, heap1, new DataHeap(9, new DataHeap(10), new DataHeap(11)));

	@Test
	public void emptyAddCheck() {
		assertTrue(check.addEltTester(empty, 10, empty.addElt(10)));
	}

	@Test
	public void addCheckRemoved() {
		assertFalse(check.addEltTester(heap2, 2, heap2.remMinElt()));
	}

	@Test
	public void addCheckWorks() {
		assertTrue(check.addEltTester(heap2, 2, heap2.addElt(2)));
	}

	@Test
	public void addCheckBadHeap() {
		assertFalse(check.addEltTester(badHeap1, 5, badHeap1.addElt(5)));
	}
	
	@Test
	public void addCheckTooManyTimes() {
		assertFalse(check.addEltTester(heap2, 3, heap2.addElt(3).addElt(3)));
	}
	
	@Test
	public void addCheckChangedHeap() {
		assertFalse(check.addEltTester(heap2, 20, heap2.addElt(heap2.getElt()).addElt(20)));
	}
	
	@Test
	public void addCheckWrongNumberElt() {
		assertFalse(check.addEltTester(heap2, 10, heap2.remMinElt().addElt(10)));
	}

	@Test
	public void emptyRemoveCheck() {
		assertTrue(check.remMinEltTester(empty, empty));
	}

	@Test
	public void removeCheckDifferentHeap() {
		assertFalse(check.remMinEltTester(heap2, heap1));
	}

	@Test
	public void removeCheckWorks() {
		assertTrue(check.remMinEltTester(heap2, heap2.remMinElt()));
	}
	
	@Test
	public void removeCheckWorks2() {
		assertTrue(check.remMinEltTester(heap1, heap1.remMinElt()));
	}
	
	@Test
	public void removeCheckBadHeap() {
		assertFalse(check.remMinEltTester(badHeap1, badHeap1.remMinElt()));
	}
	
	@Test 
	public void removeCheckNeverRemoved() {
		assertFalse(check.remMinEltTester(heap2, heap2));
	}
	
	@Test
	public void removedCheckRemovedTwice() {
		assertFalse(check.remMinEltTester(heap2, heap2.remMinElt().remMinElt()));
	}
	
	@Test
	public void removeCheckChangedHeap() {
		assertFalse(check.remMinEltTester(heap2.addElt(20), heap2.addElt(20).addElt(20).remMinElt()));
	}
	
	@Test
	public void removeCheckChangedSize() {
		assertFalse(check.remMinEltTester(heap2, heap2.addElt(heap2.getLeft().getElt()).remMinElt()));
	}

	// isHeap() helper tester
	@Test
	public void heapHelper1() {
		assertTrue(check.isHeap(heap1));
	}

	@Test
	public void heapHelper2() {
		assertFalse(check.isHeap(badHeap1));
	}

	@Test
	public void heapHelper3() {
		assertTrue(check.isHeap(heap2));
	}

	@Test
	public void heapHelper4() {
		assertTrue(check.isHeap(heap2.addElt(2)));
	}

	@Test
	public void heapHelper5() {
		assertTrue(check.isHeap(heap2.addElt(200)));
	}

	@Test
	public void heapHelper6() {
		assertTrue(check.isHeap(empty.addElt(10)));
	}

	@Test

	public void heapHelper7() {
		assertTrue(check.isHeap(heap2.remMinElt()));
	}

}