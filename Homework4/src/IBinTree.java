import java.lang.Math;

interface IBinTree {
	// determines whether element is in the tree
	boolean hasElt(int e);

	// returns number of nodes in the tree; counts duplicate elements as separate
	// items
	int size();

	// returns depth of longest branch in the tree
	int height();
	
	/**
	 * Gets the element
	 * @return the element
	 */
	int getElt();
	
	/**
	 * Gets the left child node
	 * @return the left child binary tree
	 */
	IBinTree getLeft();
	
	/**
	 * Gets the left child node
	 * @return the right child binary tree
	 */
	IBinTree getRight();
//	boolean compareNode(IBinTree node);
}

class MtBT implements IBinTree {
	MtBT() {
	}

	// returns false since empty tree has no elements
	public boolean hasElt(int e) {
		return false;
	}

	// returns 0 since enpty tree has no elements
	public int size() {
		return 0;
	}

	// returns 0 since empty tree has no branches
	public int height() {
		return 0;
	}

	@Override
	public int getElt() {
		return 0;
	}

	@Override
	public IBinTree getLeft() {
		// TODO Auto-generated method stub
		return new MtBT();
	}

	@Override
	public IBinTree getRight() {
		// TODO Auto-generated method stub
		return new MtBT();
	}

//	@Override
//	public boolean compareNode(IBinTree node) {
//		// TODO Auto-generated method stub
//		return false;
//	}
}

class DataBT implements IBinTree {
	int data;
	IBinTree left;
	IBinTree right;

	DataBT(int data, IBinTree left, IBinTree right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// an alternate constructor for when both subtrees are empty
	DataBT(int data) {
		this.data = data;
		this.left = new MtBT();
		this.right = new MtBT();
	}

	// determines whether this node or node in subtree has given element
	public boolean hasElt(int e) {
		return this.data == e || this.left.hasElt(e) || this.right.hasElt(e);
	}

	// adds 1 to the number of nodes in the left and right subtrees
	public int size() {
		return 1 + this.left.size() + this.right.size();
	}

	// adds 1 to the height of the taller subtree
	public int height() {
		return 1 + Math.max(this.left.height(), this.right.height());
	}

	@Override
	public int getElt() {
		return data;
	}

	@Override
	public IBinTree getLeft() {
		return left;
	}

	@Override
	public IBinTree getRight() {
		return right;
	}

//	@Override
//	public boolean compareNode(IBinTree node) {
//		if(node.getElt() == null) return false;
//		return data < (int)node.getElt();
//	}
}