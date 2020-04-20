package Step_3;

// MODEL
public class TeamMember {
	private String name;
	private int employeeNumber;
	private String division;


	public TeamMember(String name, int employeeNumber, String division) {
		this.name = name;
		this.employeeNumber = employeeNumber;
		this.division = division;
	}

	@Override
	public String toString() {
		String format = "%-30s %-15s %-15s";
		return String.format(format, this.name, this.employeeNumber, this.division);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}
}
