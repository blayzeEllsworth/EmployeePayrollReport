package employees;

public class StudentEmployee extends HourlyEmployee {

	private int monthlyHours;
	private double hourlyRate;
	
	public StudentEmployee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param employeeNumber
	 * @param monthlyHours
	 * @param hourlyRate
	 */
	public StudentEmployee(String firstName, String lastName, int employeeNumber, int monthlyHours, double hourlyRate) {
		super(firstName, lastName, employeeNumber, monthlyHours, hourlyRate);
		this.monthlyHours = monthlyHours;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public double getMonthlyPay() {
		double monthlyPay;  
		if (this.monthlyHours <= 40) {                      // This will check whether a student logged less than 40 hrs.
			monthlyPay = this.monthlyHours * this.hourlyRate; // Paid for each hour of completed work.
		}
		else {
			monthlyPay= 40 * this.hourlyRate; //max'd out pay
		}
		return monthlyPay;
	}

	@Override
	public String getEmployeeType() {
		// TODO Auto-generated method stub
		return "Student Employee";
	}

	@Override
	//takes from the parent class, Employee
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
