package Step_2;

import java.util.Scanner;

public class TeamMemberTest {
	boolean exit;
	public void runMemberMenu() {
		printMenuHeader();
		while (!exit) {
			printMenu();
			int choice = getInput();
			performActionMembers(choice);
		}
	}
	
	private void printMenuHeader() {
		System.out.println("-------------------------");
		System.out.println("-------------------------");
		System.out.println("----Team Member Menu----");
		System.out.println("-------------------------");
	}
	private void printMenu() {
		System.out.println("\nPlease select one of the following options");
		System.out.println("1) Add new team member");
		System.out.println("2) Find and display team member");
		System.out.println("3) Remove team member");
		System.out.println("4) Display details of all team members");
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
	private void performActionMembers(int choice) {
		switch(choice) {
		case 0:
			exit = true;
			System.out.println("Program terminated");
			break;
		case 1:
			addNewTeamMember();
		case 2:
			findTeamMember();
		case 3:
			removeTeamMember();
		case 4:
			displayAllTeamMembers();
		default: 
			System.out.println("An error has occured");
		}
	}
	private void addNewTeamMember() {
		
	}
	private void findTeamMember() {
		
	}
	private void removeTeamMember() {
		
	}
	private void displayAllTeamMembers() {
		
	}
}
