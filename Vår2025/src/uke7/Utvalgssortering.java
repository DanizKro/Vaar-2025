package uke7;

import java.time.*;
import java.util.Random;

public class Utvalgssortering {

	public static void main(String[] args) {

		Random tilfeldig = new Random(1000);
		int n = 10; // 32000 var forslag antall tall i hver tabell
		int antall = 5; // antall rader nedover

		Integer[][] a = new Integer[antall][n];
		// set inn tilfeldige heiltal i alle rekker
		for (int i = 0; i < antall; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = tilfeldig.nextInt(1000); // hvis man tar tom parameterliste er random tall fra -int long til
													// +int long.
			}
		}
		// start tidsmåling
		long start = System.currentTimeMillis();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				//sorter(a[i], a[i].length); // a[i] blir ein eindimensjonal tabell
				sorter(a[i], a[i].length);
			}
		}
		long slutt = System.currentTimeMillis();
		// slutt tidsmåling
		double tid = (slutt - start) / 1000;

		System.out.println("Det tok: " + tid + " sekunder");

		System.out.println("Sortert tabell: ");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

	}

	// --------------------------------------------------------------------------------------------------------------
	// Sotertings-algoritme Utvalgsortering;
	public static void sorter(Integer[] tab, int n) {

		for (int i = 0; i < n - 1; i++) {
			int indexOfNextSmallest = getIndexOfSmallest(tab, i, n - 1);
			swap(tab, i, indexOfNextSmallest);
		}
	}

	private static int getIndexOfSmallest(Integer[] tab, int start, int siste) {

		int min = tab[start];
		int posisjon = start;

		for (int i = start + 1; i <= siste; i++) {
			if (tab[i].compareTo(min) < 0) {
				min = tab[i];
				posisjon = i;
			}
		}
		return posisjon;
	}

	private static void swap(Integer[] tab, int i, int j) {

		int temp = tab[i];
		tab[i] = tab[j];
		tab[j] = temp;

	}

}
