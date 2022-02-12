package practice;

public class TestApp {
	public static void main(String[] args) {
		Cat cat1 = new Cat();

		cat1.sleep();
		String catFood = cat1.eat();
		System.out.println(catFood);

		// this is a private method and is called from outside of that class
		// cat1.meow();
		cat1.purr();

		cat1.aboutCat();

		Employee sanish = new Employee();
		sanish.getName();
		sanish.getId();
		sanish.getDepartment();
		sanish.getSalary();
		
	}
}