package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ArraysPractice {

	public static void main(String[] args) {

		int[] vars;
		boolean[] bools;
		String[] dfsd;

		int[] vars1 = new int[10];
		boolean[] bools1 = new boolean[3];
		String[] dfsd1 = new String[60];

		int[] values = { 1, 2, 56, 786, 987, 453685, 54, 32426, 657, 653, 356 };
		double[] doubleVars = { 342, 5646, 45.654, 6587.6, 545.453, 655.4353, 45, 44234.435 };

//		ArraysClass.printArray(values);
//		System.out.println();
//		ArraysClass.printArrays(doubleVars);

//		System.out.println(Arrays.toString(values));
//		System.out.println(values[4]);
//		int[] values2 = { 1, 2, 56, 786, 987, 4223, 54, 32426, 657, 653, 356 };
//		values = values2;

		List<Integer> listVars = new ArrayList<>(Arrays.asList(43, 45, 54));
		List<Integer> intList = new ArrayList<>(Arrays.asList(43, 435, 4535, 45, 54, 6546546, 5465, 354));
//		List<Double> listvar2 = new ArrayList<>();
		List<String> stringList = new ArrayList<>(Arrays.asList("fdsaf", "dfsafsa", "dfsf"));
//		intList.add(634566);
//		intList.remove(1);
//		intList.removeAll(listVars);
//		System.out.println(intList);

//		ArraysClass.printSum(intList);
//		ArraysClass.printSum(listVars);

//		Collections.sort(intList);
		Collections.shuffle(intList);
//		System.out.println(intList);

		for (int i = 0; i < doubleVars.length; i++) {

			for (int j = 0; j < i; j++) {

				if (doubleVars[i] < doubleVars[j]) {

					double temp = doubleVars[i];
					doubleVars[i] = doubleVars[j];
					doubleVars[j] = temp;
				}
			}
		}

		for (int i = 0; i < values.length - 1; i++) {

			if (values[i] > values[i + 1]) {

				int temp = values[i];
				values[i] = values[i + 1];
				values[i + 1] = temp;

				i = -1;
			}
		}

//		Arrays.sort(doubleVars);
//		Arrays.sort(values);
		System.out.println(Arrays.toString(doubleVars));
		System.out.println(Arrays.toString(values));

	}

}
