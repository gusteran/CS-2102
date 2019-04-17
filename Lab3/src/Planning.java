import java.util.LinkedList;

public class Planning {

	
	
	public double rainfall(LinkedList<Double> list){
		double sum = 0;
		int count = 0;
		for(double rainfall:list) {
			if(rainfall == -999) {
				break;
			} else if(rainfall>=0) {
				sum+=rainfall;
				count++;
			}
		}
		if(count ==0)return 0;
		return sum/count;
	}
}

abstract class AbsAnimal {
	String name;
}

abstract class AbsLabAnimal extends AbsAnimal{
	Food food;
}

class LabMouse extends AbsLabAnimal{
	Exercise workout;
	LinkedList<Weight> dailyWeights;
}

class Food {
	String name;
	double amount;
}

class Exercise{
	int amountPerDay;
	double minutes;
}

class Weight{
	double weight;
	int date;
}