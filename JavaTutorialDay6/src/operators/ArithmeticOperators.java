package operators;

public class ArithmeticOperators {

	public static void main(String[] args) {

		double a = 100, b = 11;

		double c = a + b;

		System.out.println("the value of c: " + c);

		double d = a - b;

		System.out.println("the value of d: " + d);

		System.out.println("the value of a*b: " + a * b);
		System.out.println("the value of a/b: " + a / b);

		System.out.println("the value of a%b: " + a % b);

		d = a + 1;
		
		System.out.println("the value of d: " + d);
		
		a = a + 1;
		
		System.out.println("the value of a: " + a);
		a++;
		System.out.println("the value of a: " + a);
		++a;
		System.out.println("the value of a: " + a);
		b--;
		System.out.println("the value of b: " + b);
		--b;
		System.out.println("the value of b: " + b);
		

	}

}
