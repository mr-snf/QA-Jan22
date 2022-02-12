package practice;

public class TestApp {

	public static void main(String[] args) {

		// This is the way to access static variable
		Computer.type = "Electronics";

		Computer lg = new Computer();
		Computer dell = new Computer();

		Computer.staticMethod();

//		lg.displayStatic();
//		dell.displayStatic();
//
//		lg.setValues("Laptop", "5yhszd5y", "LG", 1500.0, 15);
//		lg.displayLocal(1555.5);
//		lg.displayInstance();
//		lg.displayStatic();
//		dell.displayStatic();
//
//		dell.setValues("Desktop", "s4atDS4", "Dell", 3200, 24);
//		dell.displayLocal(3330.99);
//		dell.displayInstance();
//		dell.displayStatic();
//
//		lg.displayStatic();
	}

}
