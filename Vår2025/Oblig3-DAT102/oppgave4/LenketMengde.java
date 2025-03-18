package oppgave4;

import java.util.ArrayList;

public class LenketMengde<T> implements MengdeADT<T> {

	/************************************************************/
	private class Node {

		private T data;
		private Node neste;

		private Node(T data) {
			this.data = data;
			this.neste = null;
		}
	}

	/************************************************************/

	private Node forste;
	private int antall;

	public LenketMengde() {
		forste = null;
		antall = 0;
	}

	@Override
	public boolean erTom() {
		return forste == null;
	}

	@Override
	public boolean inneholder(T element) {

		Node temp = forste;

		while (temp != null) {
			if (temp.data.equals(element)) {
				return true;
			}
			temp = temp.neste;
		}
		return false;
	}

	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {

		Node temp = forste;

		if (antall < annenMengde.antallElementer()) { // En delmengde må være mindre enn en mengde for å være delmengde.
														// Sparer søk
			while (temp != null) {
				if (!annenMengde.inneholder(temp.data)) {
					return false;
				}
				temp = temp.neste;
			}
		}
		return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {

		if (antall != annenMengde.antallElementer()) {
			return false; // Mengdene kan ikke være like hvis de har ulik størrelse
		}
		Node temp = forste;

		while (temp != null) {
			if (!annenMengde.inneholder(temp.data)) {
				return false;
			}
			temp = temp.neste;
		}
		return true;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {

		Node temp = forste;

		while (temp != null) {
			if (annenMengde.inneholder(temp.data)) {
				return false;
			}
			temp = temp.neste;
		}

		return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {

		MengdeADT<T> snitt = new LenketMengde<>();
		Node temp = forste;

		while (temp != null) {
			if (annenMengde.inneholder(temp.data)) {
				snitt.leggTil(temp.data);
			}
			temp = temp.neste;
		}

		return snitt;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {

		MengdeADT<T> union = new LenketMengde<>();

		Node temp = forste;

		while (temp != null) {
			union.leggTil(temp.data);
			temp = temp.neste;
		}

		T[] tab = annenMengde.tilTabell();

		for (int i = 0; i < tab.length; i++) {
			union.leggTil(tab[i]);
		}

		return union;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {

		MengdeADT minus = new LenketMengde<>();

		Node temp = forste;

		while (temp != null) {
			if (!annenMengde.inneholder(temp.data)) {
				minus.leggTil(temp.data);
			}
			temp = temp.neste;
		}

		return minus;
	}

	@Override
	public void leggTil(T element) {

		// Sjekker om elementet inneholder i mengden fra før
		Node temp = forste;
		while (temp != null) {
			if (temp.data == element) {
				throw new IllegalArgumentException("Elementet inneholder i mengden fra før");
			}
			temp = temp.neste;
		}

		Node ny = new Node(element);

		if (antall == 0) {
			forste = ny;
			antall++;
		} else {
			ny.neste = forste;
			forste = ny;
			antall++;
		}

	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {

		Node temp = forste;

		T[] tab = annenMengde.tilTabell();

		int index = 0;

		for (int i = 0; i < tab.length; i++) {
			if (!this.inneholder(tab[i])) { // Hvis elementet finnes True, blir den omgjort til False, og elemenetet
											// legges IKKE til
				this.leggTil(tab[i]);
			}
		}

	}

	@Override
	public T fjern(T element) {

		Node temp = forste;

		// basis
		if (temp.data.equals(element)) {
			T data = forste.data;
			forste = forste.neste;
			antall--;
			return data;
		}

		// Søker etter elementet i resten av listen
		while (temp.neste != null) {
			if (temp.neste.data.equals(element)) {
				T data = temp.neste.data;
				temp.neste = temp.neste.neste; // Hopper over noden som fjernes
				antall--; // Oppdaterer antallet
				return data;
			}
			temp = temp.neste;
		}

		return null;
	}

	@Override
	public T[] tilTabell() {

		@SuppressWarnings("unchecked")
		T[] tab = (T[]) new Object[antall];

		Node temp = forste;
		int index = 0;

		while (temp != null) {
			tab[index] = temp.data;
			temp = temp.neste;
			index++;
		}

		return tab;
	}

	@Override
	public int antallElementer() {
		return antall;
	}

}
