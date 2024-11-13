package employees;

public class SalariedEmployee extends Employee {

private double yearlySalary; //encapsulation & declare local variable	

/**
 * 
 */
public SalariedEmployee() {
	super(); 
	// TODO Auto-generated constructor stub
}

/**
 * @param firstName
 * @param lastName
 * @param employeeNumber
 */
public SalariedEmployee(String firstName, String lastName, int employeeNumber, double yearlySalary) {
	super(firstName, lastName, employeeNumber);
	this.yearlySalary = yearlySalary;
}

/**
 * @return the yearlySalary
 */
public double getYearlySalary() {
	return yearlySalary;
}

/**
 * @param yearlySalary the yearlySalary to set
 */
public void setYearlySalary(double yearlySalary) {
	this.yearlySalary = yearlySalary;
}
// This was an override too, but I forgot about the Source shortcut to do so.	
public double getMonthlyPay() {
	double monthlyPay;
	monthlyPay = this.getYearlySalary() / 12;
	return monthlyPay;
}

@Override
public String getEmployeeType() {
	// TODO Auto-generated method stub
	return "Salaried Employee";
}

@Override
//takes from the parent class, Employee
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}	


}
