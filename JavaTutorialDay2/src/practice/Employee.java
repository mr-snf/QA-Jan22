package practice;

public class Employee {

	private int id = 745345;
	private String firstName = "Sanish";
	private String lastName = "LastName";
	private int salary = 999999999;
	private String department = "QA";

	public void getId() {
		int id = 5496856;
		System.out.println(id);
		System.out.println(this.id);
	}

	public void getName() {
		System.out.println(firstName + " " + lastName);
	}

	public void getSalary() {
		System.out.println(salary);
	}

	public void getDepartment() {
		System.out.println(department);
	}
}
