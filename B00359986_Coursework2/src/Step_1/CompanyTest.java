package Step_1;

import java.util.Date;
import java.util.Scanner;


// VIEW
public class CompanyTest {

    private boolean exit = false;
    private Company company = new Company("My Company");

    public void runProjectMenu() {

        company.add(new Project("Update Website", new Date(120, 1, 1),  new Date(120, 2, 1)));
        company.add(new Project("Backup Database", new Date(120, 1, 14),  new Date(120, 2, 2)));
        company.add(new Project("Test New Server", new Date(120, 2, 4),  new Date(120, 2, 26)));
        company.add(new Project("Post on Facebook", new Date(120, 2, 4),  new Date(120, 2, 29)));
        company.add(new Project("Clean the office", new Date(120, 1, 1),  new Date(120, 2, 1)));
        company.add(new Project("Change font on website", new Date(120, 1, 14),  new Date(120, 2, 2)));
        company.add(new Project("Upload video on youtube", new Date(120, 2, 4),  new Date(120, 2, 26)));
        company.add(new Project("Upload photo to instagram", new Date(120, 2, 4),  new Date(120, 2, 29)));

        while (!exit) {
            printMenu();
            int choice = getMenuInput();
            performActionProject(choice);
        }
    }

    private void printMenuHeader() {
        System.out.println("\n------- Project Menu ------");
    }

    private void printMenu() {
        printMenuHeader();
        System.out.println("Please select one of the following options");
        System.out.println("1) Add new project");
        System.out.println("2) Find and display project");
        System.out.println("3) Remove specific project");
        System.out.println("4) Display details of current projects");
        System.out.println("0) Exit program");
    }

    private int getMenuInput() {
        Scanner kb = new Scanner(System.in);
        /*this is set to -1 so it doesn't cause an error as the exit
         * value is 0
         */
        int choice = -1;
        while (choice < 0 || choice > 4) {
            /*this statement catches the number format
             * exception thrown by choice
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
             * exception thrown 
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

    /*method performs action based on the user's
     * choice
     * uses switch statement
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
                findProject();
                break;
            case 3:
                removeProject();
                break;
            case 4:
                displayCurrentProjects();
                break;
            default:
                System.out.println("An error has occured");
        }
    }

    private void addNewProject() {
        System.out.println("Please enter project name: ");
        String titleInput = getStringInput();
        if(company.findByName(titleInput) != null){
            System.out.println("Project by this name already exists");
        } else {
            System.out.println("Please enter project starting date");
            Date starting = getDateInput();
            System.out.println("Please enter project ending date");
            Date ending = getDateInput();
            Project project = new Project(titleInput, starting, ending);
            company.add(project);
            System.out.println("Project added successfully");
        }
    }

    private void findProject() {
        System.out.println("Please enter project name: ");
        String nameInput = getStringInput();
        if(!company.findByNameAndDisplay(nameInput)){
            System.out.println("Project not found");
        }
    }

    private void removeProject() {
        System.out.println("Please enter project name: ");
        String nameInput = getStringInput();
        Project p = company.removeByName(nameInput);
        if(p != null){
            System.out.println(p.getTitle() + " has been removed");
        } else {
            System.out.println("Project not found");
        }
    }

    private void displayCurrentProjects() {
        company.displayAll();
    }
}
