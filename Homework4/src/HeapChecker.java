import java.util.LinkedList;

/**
 * A class that tests the addElt() and remElt() methods on a heap
 * 
 * @author Gus Teran
 *
 */
public class HeapChecker {

	/**
	 * A method built to test the add element method. To return true: the binary
	 * tree must be a heap and the binary tree must contain all the elements from
	 * the original heap and the new element
	 * 
	 * @param hOrig
	 *            the original heap
	 * @param elt
	 *            the element to be added
	 * @param hAdded
	 *            the binary tree that has had the element added to the original
	 *            heap
	 * @return a boolean of whether hAdded is a successful implementation of adding
	 *         an element to the original
	 */
	public boolean addEltTester(IHeap hOrig, int elt, IBinTree hAdded) {
		return isHeap(hAdded) & hOrig.size() + 1 == hAdded.size() & containsAll(hOrig, hAdded, elt);
	}

	/**
	 * A method built to test the remove element method. To return true: the binary
	 * tree must be a heap and contain all the original elements except the head
	 * that should be removed
	 * 
	 * @param hOrig
	 *            the original heap
	 * @param elt
	 *            the element to be added
	 * @param hAdded
	 *            the binary tree that has had the element added to the original
	 *            heap
	 * @return a boolean of whether hAdded is a successful implementation of removing
	 *         an element from the original
	 */
	public boolean remMinEltTester(IHeap hOrig, IBinTree hRemoved) {
		return isHeap(hRemoved) & hOrig.size() - 1 == hRemoved.size()
				| hOrig.size() < 1 & containsAll(hOrig, hRemoved.getLeft()) & containsAll(hOrig, hRemoved.getRight());
	}

	/**
	 * Checks to see if a Binary Tree is a Heap
	 * 
	 * @param binTree
	 *            the binary tree that could be a heap
	 * @return whether a boolean of if it is a heap
	 */
	public boolean isHeap(IBinTree binTree) {
		if (binTree.size() > 1) {
			boolean left = binTree.getLeft().size() > 0
					? binTree.getElt() <= binTree.getLeft().getElt() & isHeap(binTree.getLeft())
					: true;
			boolean right = binTree.getRight().size() > 0
					? binTree.getElt() <= binTree.getRight().getElt() & isHeap(binTree.getRight())
					: true;
			return left & right;
		}
		return true;
	}

	/**
	 * Determines if a new binary tree contains all of the elements of the original
	 * tree
	 * 
	 * @param original
	 *            the original binary tree
	 * @param newTree
	 *            the new binary tree
	 * @return a boolean of whether the new tree contains all the elements of the
	 *         original tree
	 */
	public boolean containsAll(IBinTree original, IBinTree newTree) {
		if (original.size() > 0) {
			return newTree.hasElt(original.getElt()) & containsAll(original.getLeft(), newTree)
					& containsAll(original.getRight(), newTree);
		}
		return true;
	}

	/**
	 * Determines if a new binary tree contains all of the elements of the original
	 * tree and the given element
	 * 
	 * @param original
	 *            the original binary tree
	 * @param newTree
	 *            the new binary tree
	 * @param elt
	 *            the new element to be contained by the new tree
	 * @return a boolean of whether the new tree contains all the elements of the
	 *         original tree and the given element
	 */
	public boolean containsAll(IBinTree original, IBinTree newTree, int elt) {
		return newTree.getElt() == elt | containsAll(original, newTree);
	}


}