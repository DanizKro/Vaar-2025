package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

	Film[] filmarkiv;
	private int antall;

	public Filmarkiv(int storrelse) {
		filmarkiv = new Film[storrelse];
		antall = 0;

	}
	
	public int getAntall() {
		return antall;
	}

	@Override
	public Film finnFilm(int nr) {

		for (int i = 0; i < antall; i++) {
			if (filmarkiv[i].getFilmnr() == nr) {
				return filmarkiv[i];
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {

		if (antall < filmarkiv.length) {
			filmarkiv[antall] = nyFilm;
			this.antall++;
		}

	}

	@Override
	public boolean slettFilm(int filmnr) {

		for (int i = 0; i < antall; i++) {
			if (filmarkiv[i].getFilmnr() == filmnr) {
				filmarkiv[i] = filmarkiv[antall - 1];
				filmarkiv[antall - 1] = null;
				antall--;
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {

		// Lager en tabell som er mer enn stor nok
		Film[] temp = new Film[antall];

		int teller = 0;

		for (int i = 0; i < antall; i++) {
			if (filmarkiv[i].getTittel().equalsIgnoreCase(delstreng)) {
				temp[0] = filmarkiv[i];
				teller++;
			}
		}
		// Lager da en ny tabell som er akkuratt like stor som antall filmer med samme
		// tittel, og bruker telleren som størrelse på tabell
		Film[] resultat = new Film[teller];

		for (int i = 0; i < teller; i++) {
			resultat[i] = temp[i];
		}

		return resultat;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {

		int teller = 0;

		// teller opp hvor stor tabellen må være for å få plass til alle med samme
		// produsent
		for (int i = 0; i < antall; i++) {
			if (filmarkiv[i].getProdusent().equalsIgnoreCase(delstreng)) {
				teller++;
			}
		}
		// lager en ny tabell som er akkuratt stor nok til å ta imot alle med samme
		// produsent
		Film[] sjangerTab = new Film[teller];

		// kopierer inn alle objektene med samme produsent i ny tabell
		for (int i = 0; i < antall; i++) {
			if (filmarkiv[i].getProdusent().equalsIgnoreCase(delstreng)) {
				sjangerTab[i] = filmarkiv[i];
			}
		}
		return sjangerTab;
	}

	@Override
	public int antall(Sjanger sjanger) {

		int teller = 0;

		for (int i = 0; i < antall; i++) {
			if (filmarkiv[i].getSjanger().equals(sjanger)) {
				teller++;
			}
		}
		return teller;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void utvid(Film[] film) {

		Film[] temp = new Film[film.length * 2];

		if (antall == film.length) {
			for (int i = 0; i < antall; i++) {
				temp[i] = film[i];
			}
			filmarkiv = temp;
		}

	}

}
