package Uke13;

import java.util.Hashtable;

public class NummerSkilt<K,V> {

	
	private int antallElement;

	// Bør vere primtall (og aldri et jevnt tall)
	private static final int STANDARD_KAPASITET = 17;

	// Hashtabellen
	private NummerSkilt<K, V>[] hashTabell;
	private int tabellStorrelse;
	private static final double MAKS_FYLLINGSGRAD = 0.5;

	public NummerSkilt() {
		this(STANDARD_KAPASITET);
		
		Hashtable<Integer, String> h;
	}

	public NummerSkilt(int startKapasitet) {
		startKapasitet = sjekkKapasitet(startKapasitet);
		antallElement = 0;
		tabellStorrelse = finnNestePrimtall(startKapasitet);

		@SuppressWarnings("unchecked")
		NummerSkilt<K, V>[] temp = (NummerSkilt<K, V>[]) new NummerSkilt[tabellStorrelse];
		hashTabell = temp;
	}
	private int sjekkKapasitet(int kapasitet) {
		if (kapasitet < STANDARD_KAPASITET) {
			kapasitet = STANDARD_KAPASITET;
		}

		return kapasitet;
	}
	
	private int finnNestePrimtall(int t) {
		int p = t;
		if (p % 2 == 0) { // p er et jevnt tall
			p++;
		}

		while (!erPrimtall(p)) {
			p += 2;
		}

		return p;
	}
	private boolean erPrimtall(int t) {
		if (t % 2 == 0) {
			return t == 2;
		}

		if (t < 2) {
			return false;
		}

		int kvadratrot = (int) Math.sqrt(t);
		boolean primtall = true;
		int faktor = 3;

		while (primtall && faktor <= kvadratrot) {
			primtall = t % faktor != 0;
			faktor += 2;
		}

		return primtall;
	}
}
