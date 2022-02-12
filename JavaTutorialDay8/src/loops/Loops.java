package loops;

public class Loops {

	public static void forIncrementalLoop() {

		for (int i = 0; i <= 10; i = i + 1) {
			System.out.println("this is incremental iteration " + i);
		}

	}

	public static void forDecrementalLoop() {

		for (int i = 100; i >= 0; i = i - 5) {
			System.out.println("this is decremental iteration " + i);
		}

	}

	public static void whileIncrementalLoop() {
		int j = 5;

		while (j <= 50) {
			System.out.println("This is incremental while loop, iteration " + j);

			j += 5;
		}

	}

	public static void whileDecrementalLoop() {
		int j = 15;

		while (j >= 0) {
			System.out.println("This is decremental while loop, iteration " + j);

			// --j; // j--;
			j = j - 3;
		}

	}

	public static void doWhileIncLoop() {

		int k = 5;

		do {
			System.out.println("This is incremental do while loop, iteration " + k);

			k += 5;
		} while (k <= 50);

	}

	public static void doWhileDecLoop() {

		int k = 50;

		do {
			System.out.println("This is decremental do while loop, iteration " + k);

			k -= 5;
		} while (k >= 0);

	}

	public static void printEvenNumbers(int num) {
		for (int n = 2; n <= num; n += 2) {
			System.out.println(n);
		}
	}

	public static void checkPrimeNumber(int num) {

		for (int k = 2; k <= num / 2; k++) {

			System.out.println("the number is being divided by " + k);
			if (num % k == 0) {
				System.out.println("this number is not prime number");
				break;
			}
			if (k == num / 2) {
				System.out.println("this number is a prime number");
			}
		}
	}

	public static void printPrimeNumbers(int number) {

		long start = System.currentTimeMillis();

		for (int k = 2; k <= number; k++) {
			boolean flag = true;
			for (int j = 2; j <= k / 2; j++) {

				if (k % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag)
				System.out.println(k);
		}

		// another way, found in the internet

//		for (int n = 1; n <= number; n++) {
//
//			int count = 0;
//
//			for (int i = 1; i <= n; i++) {
//
//				if (n % i == 0)
//					count++;
//			}
//			if (count == 2)
//				System.out.println(n);
//		}

		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println(end - start);

	}
}
