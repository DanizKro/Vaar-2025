package uke7.Sortering;

import java.util.Random;

public class RadixSortering {

	public static void main(String[] args) {

		Random tilfeldig = new Random(1000);
		int n = 30000; // 32000 var forslag antall men alt for langt
		int antall = 1; // antall rader nedover

//		System.out.println("Sortert tabell: ");
//		for (int i = 0; i < a1.length; i++) {
//			for (int j = 0; j < a1[i].length; j++) {
//				System.out.print(a1[i][j] + " ");
//			}
//			System.out.println();
//		}

		// Tabell nummer 1
		int[][] a1 = new int[antall][n];
		// set inn tilfeldige heiltal i alle rekker
		for (int i = 0; i < antall; i++) {
			for (int j = 0; j < n; j++) {
				a1[i][j] = tilfeldig.nextInt(1000); // hvis man tar tom parameterliste er random tall fra -int long til
													// +int long.
			}
		}

		// Radix Sortering
		String radix = "Radix Sortering(O=n*k): ";
		long start = System.currentTimeMillis();
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a1[i].length; j++) {
				radixSort(a1[i]);
			}
		}
		long slutt = System.currentTimeMillis();
		double tid = (slutt - start) / 1000;
		
		System.out.println(radix + "\n" + "Antall rader" + "[" + antall + "] " + "n =" + "[" + n + "] " + "Tid: "
				+ tid + " sekunder");

	}
	// --------------------------------------------------------------------------------------------------------------
	// Hovedmetode for Radix Sort
	public static void radixSort(int[] tab) {
		int max = getMax(tab); // Finn det største tallet for å vite antall sifre

		// Sorter basert på hver sifferposisjon (1-er, 10-er, 100-er, ...)
		for (int exp = 1; max / exp > 0; exp *= 10) {
			countingSort(tab, exp);
		}
	}

	// Hjelpemetode for å finne det største tallet i arrayet
	private static int getMax(int[] tab) {
		int max = tab[0];
		for (int num : tab) {
			if (num > max) {
				max = num;
			}
		}
		return max;
	}

	// Counting Sort som sorterer basert på et bestemt siffer (exp)
	private static void countingSort(int[] tab, int exp) {
		
		int[] output = new int[tab.length]; // Midlertidig array for sortering
		int[] count = new int[10]; // Teller array for sifrene 0-9

		// Tell forekomsten av hvert siffer på nåværende eksponentplass
		for (int i = 0; i < tab.length; i++) {
			int index = (tab[i] / exp) % 10;
			count[index]++;
		}

		// Transformér count-arrayet til kumulativ sum
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		// Bygg det sorterte output-arrayet
		for (int i = tab.length - 1; i >= 0; i--) {
			int index = (tab[i] / exp) % 10;
			output[count[index] - 1] = tab[i];
			count[index]--;
		}

		// Kopier det sorterte resultatet tilbake til original-arrayet
		System.arraycopy(output, 0, tab, 0, tab.length);
	}
}
