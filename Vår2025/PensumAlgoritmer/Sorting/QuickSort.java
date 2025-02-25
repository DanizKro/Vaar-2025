package Sorting;

public class QuickSort {
	
	// https://www.youtube.com/watch?v=Vtckgz38QHs

	public static void main(String[] args) {

		int[] array = { 8, 2, 5, 7, 3, 6, 1, 4 };

		System.out.println("Tabell:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");

		quickSort(array, 0, array.length - 1);

		System.out.println("Sortert tabell:");
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	// O-notasjon = O(n log n) best case
	// worst case = O(n^2)
	private static void quickSort(int[] array, int start, int end) {

		// Basecase
		if (end <= start)
			return;

		int pivot = partition(array, start, end);

		quickSort(array, start, pivot - 1);
		quickSort(array, pivot + 1, end);

	}

	private static int partition(int[] array, int start, int end) {

		int pivot = array[end];
		int i = start - 1;

		for (int j = start; j <= end - 1; j++) {
			if (array[j] < pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		i++;
		int temp = array[i];
		array[i] = array[end];
		array[end] = temp;

		return i;
	}

}
