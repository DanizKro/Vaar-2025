package uke16;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Oppgave1 {

	public static void main(String[] args) {
		
		int[] tabell = {1,5,7,2,9,7,3,4};
		
		int sjekk = 3;
		
		
		System.out.print("QuickSort:     ");
		int[] minste = minsteQuickSort(tabell, sjekk);
		for(int e : minste) {
			System.out.print(e);
		} System.out.println();
		
		
		System.out.print("SelectionSort: ");
		int[] minste2 = minsteSelectionSort(tabell, sjekk);
		for(int e : minste2) {
			System.out.print(e);
		} System.out.println();
		
		System.out.print("InsertionSort: ");
		int[] minste3 = minsteInsertionSort(tabell, sjekk);
		for(int e : minste3) {
			System.out.print(e);
		} System.out.println();
		
		
		System.out.print("HeapSort:      ");
		PriorityQueue<Integer> tab = minsteHeapSort(tabell, sjekk);
		
		while (!tab.isEmpty()) {
		    System.out.print(tab.remove());
		} System.out.println();
		
		
		
	}

	// **************** QuickSort ***********************
	public static int[] minsteQuickSort(int[] tabell, int k) {
		
		int[] minst = new int[k];

		// Fyller Minste tabellen med antall verdier ønsket
		for (int i = 0; i < k; i++) {
			minst[i] = tabell[i];
		}
		// Sorterer tabellen
		quickSort(minst);

		// Går igjennom tabllen og sjekket om neste verdi er mindre en siste i
		// minste-tabellen
		for (int i = k; i < tabell.length; i++) {
			if (tabell[i] < minst[k - 1]) {
				minst[k - 1] = tabell[i];
				quickSort(minst);
			}
		}

		return minst;
		
	}
	
	
	// **************** SelectionSort ***********************
	public static int[] minsteSelectionSort(int[] tabell, int k) {

		int[] minst = new int[k];

		// Fyller Minste tabellen med antall verdier ønsket
		for (int i = 0; i < k; i++) {
			minst[i] = tabell[i];
		}
		// Sorterer tabellen
		selectionSort(minst);

		// Går igjennom tabllen og sjekket om neste verdi er mindre en siste i
		// minste-tabellen - STARTEN er fra K - fordi vi har allerede kopiert inn K elementer og sortert de.
		for (int i = k; i < tabell.length; i++) {
	        if (tabell[i] < minst[k - 1]) {
	            minst[k - 1] = tabell[i];
	            selectionSort(minst);
	        }
	    }

		return minst;
	}

	// **************** InsertionSort ***********************
	public static int[] minsteInsertionSort(int[] tabell, int k) {

		int[] minst = new int[k];

		// Fyller Minste tabellen med antall verdier ønsket
		for (int i = 0; i < k; i++) {
			minst[i] = tabell[i];
		}
		// Sorterer tabellen
		insertionSort(minst);

		// Går igjennom tabllen og sjekket om neste verdi er mindre en siste i
		// minste-tabellen
		for (int i = k; i < tabell.length; i++) {
			if (tabell[i] < minst[k - 1]) {
				minst[k - 1] = tabell[i];
				insertionSort(minst);
			}
		}

		return minst;
	}
	// **************** HeapSort ***********************
	// Bruker java sin innbygget klasse for minimums HEAP
	public static PriorityQueue<Integer> minsteHeapSort(int[] tabell, int k) {
		
		//Max-heap største elementet ligger på toppen for å sjekke. - > bruker Comparator.reverseOrder() fordi PriorityQueue er defult min-heap.
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		
		for(int i = 0 ; i < k; i++) {
			maxHeap.add(tabell[i]);
		}
		
		for(int i = k; i < tabell.length; i++) {
			if(tabell[i] < maxHeap.peek()) {
				maxHeap.remove(maxHeap.peek());
				maxHeap.add(tabell[i]);
			}
		}
		
		//Legger det så over til en minimums-heap og returnerer
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		while (!maxHeap.isEmpty()) {
		    minHeap.add(maxHeap.remove());
		}
		
		return minHeap;
		
	}

	public static void insertionSort(int[] tabell) {

		for (int i = 0; i < tabell.length; i++) {
			int temp = tabell[i];
			int j = i - 1;

			while (j >= 0 && tabell[j] > temp) { 
				tabell[j + 1] = tabell[j];
				j--;
			}

			tabell[j + 1] = temp;
		}
	}

	private static void selectionSort(int[] tab) {

		for (int i = 0; i < tab.length; i++) {

			int minste = tab[i];
			int index = i;

			for (int j = i + 1; j < tab.length; j++) {

				if (tab[j] < minste) {
					minste = tab[j];
					index = j;
				}

			}
			int temp = tab[index];
			tab[index] = tab[i];
			tab[i] = temp;
		}

	}
	
	public static void quickSort(int[] tabell) {
		quickSort(tabell, 0, tabell.length-1);
	}
	
	public static void quickSort(int[] tabell, int start, int end) {
		
		//Basetilfelle
		if(start >= end) {
			return;
		}
		
		int pivot = partition(tabell, start, end);
		quickSort(tabell, start, pivot-1);
		quickSort(tabell, pivot+1, end);
	}
	
	public static int partition(int[] tabell, int start, int end) {
	    int pivot = tabell[end];
	    int i = start - 1;

	    for (int j = start; j < end; j++) {
	        if (tabell[j] < pivot) {
	            i++;
	            int temp = tabell[i];
	            tabell[i] = tabell[j];
	            tabell[j] = temp;
	        }
	    }
	    i++;
	    int temp = tabell[i];
	    tabell[i] = tabell[end];
	    tabell[end] = temp;

	    return i;
	}
	
	

}
