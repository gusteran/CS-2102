package library;

public class NonEmptyList implements IList {

	Book aBook;
	IList restOfList;
	
	public int countBooks() {
		return 1 + restOfList.countBooks();
	}
	
}
