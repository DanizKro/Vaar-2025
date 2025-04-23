package uke15.Oppgave2og3;

import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		
		BS_Tre<Integer> t = new BS_Tre<>();
		
		// Legg til 7, 5, 9, 3, 0, 8. NB! fungerer ikkje før vi har laga leggTil-metoden
		
		t.leggTil(7);
		t.leggTil(5);
		t.leggTil(9);
		t.leggTil(3);
		t.leggTil(0);
		t.leggTil(8);
		
		/* Treet skal no sjå slik ut
		 * 
		 *           7
		 *          /  \
		 *         5    9
		 *        /    /
		 *       3    8
		 *      /
		 *     0
		 */
		
		// Dersom leggTil-metoden er laga korrekt skal elementa kome ut sortert
		// sidan vi brukar Inorden-iteratoren
		System.out.print("Innhold i treet (sortert): ");
		for (Integer e : t) {
			System.out.print(e + " " );
		}
		System.out.println();
		
		System.out.println("inneholder(3) skal gi true, svar: " + t.inneholder(3));
		System.out.println("inneholder(10) skal gi false, svar: " + t.inneholder(10));
		
		t.skrivVerdier(1, 6);
		System.out.println();
		t.skrivVerdierRek(1, 6);
		
	}
}
