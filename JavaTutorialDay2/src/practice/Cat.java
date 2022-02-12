package practice;

public class Cat {

	String name = "Ben";
	int age = 2;
	String color = "Grey";
	float weight = 3.5f;

	public void sleep() {
		System.out.println("The cat is sleeping");
	}

	protected String eat() {
		String food = "meat";
		return food;
	}

	private void meow() {
		System.out.println("meow");
	}

	void purr() {
		meow();
		System.out.println("purr");
	}

	public void aboutCat() {
		System.out.println("It's name is " + name);
		System.out.println("It is " + age + " years old");
		System.out.println("It is of " + color + " color");
		System.out.println("It weighs " + weight + " kg");
	}

	public static void main(String[] args) {
		Cat cat1 = new Cat();

		cat1.sleep();
		String catFood = cat1.eat();
		System.out.println(catFood);

		cat1.meow();
		cat1.purr();

		cat1.aboutCat();
	}

}
