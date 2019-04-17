import java.util.Scanner;
/**
 * A basic implementation of a precinct
 * @author Gus Teran
 *
 */
public class Precinct {
	
	private String name;
	private String address;
	private int population;
	
	public Precinct(Scanner sc) {
		System.out.println("Please enter the name of the precinct ");
		name = sc.nextLine();
		System.out.println("Please enter the address ");
		address = sc.nextLine();
		System.out.println("Please enter the population ");
		population = sc.nextInt();
		System.out.println(toString());
	}
	
	public Precinct(String name, String address, int population) {
		this.name = name;
		this.address = address;
		this.population = population;
	}
	
	public String toString() {
		return "Precinct: "+name+", Address: "+address+", Population: "+population;
	}
	
	// Produces precinct with same name and address as this,
	// but with given amount added to the population
	public Precinct grow(int amount) {
		population += amount;
		return this;
	}
}