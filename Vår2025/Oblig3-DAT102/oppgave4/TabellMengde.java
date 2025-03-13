package oppgave4;

import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT {

	private static final int DEFAULT_KAPASITET = 10;

	private T[] tabell;
	private int antall;

	/************************************************************/

	public TabellMengde() {
		this(DEFAULT_KAPASITET);
	}

	@SuppressWarnings("unchecked")
	public TabellMengde(int kapasitet) {
		tabell = (T[]) new Object[kapasitet];
		antall = 0;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public boolean inneholder(Object element) {
		if (erTom()) {
			return false;
		}
		for (int i = 0; i < antall; i++) {
			if (tabell[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT annenMengde) {

		for (int i = 0; i < antall; i++) {
			if (!annenMengde.inneholder(tabell[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean erLik(MengdeADT annenMengde) {

		int teller = 0;

		for (int i = 0; i < antall; i++) {
			if (annenMengde.inneholder(tabell[i])) {
				teller++;
			}
			if (teller == antall) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean erDisjunkt(MengdeADT annenMengde) {

		for (int i = 0; i < antall; i++) {
			if (annenMengde.inneholder(tabell[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADT snitt(MengdeADT annenMengde) {

		TabellMengde<T> snitt = (TabellMengde<T>) new TabellMengde<>();

		for (int i = 0; i < antall; i++) {
			if (annenMengde.inneholder(tabell[i])) {
				snitt.leggTil(tabell[i]);
			}
		}

		return snitt;
	}

	@Override
	public MengdeADT union(MengdeADT annenMengde) {

		TabellMengde<T> union = (TabellMengde<T>) new TabellMengde<>();
		Object[] mengde = annenMengde.tilTabell();
		
		//først legge til tabell
		for(int i = 0; i < antall; i++) {
			union.leggTil(tabell[i]);
		}
		//legger til tabellen som skal være i union
	    for (int i = 0; i < mengde.length; i++) {
	        if (!union.inneholder(mengde[i])) { //sjekker for duplikater
	            union.leggTil((T) mengde[i]);
	        }
	    }

		return union;
	}

	@Override
	public MengdeADT minus(MengdeADT annenMengde) {
		
		MengdeADT<T> mengdeDifferanse = new TabellMengde<>();
		
		//legger til alle elementer fra første tabell som IKKE er felles elementer
		for(int i = 0; i < antall; i++) {
			
			if(!annenMengde.inneholder(tabell[i])) {
				mengdeDifferanse.leggTil(tabell[i]);
			}
		}
		
		return mengdeDifferanse;
	}

	@Override
	public void leggTil(Object element) {

		if (antall == tabell.length) {
			utvid();
		}
		tabell[antall] = (T) element;
		this.antall++;

	}

	@Override
	public void leggTilAlleFra(MengdeADT annenMengde) {

		Object[] tab = annenMengde.tilTabell();

		if (antall + tab.length > tabell.length) {
			utvid();
		}
		for (int i = 0; i < tab.length; i++) {
			tabell[antall + i] = (T) tab[i];
		}
		antall += annenMengde.antallElementer();
		
		// Kan også bruke den under: fordi annenMengde.tilTabell() tar bare med elementer som
		// faktisk er i tabellen
		
//		antall += tab.length;
	}

	@Override
	public Object fjern(Object element) {

		for (int i = 0; i < antall; i++) {

			if (tabell[i] != null && tabell[i].equals(element)) {

				Object fjernetElement = tabell[i];
				tabell[i] = tabell[antall - 1];
				tabell[antall - 1] = null;
				antall--;

				return fjernetElement;
			}
		}
		return null;
	}

	@Override
	public Object[] tilTabell() {

		Object[] tab = new Object[antall];

		for (int i = 0; i < tab.length; i++) {
			tab[i] = tabell[i];
		}
		return tab;
		
		//eventuelt bruke innebygget Arrays.copyOf fra Java:
//		return Arrays.copyOf(tabell, antall);
	}

	@Override
	public int antallElementer() {
		return antall;
	}

	private void utvid() {

		int kap = antall * 2;

		T[] nyTabell = (T[]) new Object[kap];

		for (int i = 0; i < kap; i++) {
			nyTabell[i] = tabell[i];
		}

		tabell = nyTabell;
	}

}
