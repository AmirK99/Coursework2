package Step_2;

import java.util.Scanner;

public class CompanyTest {
	boolean exit;
	public void runProjectMenu() {
		printMenuHeader();
		while (!exit) {
			printMenu();
			int choice = getInput();
			performActionProject(choice);
		}
	}
	
	private void printMenuHeader() {
		System.out.println("-------------------------");
		System.out.println("-------------------------");
		System.out.println("-------Project Menu------");
		System.out.println("-------------------------");
	}
	private void printMenu() {
		System.out.println("\nPlease select one of the following options");
		System.out.println("1) Add new project");
		System.out.println("2) Find and display project");
		System.out.println("3) Remove specific project");
		System.out.println("4) Display details of current projects");
		System.out.println("0) Exit program");
	}
	
	private int getInput() {
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
				System.out.print("\n>> ");
				choice = Integer.parseInt(kb.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.print("Invalid choice, please try again");
				
			}
		}return choice;
	}
	/*this method performs an action based on the user's
	 * choice using a switch statement
	 */
	private void performActionProject(int choice) {
		switch(choice) {
		case 0:
			exit = true;
			System.out.println("Program terminated");
			break;
		case 1:
			addNewProject();
		case 2:
			findProject();
		case 3:
			removeProject();
		case 4:
			displayCurrentProject();
		default: 
			System.out.println("An error has occured");
		}
	}
	private void addNewProject() {
		
	}
	private void findProject() {
		
	}
	private void removeProject() {
		
	}
	private void displayCurrentProject() {
		
	}
	
}
