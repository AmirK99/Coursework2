package Step_1;

import java.util.*;


// CONTROLLER
public class Company {
	private String name;
	private Queue<Project> projects = new LinkedList<>();

	public Company(String name) {
		this.name = name;
	}

	public void add(Project project) {
		this.projects.add(project);
	}

	public Project findByName(String name) {
		for (Project p: projects) {
			if(p.getTitle().toLowerCase().equals(name.toLowerCase())){
				return p;
			}
		}
		return null;
	}

	public boolean findByNameAndDisplay(String name) {
		Project p = findByName(name);
		if(p!=null){
			String format = "\n%-30s %-15s %-15s\n";
			System.out.format(format,"TITLE","STARTS","ENDS");
			System.out.println(p.toString());
			return true;
		}else{
			return false;
		}
	}

	public Project removeByName(String name) {
		Project p = findByName(name);
		if(p != null) {
			remove(p);
			return p;
		} else {
			return null;
		}
	}

	public void remove(Project project) {
		this.projects.remove(project);
	}

	public void displayAll() {
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
}
