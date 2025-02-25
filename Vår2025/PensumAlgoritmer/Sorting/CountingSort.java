package Sorting;

import java.util.Arrays;

public class CountingSort {

	// https://www.youtube.com/watch?v=OKd534EWcdk&ab_channel=CSDojo

	public static void main(String[] args) {

		int[] array = { 4, 2, 10, 8, 7, 14, 1 };

		System.out.println("Før sortering: " + Arrays.toString(array));

		countingSort(array);

		System.out.println("Etter sortering: " + Arrays.toString(array));
	}

	// O-notasjon = O(n+k)
	public static void countingSort(int[] array) {

		if (array.length == 0) {
			return;
		}

		// finn minst og største verdi i arrayet
		int min = 0;
		int max = 0;

		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
			if (array[i] > max) {
				max = array[i];
			}
		}

		int range = max - min + 1;

		// Opprett en tabell for å holde styr på antall forekomster
		int[] count = new int[range];
		for (int i = 0; i < array.length; i++) {
			count[array[i] - min]++;
		}

		// Fyll det originale arrayet med de sorterte verdiene
		int index = 0;
		for (int i = 0; i < range; i++) {
			for (int j = 0; j < count[i]; j++) {
				array[index] = i + min;
				index++;
			}
		}
	}

}
