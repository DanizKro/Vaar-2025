package Sorting;

public class Bubble {

	public static void main(String[] args) {

		int[] array = { 8, 2, 5, 7, 3, 6, 1, 4 };

		System.out.println("Tabell:");

		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("\n");

		bubbleSort(array);

		System.out.println("Sortert tabell:");
		for (int i : array) {
			System.out.print(i + " ");
			
		}
		
		String a = "";
		
		a += "s";
		a += "M";
		
		System.out.print(a);
		
		
	}

	private static void bubbleSort(int[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
}
