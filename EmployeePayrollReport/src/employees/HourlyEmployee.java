/**
 * 
 */
package employees;

/**
 * 
 */
public class HourlyEmployee extends Employee {

	private int monthlyHours;
	private double hourlyRate;
	
	/**
	 * 
	 */
	public HourlyEmployee() {
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param employeeNumber
	 */
	public HourlyEmployee(String firstName, String lastName, int employeeNumber, int monthlyHours, double hourlyRate) {
		super(firstName, lastName, employeeNumber); 
		this.monthlyHours = monthlyHours;
		this.hourlyRate = hourlyRate;
	}

	/**
	 * @return the monthlyHours
	 */
	public int getMonthlyHours() {
		return monthlyHours;
	}

	/**
	 * @param monthlyHours the monthlyHours to set
	 */
	public void setMonthlyHours(int monthlyHours) {
		this.monthlyHours = monthlyHours;
	}

	/**
	 * @return the hourlyRate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * @param hourlyRate the hourlyRate to set
	 */
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	@Override
	public double getMonthlyPay() {
		double monthlyPay;
		monthlyPay = this.getHourlyRate()*this.getMonthlyHours();
		return monthlyPay;
	}
	
	public String getEmployeeType() {
		return "Hourly Employee";
	}

	@Override
	//takes from the parent class, Employee
	public String toString() {
		return super.toString();
	}

}
