/**
 * 
 */
package employees;

/**
 * The parent class for all employee types at ACME Inc.
 */
public class Employee {

	private String firstName;
	private String lastName;
	private int employeeNumber;
	/**
	 * 
	 */
	public Employee() {
	}
	/**
	 * @param firstName
	 * @param lastName
	 * @param employeeNumber
	 */
	public Employee(String firstName, String lastName, int employeeNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = employeeNumber;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the employeeNumber
	 */
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	/**
	 * @param employeeNumber the employeeNumber to set
	 */
	public void setEmployeeNumber(int employeeNumber) {
		//This makes sure that a negative value entered returns the abs. value.
		if (employeeNumber>0) {
			this.employeeNumber = employeeNumber;
		} else {
			this.employeeNumber = -employeeNumber; 
		}
	}
		/**
		 *method to calculate the monthly payment
		 */
		public double getMonthlyPay() {
			double monthlyPay = 0.0;
			return monthlyPay;
		}
		
		public String getEmployeeType() {
			return "Employee";
		}
		
		@Override //This method is overriding the method of the parent class 'toString'.
		// sets the name in a different format, last name then first name
		public String toString() {
		    return String.format(
		    	"%-30s %-30s %-14s$%-10s\n",
		        "Name:" + getLastName() + ", " + getFirstName(),
		        "Type:" + getEmployeeType(),
		        "Monthly Pay: ",
		        //Converts the double into a string so in can have the thousands separated with commas.
		        String.format("%,.2f", getMonthlyPay())
		    );
		}
		
}
		
