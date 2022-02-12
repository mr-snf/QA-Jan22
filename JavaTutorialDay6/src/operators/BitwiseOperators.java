package operators;

public class BitwiseOperators {

	public static void main(String[] args) {
		int num1, num2;
		num1 = 10; // 0000 1010
		num2 = 5; // 0000 0101

		System.out.println(num1 & num2);
		System.out.println(num1 | num2);
		System.out.println(num1 ^ num2);
		System.out.println(~num1);
		System.out.println(num1 >> 2);
		System.out.println(num2 << 2);
		System.out.println(num1 >>> 3); // 0000 0001

	}

}
