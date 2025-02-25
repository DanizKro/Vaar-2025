package Sorting;

public class RadixSort {

	public static void main(String[] args) {

		int[] array = { 8, 2, 5, 7, 3, 6, 1, 4 };

		System.out.println("Tabell:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");

		radixSort(array);

		System.out.println("Sortert tabell:");
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	// LSD radixSort (LDS= least significant digit)
	// O-notasjon = O(n+k) best og worst
	public static void radixSort(int[] array) {
		if (array.length == 0) {
			return;
		}

		// Finn maksimalverdien for å vite antall sifre
		int max = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}

		// Sorter etter hvert siffer (1s, 10s, 100s, ...)
		for (int i = 1; max / i > 0; i *= 10) {
			countingSortByDigit(array, i);
		}
	}

	private static void countingSortByDigit(int[] array, int exp) {
		int[] output = new int[array.length];
		int[] count = new int[10];

		// Tell forekomsten av sifre i gitt posisjon (exp)
		for (int i = 0; i < array.length; i++) {
			int digit = (array[i] / exp) % 10;
			count[digit]++;
		}

		// Endre count slik at den inneholder posisjonene til sifrene i output
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		// Bygg output-arrayet ved å plassere elementene i riktig rekkefølge
		for (int i = array.length - 1; i >= 0; i--) {
			int digit = (array[i] / exp) % 10;
			output[count[digit] - 1] = array[i];
			count[digit]--;
		}

		// Kopier det sorterte output-arrayet tilbake til originalt array
		for (int i = 0; i < array.length; i++) {
			array[i] = output[i];
		}
	}

}
