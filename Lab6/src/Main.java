import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Stream;
/**
 * Testing
 * @author Gus Teran
 *
 */
public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);

		Precinct worcester12;
		worcester12 = new Precinct("Worcester12", "130 Winter Street", 1673);
		System.out.println(worcester12);
		
		Precinct worcester = new Precinct(keyboard);
		
		LinkedList<String> words = new LinkedList<String>();
		Stream<String> wordStream = words.stream();
		wordStream.filter(word -> word.length() > 5);

	}
}
