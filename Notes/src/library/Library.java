package library;
import java.util.LinkedList;

public class Library {

	LinkedList<Book> books;
	
	public Library(LinkedList<Book> books) {
		this.books = books;
	}
	
	//Overloaded constructor
	public Library() {
		this.books = new LinkedList<Book>();
	}
	
	public void addBook(Book aBook) {
		books.add(aBook);
	}
	
	public boolean findABook(String myTitle) {
		for(Book aBook : this.books) {
			if(aBook.title.equals(myTitle))
			{
				return true;
			}
		}
		return false;
	}
	
	public int countAllTheBooksThatMatchTitle(String myTitle) {
		//return books.size();
		
		int numOfBooks = 0;
		//accumulator
		for(Book aBook : this.books) {
			if(aBook.title.equals(myTitle)) {
			numOfBooks++;
			}
		}	
		return numOfBooks;
	}
	
	public boolean timeToReplace(Book aBook) {
		return aBook.checkOut().timesOut > 400;
	}
	
}
