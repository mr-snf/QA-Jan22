package decision;

public class DecisionMaking {

	public static void main(String[] args) {

		int a = 25;

		// if block
//		if(a == 30) {
//			
//		}

//		if .. else block
//		if(condition) {
//			
//		} else {
//			
//		}

//		if (a % 2 == 0) {
//			System.out.println("a is divisible by 2");
//		}
//
//		else if (a % 3 == 0) {
//			System.out.println("a is divisible by 3");
//		}
//
//		else if (a % 5 == 0) {
//			System.out.println("a is divisible by 5");
//		}
//
//		else {
//			System.out.println("a is not divisble by 2 3 and 5");
//		}

//		if (a % 2 == 0) {
//
//			if (a % 3 == 0) {
//
//				if (a % 5 == 0) {
//
//					System.out.println("a is divisible by 2 3 and 5");
//
//				} else {
//					System.out.println("a is divisible by 2 3");
//				}
//
//			} else {
//				System.out.println("a is divisible by 2");
//			}
//
//		} else {
//			System.out.println("a is not divisible by 2");
//		}
		a = 20;

		switch (a) {

		case 10:
			System.out.println("the value of a is 10");
			break;

		case 20:
			System.out.println("the value of a is 20");
			break;

		case 30:
			System.out.println("the value of a is 30");
			break;

		case 40:
			System.out.println("the value of a is 40");
			break;

		default:
			System.out.println("the value of a is " + a);
			break;

		}

		char ch = 'A';

		switch (ch) {

		case 'A':
			System.out.println("A");
			break;

		case 'Z':
			System.out.println("Z");
			break;

		case 'F':
			System.out.println("F");
			break;

		case 'T':
			System.out.println("T");
			break;

		default:
			System.out.println("Default");
			break;

		}

	}
}
