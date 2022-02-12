package test;

import java.util.List;

public class ArraysClass {

	public static void printArray(int[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);

		}

	}

	public static void printArrays(double[] array) {

		for (double var : array) {
			System.out.println(var);
		}

	}

	public static void printSum(List<Integer> list) {
		int sum = 0;
		for (int val : list) {
			sum += val;
		}
		System.out.println(sum);
	}

}
