package employees;

import java.util.LinkedList;

public class Team {		
	LinkedList<Employee> employees;
	String name;
	int totalSickDays;
	
	public Team(String name, LinkedList<Employee> employees) {
		this.name = name;
		this.employees = employees;
	}
	
	public void sickDays() {
		for(Employee employee: employees) {
			totalSickDays += employee.missedDays;
		}
	}
}
