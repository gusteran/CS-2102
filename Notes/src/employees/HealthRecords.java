package employees;

import java.util.LinkedList;

public class HealthRecords {

	LinkedList<Team> teams;
	
	public HealthRecords(LinkedList<Team> teams) {
		this.teams = teams;
		sumSickDays();
		sortTeams();
	}
	
//	public HealthRecords(LinkedList<Employee> employees) {
//		createTeams(employees);
//		sumSickDays();
//		sortTeams();
//	}
	
	public void sortTeams() {
		LinkedList<Team> teamSorted =  new LinkedList<Team>();
		while(teams.size()>0) {
			Team lowest = teams.getFirst();
			for(int i = 1; i<teams.size();i++) {
				if(teams.get(i).totalSickDays<lowest.totalSickDays)
					lowest = teams.get(i);
			}
			teams.remove(lowest);
			teamSorted.add(lowest);
		}
		teams = teamSorted;
	}
	
	public void sumSickDays() {
		for(Team team: teams) {
			team.sickDays();
		}
	}
	
	public void createTeams(LinkedList<Employee> employees) {
		for(Employee employee: employees) {
			if(!addToExistingTeam(employee)){
				LinkedList<Employee> teamsEmployees = new LinkedList<Employee>();
				teamsEmployees.add(employee);
				teams.add(new Team(employee.name, teamsEmployees));
			}
		}
	}
	
	public boolean addToExistingTeam(Employee employee) {
		for(Team team: teams) {
			if(employee.team.equals(team.name)) {
				team.employees.add(employee);
				return true;
			}
		}
		return false;
	}
	
	
}
