package Uke13;

import java.util.LinkedList;

public class SkiltLinkedList {

	private final int TABELL_STORRELSE = 10;
	private LinkedList<String>[] hashTabell;

	public SkiltLinkedList() {
		hashTabell = new LinkedList[TABELL_STORRELSE];
		for (int i = 0; i < TABELL_STORRELSE; i++) {
			hashTabell[i] = new LinkedList<String>();
		}
	}

	private int hash(String bilskilt) {
		bilskilt = bilskilt.trim();
		char sisteTegn = bilskilt.charAt(bilskilt.length() - 1);

		if (Character.isDigit(sisteTegn)) {
			int sisteSiffer = Character.getNumericValue(sisteTegn);
			return sisteSiffer % TABELL_STORRELSE;
		}
		return 0; 
	}
	
	public static int hash2(String bilskilt) {
    	
    	int hash = -1;
    	
    	hash = Math.abs(bilskilt.hashCode()%10);
    	
    	return hash;
    }

	public void leggTil(String bilskilt) {
		int pos = hash(bilskilt);
		hashTabell[pos].add(bilskilt); // Legger til på slutten av listen
	}
	
	public void leggTil2(String bilskilt) {
		int pos = Math.abs(hash2(bilskilt));
		hashTabell[pos].add(bilskilt); // Legger til på slutten av listen
	}

	public void skrivUtTabell() {
		for (int i = 0; i < TABELL_STORRELSE; i++) {
			System.out.print("Posisjon " + i + ": ");

			for (String e : hashTabell[i]) {
				System.out.print(e + " -> ");
			}
			// printer ut Null på slutten av en LenketListe fordi den peker ikke videre
			System.out.println("Null");
		}
	}
}