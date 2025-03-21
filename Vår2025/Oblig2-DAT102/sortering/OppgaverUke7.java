package sortering;

import java.util.Random;

public class OppgaverUke7 {

	public static void main(String[] args) {

		Random tilfeldig = new Random(1000);
		int n = 30; // 32000 var forslag antall men alt for langt
		int antall = 1; // antall rader nedover

//		System.out.println("Sortert tabell: ");
//		for (int i = 0; i < a1.length; i++) {
//			for (int j = 0; j < a1[i].length; j++) {
//				System.out.print(a1[i][j] + " ");
//			}
//			System.out.println();
//		}

		// Tabell nummer 1
		Integer[][] a1 = new Integer[antall][n];
		// set inn tilfeldige heiltal i alle rekker
		for (int i = 0; i < antall; i++) {
			for (int j = 0; j < n; j++) {
				a1[i][j] = tilfeldig.nextInt(1000); // hvis man tar tom parameterliste er random tall fra -int long til
													// +int long.
			}
		}
		// Tabell nummer 2
		Integer[][] a2 = new Integer[antall][n];
		for (int i = 0; i < antall; i++) {
			for (int j = 0; j < n; j++) {
				a2[i][j] = tilfeldig.nextInt(1000);
			}
		}
		// Tabell nummer 3
		Integer[][] a3 = new Integer[antall][n];
		for (int i = 0; i < antall; i++) {
			for (int j = 0; j < n; j++) {
				a3[i][j] = tilfeldig.nextInt(1000);
			}
		}
		// Tabell nummer 4
		Integer[][] a4 = new Integer[antall][n];
		for (int i = 0; i < antall; i++) {
			for (int j = 0; j < n; j++) {
				a4[i][j] = tilfeldig.nextInt(1000);
			}
		}
		// Tabell nummer 5 - LIKE ELEMENTER
		Integer[][] sortertTabell = new Integer[antall][n];
		for (int i = 0; i < antall; i++) {
			for (int j = 0; j < n; j++) {
				sortertTabell[i][j] = 1;
			}
		}
		// ------------------------------------------
		// InsertionSort
		String insertion = "InsertionSort(O=n^2): ";
		long start = System.currentTimeMillis();
		for (int i = 0; i < a1.length; i++) {
			for (int j = 0; j < a1[i].length; j++) {
				insertionSort(a1[i], a1[i].length);
			}
		}
		long slutt = System.currentTimeMillis();
		double tid = (slutt - start) / 1000;
		// -------------------------------------------
		// Utvalgssortering
		String utvalgsSortering = "Utvalgssortering(O=n^2): ";
		long start2 = System.currentTimeMillis();
		for (int i = 0; i < a2.length; i++) {
			for (int j = 0; j < a2[i].length; j++) {
				utvalgsortering(a2[i], a2[i].length);
			}
		}
		long slutt2 = System.currentTimeMillis();
		double tid2 = (slutt2 - start2) / 1000;
		// -------------------------------------------
		// Quicksort
		String quickSort = "Quicksort(O=n*log(n)): ";
		long start3 = System.currentTimeMillis();
		for (int i = 0; i < a3.length; i++) {
			for (int j = 0; j < a3[i].length; j++) {
				kvikksorter(a3[i]);
			}
		}
		long slutt3 = System.currentTimeMillis();
		// slutt tidsmåling
		double tid3 = (slutt3 - start3) / 1000;
		// -------------------------------------------
		// Flettesortering
		String fletteSortering = "Flettesortering(O=n*log(n)): ";
		long start4 = System.currentTimeMillis();
		for (int i = 0; i < a4.length; i++) {
			for (int j = 0; j < a4[i].length; j++) {
				flettesortering(a4[i], a4[i].length);
			}
		}
		long slutt4 = System.currentTimeMillis();
		// slutt tidsmåling
		double tid4 = (slutt4 - start4) / 1000;
		
		// -------------------------------------------
		// Quicksort 2 på en tabell med like elementer >>>>>>>>>>>>>>
		String quickSort2 = "Quicksort(O=n*log(n)): ";
		long start5 = System.currentTimeMillis();
		for (int i = 0; i < sortertTabell.length; i++) {
			for (int j = 0; j < sortertTabell[i].length; j++) {
				kvikksorter(sortertTabell[i]);
			}
		}
		long slutt5 = System.currentTimeMillis();
		// slutt tidsmåling
		double tid5 = (slutt5 - start5) / 1000;
		// -----------------------------

		System.out.println(insertion + "\n" + "Antall rader"+ "["+antall+"] " + "n =" + "[" + n + "] " + "Tid: " + tid + " sekunder");
		System.out.println();
		System.out.println(utvalgsSortering + "\n" + "Antall rader"+ "["+antall+"] " + "n =" + "[" + n + "] " + "Tid: " + tid2 + " sekunder");
		System.out.println();
		System.out.println(quickSort + "\n" + "Antall rader"+ "["+antall+"] " + "n =" + "[" + n + "] " + "Tid: " + tid3 + " sekunder");
		System.out.println();
		System.out.println(fletteSortering + "\n" + "Antall rader"+ "["+antall+"] " + "n =" + "[" + n + "] " + "Tid: " + tid4 + " sekunder");
		System.out.println("");
		System.out.println("Quicksort med like elementer: ");
		System.out.println(quickSort2 + "\n" + "Antall rader" + "[" + antall + "] " + "n =" + "[" + n + "] " + "Tid: "
				+ tid5 + " sekunder");
	

	}

