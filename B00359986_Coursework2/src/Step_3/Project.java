package Step_3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


// MODEL
public class Project implements Comparable<Project> {

    private String title;
    private Date starting, ending;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private ArrayList<TeamMember> teamMembers = new ArrayList<>();

    public Project(String title, Date starting, Date ending) {
        this.title = title;
        this.starting = starting;
        this.ending = ending;
    }
    public void addTeamMember(TeamMember teamMember){
        this.teamMembers.add(teamMember);
    }

    public TeamMember findTeamMemberByName(String name) {
        for (TeamMember t: teamMembers) {
            if(t.getName().toLowerCase().equals(name.toLowerCase())){
                return t;
            }
        }
        return null;
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

    public void displayAllTeamMembers() {
        String format = "\n%-30s %-15s %-15s\n";
        if(teamMembers.isEmpty()) {
            System.out.println("No team members assigned to the project");
            return;
        }
        System.out.format(format,"NAME","EMPLOYEE ID","DIVISION");
        for (TeamMember teamMember: teamMembers) {
            System.out.println(teamMember.toString());
        }
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

    @Override
    public String toString() {
        String format = "%-30s %-15s %-15s %s";
        String memberList = "";
        if(teamMembers.isEmpty()){
            memberList = "No Members";
        } else {
            for (TeamMember t : teamMembers) memberList += t.getName() + " ("+ t.getEmployeeNumber() + ", " + t.getDivision()+"), ";
            memberList = memberList.substring(0, memberList.length()-2);
        }
        return String.format(format, this.title, dateFormat.format(starting), dateFormat.format(ending), memberList);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStarting() {
        return starting;
    }

    public void setStarting(Date starting) {
        this.starting = starting;
    }

    public Date getEnding() {
        return ending;
    }

    public void setEnding(Date ending) {
        this.ending = ending;
    }

    @Override
    public int compareTo(Project project) {
        return this.title.compareTo(project.title);
    }

    public void printMembersNumber() {
        String format = "%-30s %-15s %-15s %-4s\n";
        System.out.format(format, this.title, dateFormat.format(starting), dateFormat.format(ending), teamMembers.size());
    }
}
