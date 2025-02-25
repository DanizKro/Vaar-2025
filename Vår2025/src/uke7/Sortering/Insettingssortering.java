package uke7.Sortering;

import java.util.Random;

public class Insettingssortering {

	public static void main(String[] args) {

		Random tilfeldig = new Random(1000);
		int n = 15; // 32000 var forslag antall tall i hver tabell
		int antall = 4; // antall rader nedover

		Integer[][] a1 = new Integer[antall][n];
		// set inn tilfeldige heiltal i alle rekker
		for (int i = 0; i < antall; i++) {
			for (int j = 0; j < n; j++) {
				a1[i][j] = tilfeldig.nextInt(1000); // hvis man tar tom parameterliste er random tall fra -int long til
													// +int long.
			}
		}

		System.out.println("Usortert tabell: ");
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a1[i].length; j++) {
				System.out.print(a1[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();

		// start tidsmåling
		long start = System.currentTimeMillis();
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a1[i].length; j++) {
				//dobbelInsertionSort(a1[i], a1[i].length);
				insertionSort(a1[i], a1[i].length);
			}
		}
		long slutt = System.currentTimeMillis();
		// slutt tidsmåling
		double tid = (slutt - start) / 1000;

		System.out.println("Sortert tabell: ");
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a1[i].length; j++) {
				System.out.print(a1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("Det tok: " + tid + " sekunder");
	}

	// --------------------------------------------------------------------------------------------------------------

	public static void insertionSort(Integer[] tab, int n) {

		for (int i = 1; i < n; i++) {
			int temp = tab[i];
			int j = i - 1;

			while (j >= 0 && tab[j] > temp) {
				tab[j + 1] = tab[j];
				j--;
			}
			tab[j + 1] = temp;
		}
	}
	// --------------------------------------------------------------------------------------------------------------
	
	public static void dobbelInsertionSort(Integer[] tab, int n) {

		for (int i = 1; i < n - 1; i += 2) {
			int min_temp = tab[i];
			int maks_temp = tab[i + 1];

			if (min_temp > maks_temp) {
				int temp = min_temp;
				min_temp = maks_temp;
				maks_temp = temp;
			}

			int j = i - 1;

			while (j >= 0 && tab[j] >= maks_temp) {//
				tab[j + 2] = tab[j];
				j--;
			}
			tab[j + 2] = maks_temp;

			while (j >= 0 && tab[j] >= min_temp) {
				tab[j + 1] = tab[j];
				j--;
			}
			tab[j + 1] = min_temp;
		}

		// Hvis tabellen er partall lang, slår innsetting av site element til - siden
		// indexen i første for-løkke begynner på 1!
		if (n-1 % 2 != 0) {
			int k = tab.length;
			boolean swapped;

			for (int i = 0; i < k - 1; i++) {
				swapped = false;

				for (int j = 0; j < k - 1 - i; j++) {
					if (tab[j] > tab[j + 1]) {
						int temp = tab[j];
						tab[j] = tab[j + 1];
						tab[j + 1] = temp;
						swapped = true;
					}
				}
				if (!swapped) {
					break;
				}
			}

		}
	}
}