	// --------------------------------------------------------------------------------------------------------------

	// insertionSort
	public static void insertionSort(Integer[] a, int n) {

		for (int i = 1; i < n; i++) {
			int temp = a[i];
			int j = i - 1;

			while (j >= 0 && a[j] > temp) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = temp;
		}
	}

	// -------------------------------------------------------------------------------------------------------------
	// dobbelInsertionSort
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
		if (n - 1 % 2 != 0) {

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
	// --------------------------------------------------------------------------------------------------------------

	// Utvalgsortering;
	public static void utvalgsortering(Integer[] tab, int n) {
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
	// --------------------------------------------------------------------------------------------------------------

	// Kvikksortering
	public static void kvikksorter(Integer[] a) {
		kvikksorter(a, 0, a.length - 1);
		insertionSort(a, a.length);
	}

	private static final int MIN_GRENSE = 3;

	private static void kvikksorter(Integer[] a, int forste, int siste) {

		if (siste - forste + 1 < MIN_GRENSE) {
		} else {
			int delepunkt = partition(a, forste, siste);
			kvikksorter(a, forste, delepunkt - 1);
			kvikksorter(a, delepunkt + 1, siste);
		}
	}

	private static int partition(Integer[] a, int forste, int siste) {
		int midten = (forste + siste) / 2;

		sortFirstMiddleLast(a, forste, midten, siste);

		swap(a, midten, siste - 1);
		int pivotIndex = siste - 1;
		int pivotValue = a[pivotIndex];

		int fraVenstre = forste + 1;
		int fraHogre = siste - 2;

		boolean ferdig = false;
		while (!ferdig) {

			while (a[fraVenstre].compareTo(pivotValue) < 0) {
				fraVenstre++;
			}

			while (a[fraHogre].compareTo(pivotValue) > 0) {
				fraHogre--;
			}

			if (fraVenstre < fraHogre) {
				swap(a, fraVenstre, fraHogre);
				fraVenstre++;
				fraHogre--;
			} else {
				ferdig = true;
			}
		}
		swap(a, pivotIndex, fraVenstre);
		pivotIndex = fraVenstre;

		return pivotIndex;
	}

	private static void sortFirstMiddleLast(Integer[] a, int first, int mid, int last) {
		order(a, first, mid);
		order(a, mid, last);
		order(a, first, mid);
	}

	private static void order(Integer[] a, int i, int j) {
		if (a[i].compareTo(a[j]) > 0) {
			swap(a, i, j);
		}
	}

	public static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// --------------------------------------------------------------------------------------------------------------

	// Flettesorterings
	public static void flettesortering(Integer[] a, int n) {
		flettesortering(a, 0, n - 1);
	}

	// sorterer heile tabellen
	public static void flettesortering(Integer[] a) {
		flettesortering(a, 0, a.length - 1);
	}

	public static void flettesortering(Integer[] a, int first, int last) {

		Integer[] tempArray = new Integer[a.length];
		flettesortering(a, tempArray, first, last);
	}

	private static void flettesortering(Integer[] a, Integer[] tempTab, int forste, int siste) {

		if (forste >= siste) {
		} else {
			int midtpkt = (forste + siste) / 2;
			flettesortering(a, tempTab, forste, midtpkt);
			flettesortering(a, tempTab, midtpkt + 1, siste);
			flett(a, tempTab, forste, midtpkt, siste);
		}
	}

	private static void flett(Integer[] a, Integer[] tempTab, int forste, int midten, int siste) {

		int fV = forste;
		int sluttV = midten;
		int fH = midten + 1;
		int sluttH = siste;

		int index = fV;
		for (; (fV <= sluttV) && (fH <= sluttH); index++) {
			if (a[fV].compareTo(a[fH]) < 0) {
				tempTab[index] = a[fV];
				fV++;
			} else {
				tempTab[index] = a[fH];
				fH++;
			}
		}

		for (; fV <= sluttV; fV++, index++) {
			tempTab[index] = a[fV];
		}
		for (; fH <= sluttH; fH++, index++) {
			tempTab[index] = a[fH];
		}
		for (index = forste; index <= siste; index++) {
			a[index] = tempTab[index];
		}
	}

}
