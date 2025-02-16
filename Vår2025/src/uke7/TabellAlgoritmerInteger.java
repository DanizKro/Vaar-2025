package uke7;

import java.time.*;
import java.util.Random;

public class TabellAlgoritmerInteger {

	public static void main(String[] args) {
		
		Random tilfeldig = new Random(1000);
		int n = 25; 									//32000 var forslag antall tall i hver tabell
		int antall = 10;								 //antall rader nedover 
		
		Integer[][] a = new Integer[antall][n];
		// set inn tilfeldige heiltal i alle rekker
		for (int i = 0; i < antall; i++){
		for (int j = 0; j < n; j++){
		a[i][j] = tilfeldig.nextInt(1000);				//hvis man tar tom parameterliste er random tall fra -int long til +int long.
		}
		}
		// start tidsmåling
		for (int i = 0; i < a.length; i++){
			for(int j = 0; j < a[i].length; j++) {
				sorter(a[i], a[i].length); 				// a[i] blir ein eindimensjonal tabell
			}
		}
		// slutt tidsmåling
		
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j<a[i].length; j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
	}

	//sotertings-algoritme innsetting
	
	public static void sorter(Integer[] tab, int n) {
		
		for(int index = 0; index < n-1; index++) {
			
			int indexOfNextSmallest = getIndexOfSmallest(tab, index, n-1);
			swap(tab,index, indexOfNextSmallest);
		}
	}
	
	private static int getIndexOfSmallest(Integer[]a, int first, int last) {
		
		int min = a[first];
		int indexOfMin = first;
		for(int index = first+1; index <= last; index++) {
			if(a[index].compareTo(min) < 0){
				min = a[index];
				indexOfMin = index;
			}
		}
		return indexOfMin;
	}
	
private static void swap(Integer[] tab, int i, int j) {
		
	int temp = tab[i];
	tab[i] = tab[j];
	tab[j] = temp;
	
	}
	

}
