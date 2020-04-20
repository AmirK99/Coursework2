package Step_3;

import java.util.*;


// CONTROLLER
public class Company {
	private String name;
	private ProjectBST projects = new ProjectBST();

	public Company() {
		this.name = name;
	}

	@Override
	public String toString() {
		if(projects.isEmpty()) return null;
		return projects.toString();
	}

	public void addProject(Project project) {
		this.projects.insert(project);
	}

	public Project findProjectByName(String name) {
		return this.projects.findByName(name);
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

	public Project removeProjectByName(String name) {
		Project p = findProjectByName(name);
		if(p != null) {
			removeProject(p);
			return p;
		} else {
			return null;
		}
	}

	public boolean removeProject(Project project) {
		return this.projects.remove(project);
	}

	public void displayAllProjects() {
		String format = "\n%-30s %-15s %-15s %s\n";
		if(projects.isEmpty()) {
			System.out.println("No projects in the system");
			return;
		}
		System.out.format(format,"TITLE","STARTS","ENDS", "TEAM MEMBERS");
		System.out.println(projects.toString());
	}

	public void displayAllProjectTeamSizes() {
		if(projects.isEmpty()) {
			System.out.println("No projects in the system");
			return;
		}
		String format = "\n%-30s %-15s %-15s %s\n";
		System.out.format(format,"TITLE","STARTS","ENDS", "TEAM MEMBERS");
		projects.displayAllTeamSizes();
	}
}
