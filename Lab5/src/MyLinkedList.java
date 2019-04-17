import java.util.LinkedList;

class MyLinkedList extends LinkedList<String> implements ISet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ISet addElt(String elt) {
		this.add(elt);
		return this;
	}

	@Override
	public boolean hasElt(String elt) {
		return this.contains(elt);
	}

}
