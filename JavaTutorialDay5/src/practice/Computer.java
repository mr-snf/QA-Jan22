package practice;

public class Computer {

	String maker;
	String tag;
	double price;
	int size;

	static String type = "Computer";

	final String text = "final text";

	public void setValues(String type, String tag, String maker, double price, int size) {
		Computer.type = type;
		this.price = price;
		this.size = size;
		this.maker = maker;
		this.tag = tag;

		// final variable can not be assigned a new value
//		text = "thjkerkejhrw";
	}

	public void displayLocal(double val) {
		double price = val;

		System.out.println("this is local variable:");
		System.out.println(price);
	}

	public void displayInstance() {
		System.out.println("these are instance variables:");
		System.out.println(maker);
		System.out.println(tag);
		System.out.println(this.price);
		System.out.println(size);
	}

	public void displayStatic() {
		System.out.println("this is static variable:");
		System.out.println(type);
	}

	public static void staticMethod() {
		System.out.println(type);
	}

	// this method can not be overridden
	public final void finalMethod() {
		System.out.println("45gfgafads");
	}
}
