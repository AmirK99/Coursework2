package Step_3;

import java.util.Date;
import java.util.Scanner;


// VIEW
public class BSTTest {

    private boolean exit = false;
    private Company company = new Company();

    public void runProjectMenu() {

        Project p1 = new Project("Update Website", new Date(120, 1, 1),  new Date(120, 2, 1));
        Project p2 = new Project("Backup Database", new Date(120, 1, 14),  new Date(120, 2, 2));
        Project p3 = new Project("Test New Server", new Date(120, 2, 4),  new Date(120, 2, 26));
        Project p4 = new Project("Post on Facebook", new Date(120, 2, 4),  new Date(120, 2, 29));
        Project p5 = new Project("Clean the office", new Date(120, 1, 1),  new Date(120, 2, 1));

        p1.addTeamMember(new TeamMember("Jack Gray", 1, "Marketing"));
        p2.addTeamMember(new TeamMember("Peter Brown", 2, "HR"));
        p3.addTeamMember(new TeamMember("Julia Green", 3, "HR"));
        p2.addTeamMember(new TeamMember("Maria Black", 4, "Operations"));
        p3.addTeamMember(new TeamMember("Victoria Red", 5, "Operations"));
        p3.addTeamMember(new TeamMember("Ben Scarlet", 6, "Operations"));
        p4.addTeamMember(new TeamMember("Jack Green", 7, "Marketing"));
        p1.addTeamMember(new TeamMember("Peter Pink", 8, "HR"));
        p2.addTeamMember(new TeamMember("Julia Orange", 9, "HR"));
        p3.addTeamMember(new TeamMember("Maria Red", 10, "Operations"));
        p5.addTeamMember(new TeamMember("Victoria Green", 11, "Operations"));
        p1.addTeamMember(new TeamMember("Ben Brown", 12, "Operations"));
        p3.addTeamMember(new TeamMember("Jack Green", 13, "Marketing"));
        p4.addTeamMember(new TeamMember("Peter Pink", 14, "HR"));
        p2.addTeamMember(new TeamMember("Julia Green", 15, "HR"));
        p3.addTeamMember(new TeamMember("Maria Scarlet", 16, "Operations"));
        p4.addTeamMember(new TeamMember("Victoria Beige", 17, "Operations"));
        p5.addTeamMember(new TeamMember("Ben Silver", 18, "Operations"));

        company.addProject(p1);
        company.addProject(p2);
        company.addProject(p3);
        company.addProject(p4);
        company.addProject(p5);

        while (!exit) {
            printMenu();
            int choice = getMenuInput();
            performActionProject(choice);
        }
    }

    private void printMenuHeader() {
        System.out.println("\n------- BST Menu ------");
    }

    private void printMenu() {
        printMenuHeader();
        System.out.println("Please select one of the following options");
        System.out.println("1) Add project");
        System.out.println("2) Add team member to project");
        System.out.println("3) Remove team member from project");
        System.out.println("4) Remove project");
        System.out.println("5) Display team members of project");
        System.out.println("6) Display all team members of all projects");
        System.out.println("7) Display team sizes of all projects");
        System.out.println("0) Exit program");
    }

    private int getMenuInput() {
        Scanner kb = new Scanner(System.in);
        /*this is set to -1 as to not class with the exit
         * value of 0
         */
        int choice = -1;
        while (choice < 0 || choice > 7) {
            /*this statement catches the number format
             * exception that could be thrown by choice
             */
            try {
                System.out.print(">> ");
                choice = Integer.parseInt(kb.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid choice, please try again");
            }
        }
        return choice;
    }

    private int getIntInput() {
        Scanner kb = new Scanner(System.in);
        int choice;
        while (true) {
            /*this statement catches the number format
             * exception that could be thrown by choice
             */
            try {
                System.out.print("\n>> ");
                choice = Integer.parseInt(kb.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input, please try again");
            }
        }
        return choice;
    }

    private String getStringInput() {
        Scanner kb = new Scanner(System.in);
        return kb.nextLine();
    }

    public Date getDateInput() {
        int day, month, year;
        System.out.println("Please enter day");
        day = getIntInput();
        System.out.println("Please enter month");
        month = getIntInput() - 1;
        System.out.println("Please enter year");
        year = getIntInput() - 1900;
        return new Date(year, month, day);
    }

    /*this method performs an action based on the user's
     * choice using a switch statement
     */
    private void performActionProject(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Are you sure you want to leave? (y/n)");
                if(getStringInput().equals("y")){
                    exit = true;
                    System.out.println("Program terminated");
                }
                break;
            case 1:
                addNewProject();
                break;
            case 2:
                addTeamMemberToProject();
                break;
            case 3:
                removeTeamMemberFromProject();
                break;
            case 4:
                removeProject();
                break;
            case 5:
                displayAllTeamMembersOfProject();
                break;
            case 6:
                displayAllTeamMembersOfAllProjects();
                break;
            case 7:
                displayTeamSizesOfAllProjects();
                break;
            default:
                System.out.println("An error has occured");
        }
    }

    private void displayAllTeamMembersOfProject() {
        System.out.println("Please enter project name: ");
        String titleInput = getStringInput();
        Project p = company.findProjectByName(titleInput);
        if(p != null){
            p.displayAllTeamMembers();
        } else {
            System.out.println("Project not found");
        }
    }

    private void displayAllTeamMembersOfAllProjects() {
        company.displayAllProjects();
    }

    private void removeProject() {
        System.out.println("Please enter project name: ");
        String titleInput = getStringInput();
        Project p = company.findProjectByName(titleInput);
        if(p != null){
            if(company.removeProject(p)){
                System.out.println("Project " + p.getTitle() + " removed" );
            }
        } else {
            System.out.println("Project not found");
        }
    }

    private void removeTeamMemberFromProject() {
        System.out.println("Please enter project name: ");
        String titleInput = getStringInput();
        Project p = company.findProjectByName(titleInput);
        if(p != null){
            System.out.println("Please enter team member name: ");
            String nameInput = getStringInput();
            TeamMember t = p.removeTeamMemberByName(nameInput);
            if(t != null){
                System.out.println(t.getName() + " has been removed");
            } else {
                System.out.println("Team member not found");
            }
        } else {
            System.out.println("Project not found");
        }
    }

    private void displayTeamSizesOfAllProjects() {
        company.displayAllProjectTeamSizes();
    }

    private void addTeamMemberToProject() {
        System.out.println("Please enter project name: ");
        String titleInput = getStringInput();
        Project p = company.findProjectByName(titleInput);
        if(p != null){
            System.out.println("Please enter team member name: ");
            String nameInput = getStringInput();
            System.out.println("Please enter employee number: ");
            int employeeNumber = getIntInput();
            System.out.println("Please enter division: ");
            String division = getStringInput();
            TeamMember teamMember = new TeamMember(nameInput, employeeNumber, division);
            p.addTeamMember(teamMember);
            System.out.println(nameInput + " has been added");
        } else {
            System.out.println("Project not found");
        }
    }

    private void addNewProject() {
        System.out.println("Please enter project name: ");
        String titleInput = getStringInput();
        if(company.findProjectByName(titleInput) != null){
            System.out.println("Project by this name already exists");
        } else {
            System.out.println("Please enter project starting date");
            Date starting = getDateInput();
            System.out.println("Please enter project ending date");
            Date ending = getDateInput();
            Project project = new Project(titleInput, starting, ending);
            company.addProject(project);
            System.out.println("Project added successfully");
        }
    }
}
