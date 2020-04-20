package Step_2;

import java.util.*;


// CONTROLLER
public class Company {
	private String name;
	private Queue<Project> projects = new LinkedList<>();
	private ArrayList<TeamMember> teamMembers = new ArrayList<>();

	public Company(String name) {
		this.name = name;
	}

	public void addProject(Project project) {
		this.projects.add(project);
	}

	public void addTeamMember(TeamMember teamMember){
		this.teamMembers.add(teamMember);
	}

	public Project findProjectByName(String name) {
		for (Project p: projects) {
			if(p.getTitle().toLowerCase().equals(name.toLowerCase())){
				return p;
			}
		}
		return null;
	}

	public TeamMember findTeamMemberByName(String name) {
		for (TeamMember t: teamMembers) {
			if(t.getName().toLowerCase().equals(name.toLowerCase())){
				return t;
			}
		}
		return null;
	}

	public boolean findProjectByNameAndDisplay(String name) {
		Project p = findProjectByName(name);
		if(p!=null){
			String format = "\n%-30s %-15s %-15s\n";
			System.out.format(format,"TITLE","STARTS","ENDS");
			System.out.println(p.toString());
			return true;
		}else{
			return false;
		}
	}

	public boolean findTeamMemberByNameAndDisplay(String name) {
		TeamMember t = findTeamMemberByName(name);
		if(t!=null){
			String format = "\n%-30s %-15s %-15s\n";
			System.out.format(format,"NAME","EMPLOYEE ID","DIVISION");
			System.out.println(t.toString());
			return true;
		}else{
			return false;
		}
	}

	public Project removeProjectByName(String name) {
		Project p = findProjectByName(name);
		if(p != null) {
			removeProject(p);
			return p;
		} else {
			return null;
		}
	}

	public void removeProject(Project project) {
		this.projects.remove(project);
	}

	public TeamMember removeTeamMemberByName(String name) {
		TeamMember t = findTeamMemberByName(name);
		if(t != null) {
			removeTeamMember(t);
			return t;
		} else {
			return null;
		}
	}

	public void removeTeamMember(TeamMember teamMember) {
		this.teamMembers.remove(teamMember);
	}

	public void displayAllProjects() {
		String format = "\n%-30s %-15s %-15s\n";
		if(projects.isEmpty()) {
			System.out.println("No projects in the system");
			return;
		}
		System.out.format(format,"TITLE","STARTS","ENDS");
		List<Project> temp = new ArrayList<>(projects);
		Collections.sort(temp);
		for (Project p: temp) {
			System.out.println(p.toString());
		}
	}

	public void displayAllTeamMembers() {
		String format = "\n%-30s %-15s %-15s\n";
		if(teamMembers.isEmpty()) {
			System.out.println("No team members in the system");
			return;
		}
		System.out.format(format,"NAME","EMPLOYEE ID","DIVISION");
		for (TeamMember teamMember: teamMembers) {
			System.out.println(teamMember.toString());
		}
	}
}
