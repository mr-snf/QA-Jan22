package operators;

public class LogicalOperators {

	public static void main(String[] args) {

		boolean val1 = false, val2 = true;

		int num1 = 17, num2 = 13, num3 = 11;

		System.out.println(val1 && val2);
		System.out.println(val1 || val2);
		System.out.println(!val2);
		System.out.println((!(!val1 && val2) || val1) && !val2);

		System.out.println((num1 == num2) && (num1 < num3));
		System.out.println((num1 == num2) || (num1 < num3));
		System.out.println(!((num1 == num2) || (num1 < num3)));

	}

}
