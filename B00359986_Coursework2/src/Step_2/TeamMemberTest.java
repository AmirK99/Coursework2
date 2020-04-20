package Step_2;

import java.util.Date;
import java.util.Scanner;


// VIEW
public class TeamMemberTest {

    private boolean exit = false;
    private Company company = new Company("My Company");

    public void runProjectMenu() {
    	/*
    	 * This is data which will populate the array list and the subsequent binary tree
    	 * so that when it comes to running the program to ensure it works new data isn't necessary
    	 */
    	
        company.addProject(new Project("Update Website", new Date(120, 1, 1),  new Date(120, 2, 1)));
        company.addProject(new Project("Backup Database", new Date(120, 1, 14),  new Date(120, 2, 2)));
        company.addProject(new Project("Test New Server", new Date(120, 2, 4),  new Date(120, 2, 26)));
        company.addProject(new Project("Post on Facebook", new Date(120, 2, 4),  new Date(120, 2, 29)));
        company.addProject(new Project("Clean the office", new Date(120, 1, 1),  new Date(120, 2, 1)));
        company.addProject(new Project("Change font on website", new Date(120, 1, 14),  new Date(120, 2, 2)));
        company.addProject(new Project("Upload video on youtube", new Date(120, 2, 4),  new Date(120, 2, 26)));
        company.addProject(new Project("Upload photo to instagram", new Date(120, 2, 4),  new Date(120, 2, 29)));

        company.addTeamMember(new TeamMember("Jack Gray", 1, "Marketing"));
        company.addTeamMember(new TeamMember("Peter Brown", 2, "HR"));
        company.addTeamMember(new TeamMember("Julia White", 3, "HR"));
        company.addTeamMember(new TeamMember("Maria Black", 4, "Operations"));
        company.addTeamMember(new TeamMember("Victoria Red", 5, "Operations"));
        company.addTeamMember(new TeamMember("Ben Blue", 6, "Operations"));

        while (!exit) {
            printMenu();
            int choice = getMenuInput();
            performActionProject(choice);
        }
    }

    private void printMenuHeader() {
        System.out.println("\n------- Team Member Menu ------");
    }

    private void printMenu() {
        printMenuHeader();
        System.out.println("Please select one of the following options");
        System.out.println("1) Add new team member");
        System.out.println("2) Find and display team member");
        System.out.println("3) Remove team member");
        System.out.println("4) Display details of all team members");
        System.out.println("0) Exit program");
    }

    private int getMenuInput() {
        Scanner kb = new Scanner(System.in);
        /*this is set to -1 as to not class with the exit
         * value of 0
         */
        int choice = -1;
        while (choice < 0 || choice > 4) {
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
                addNewTeamMember();
                break;
            case 2:
                findTeamMember();
                break;
            case 3:
                removeTeamMember();
                break;
            case 4:
                displayTeamMembers();
                break;
            default:
                System.out.println("An error has occured");
        }
    }

    private void addNewTeamMember() {
        System.out.println("Please enter team member name: ");
        String nameInput = getStringInput();
        System.out.println("Please enter employee number: ");
        int employeeNumber = getIntInput();
        System.out.println("Please enter division: ");
        String division = getStringInput();
        TeamMember teamMember = new TeamMember(nameInput, employeeNumber, division);
        company.addTeamMember(teamMember);
        System.out.println(nameInput + " has been added");
    }

    private void findTeamMember() {
        System.out.println("Please enter team member name: ");
        String nameInput = getStringInput();
        if(!company.findTeamMemberByNameAndDisplay(nameInput)){
            System.out.println("Team member not found");
        }
    }

    private void removeTeamMember() {
        System.out.println("Please enter team member name: ");
        String nameInput = getStringInput();
        TeamMember t = company.removeTeamMemberByName(nameInput);
        if(t != null){
            System.out.println(t.getName() + " has been removed");
        } else {
            System.out.println("Team member not found");
        }
    }

    private void displayCurrentProjects() {
        company.displayAllProjects();
    }

    private void displayTeamMembers() {
        company.displayAllTeamMembers();
    }
}
