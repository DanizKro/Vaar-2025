package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	
	private int antall =0;
	private LinearNode<Film> start;
	
	public Filmarkiv2() {
        this.start = null;
        this.antall = 0;
    }

	@Override
    public Film finnFilm(int nr) {
		
        LinearNode<Film> sok = start;

        while (sok != null) {
            if (sok.data.getFilmnr() == nr) {
                return sok.data;
            }
            sok = sok.neste;
        }
        return null;
    }


	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
		nyNode.neste = start;							//Får den nye noden sin neste peker til å peke på første node i linjen (slik at nye noden kommer først i rekken)
		start = nyNode;									//Setter den nye starten til å være den nye noden som er lagt til
		antall++;
		
	}

	@Override
	public boolean slettFilm(int filmnr) {
		
		if(start == null) {							//Sjekker om noden er tom
			return false;
		}
		if(start.data.getFilmnr() == filmnr) {		//Hvis noden bare har 1 element, sjekker den om det er lik filmnr og sletter
			start = start.neste;
			antall--;
			return true;
		}
		
		LinearNode<Film> forrige = start;
		LinearNode<Film> aktuell = start.neste;
		
 		boolean slettet = false;
		
		while (aktuell != null) {						//Går igjennom node-linken og sjekker hver node for filmnr
            if (aktuell.data.getFilmnr() == filmnr) {
                forrige.neste = aktuell.neste;
                antall--;
                return true;
            }
            forrige = aktuell;
            aktuell = aktuell.neste;
        }
		return slettet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		
		Film[] funnetTab = new Film[antall];
		int index = 0;
		
		LinearNode<Film> sok = start;
		
		while(sok != null) {
			if(sok.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				funnetTab[index] = sok.data;
				index++;
			} sok = sok.neste;
		}
		
		//Reduserer funnetTab sin nullpekere
		Film[] trimmet = new Film[index];
		
		for(int i = 0; i < trimmet.length; i++) {
			trimmet[i] = funnetTab[i];
		}
		
		return trimmet;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		
		Film[] funnetTab = new Film[antall];
		int index = 0;
		
		LinearNode<Film> sok = start;
		
		while(sok != null) {
			if(sok.data.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				funnetTab[index] = sok.data;
				index++;
			} sok = sok.neste;
		}
		
		//Reduserer funnetTab sin nullpekere
		Film[] trimmet = new Film[index];
		
		for(int i = 0; i < trimmet.length; i++) {
			trimmet[i] = funnetTab[i];
		}
		
		return trimmet;
	}

	@Override
	public int antallSjanger(Sjanger sjanger) {
		
		if(start == null) {							//Sjekker om noden er tom
			return 0;
		}
		if(start.data.getSjanger() == sjanger) {		//Hvis noden bare har 1 element, sjekker den om det er lik filmnr og sletter
			return 1;
		}
		
		int teller = 0;
		
		LinearNode<Film> sok = start;
		
		while(sok != null) {
			if(sok.data.getSjanger().equals(sjanger)) {
				teller++;
			}	
			sok = sok.neste;
		}

		return teller;
	}

	@Override
	public int getAntall() {
		
		return antall;
	}
	

}
