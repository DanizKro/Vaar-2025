package uke7;

import java.util.Random;

public class Insettingssortering {

	public static void main(String[] args) {
		
		Random tilfeldig = new Random(1000);
		int n = 100; // 32000 var forslag antall tall i hver tabell
		int antall = 10; // antall rader nedover

		Integer[][] a1 = new Integer[antall][n];
		// set inn tilfeldige heiltal i alle rekker
		for (int i = 0; i < antall; i++) {
			for (int j = 0; j < n; j++) {
				a1[i][j] = tilfeldig.nextInt(1000); // hvis man tar tom parameterliste er random tall fra -int long til
													// +int long.
			}
		}
		
		// start tidsmåling
				long start = System.currentTimeMillis();
				for (int i = 0; i < a1.length; i++) {
					for (int j = 0; j < a1[i].length; j++) {
//						sorterTab(a1[i], a1[i].length); // a[i] blir ein eindimensjonal tabell
						insertionSort(a1[i]);
					}
				}
				long slutt = System.currentTimeMillis();
				// slutt tidsmåling
				double tid = (slutt - start) / 1000;

				System.out.println("Det tok: " + tid + " sekunder");

				System.out.println("Sortert tabell: ");
				for (int i = 0; i < a1.length; i++) {
					for (int j = 0; j < a1[i].length; j++) {
						System.out.print(a1[i][j] + " ");
					}
					System.out.println();
				}
	}
	
//	private static <T extends Comparable<? super T>> void sorterTab(T[] tab, int n) {
//		
//		
//		}
	
	public static void insertionSort(Integer[] a) {
		
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }
	
//	public static void doubleInsertionSort(int[] a) {
//        for (int i = 1; i < a.length - 1; i += 2) {
//            int first = a[i];
//            int second = a[i + 1];
//            
//            // Identifiser minste og største
//            int min, max;
//            if (first <= second) {
//                min = first;
//                max = second;
//            } else {
//                min = second;
//                max = first;
//            }
//            
//            // Sett inn det største først
//            int j = i - 1;
//            while (j >= 0 && a[j] > max) {
//                a[j + 2] = a[j]; // Flytt element to plasser til høyre
//                j--;
//            }
//            a[j + 2] = max; // Sett inn det største på riktig plass
//            
//            // Sett deretter inn det minste
//            while (j >= 0 && a[j] > min) {
//                a[j + 1] = a[j]; // Flytt element én plass til høyre
//                j--;
//            }
//            a[j + 1] = min; // Sett inn det minste på riktig plass
//        }
//        
//        // Hvis antall elementer er odde, sorter det siste elementet
//        if (a.length % 2 != 0) {
//            int temp = a[a.length - 1];
//            int j = a.length - 2;
//            while (j >= 0 && a[j] > temp) {
//                a[j + 1] = a[j];
//                j--;
//            }
//            a[j + 1] = temp;
//        }
//    }
//	
	

		
	}
