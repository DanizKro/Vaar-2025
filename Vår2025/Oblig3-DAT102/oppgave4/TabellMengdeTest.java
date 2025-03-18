package oppgave4;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TabellMengdeTest {
	
	private TabellMengde<Integer> mengde;
	private TabellMengde<Integer> mengde2;

	@BeforeEach
	void setUp() {
		mengde = new TabellMengde<>(5);
		mengde2 = new TabellMengde<>(5);
		
	}
	/**
	 * @return Om mengden er tom
	 */
	@Test
	void erTom() {
		
		
		assertTrue(mengde.erTom());
		mengde.leggTil(5);
		assertFalse(mengde.erTom());
	}
	
	/**
	 * @param element
	 * @return Om mengden inneholder element
	 */
	@Test
	void inneholder() {
		
		mengde.leggTil(10);
		assertTrue(mengde.inneholder(10));
		
	}
	
	/**
	 * @param annenMengde
	 * @return Om mengden er en delmengde av en annenMengde
	 */
	@Test
	void erDelmengdeAv() {
		
		mengde.leggTil(2);
		mengde2.leggTil(4);
		mengde2.leggTil(2);
		
		assertTrue(mengde2.erDelmengdeAv(mengde));
		//Hvis parameter i metoden har har flere elementer enn mengden vi sammenligner med, kan det ikke være en delmengde
		assertFalse(mengde.erDelmengdeAv(mengde2));
		
		
	}
	
	/**
	 * @param annenMengde
	 * @return Om mengden er lik en annenMengde
	 */
	@Test
	void erLik() {
		
		mengde.leggTil(2);
		mengde.leggTil(4);
		mengde2.leggTil(4);
		mengde2.leggTil(2);
		
		assertTrue(mengde.erLik(mengde2));
		//legger til et element som skal gi false
		mengde.leggTil(5);
		assertFalse(mengde.erLik(mengde2));
	}
	
	/**
	 * @param annenMengde
	 * @return Om mengden og en annenMengde er disjunkte
	 */
	@Test
	void erDisjunkt() {
		
		mengde.leggTil(1);
		mengde.leggTil(2);
		mengde2.leggTil(3);
		mengde2.leggTil(4);
		
		assertTrue(mengde.erDisjunkt(mengde2));
		//Legger til et felles element, da skal de ikke være forskjellige/disjukte
		mengde.leggTil(3);
		assertFalse(mengde.erDisjunkt(mengde2));
		
		
	}
	
	/**
	 * @param annenMengde
	 * @return Snittet av mengden og en annenMengde.
	 *         Metoden skal ikke endre på mengden eller annenMengde,
	 *         men lage en ny mengde som blir resultatet.
	 */
	@Test
	void snitt() {
		
		mengde.leggTil(1);
		mengde.leggTil(2);
		
		mengde2.leggTil(3);
		mengde2.leggTil(4);
		mengde2.leggTil(2);
		
		TabellMengde<Integer> snitt = (TabellMengde<Integer>) mengde.snitt(mengde2);
		assertEquals(1, snitt.antallElementer());
		
		mengde.leggTil(3);
		TabellMengde<Integer> snitt2 = (TabellMengde<Integer>) mengde.snitt(mengde2);
		assertTrue(snitt2.inneholder(2));
		assertTrue(snitt2.inneholder(3));
		assertEquals(2, snitt2.antallElementer());
		
		
	}
	
	/**
	 * @param annenMengde
	 * @return Unionen av mengden og en annenMengde.
	 *         Metoden skal ikke endre på mengden eller annenMengde,
	 *         men lage en ny mengde som blir resultatet.
	 */
	@Test
	void union(){
		
		mengde.leggTil(1);
		mengde.leggTil(2);
		
		mengde2.leggTil(3);
		mengde2.leggTil(4);
		
		TabellMengde<Integer> union = (TabellMengde<Integer>) mengde.union(mengde2);
		
		assertTrue(union.inneholder(1));
		assertTrue(union.inneholder(3));
		assertTrue(union.inneholder(4));
		
		
	
		
	}
	
	/**
	 * @param annenMengde
	 * @return Mengden minus annenMengde.
	 *         Metoden skal ikke endre på mengden eller annenMengde,
	 *         men lage en ny mengde som blir resultatet.
	 */
	@Test
	void minus(){
		
		// NB! Fungerer bare om de har et felles element, om begge er ulik, fungerer ikke metoden...
		
		mengde.leggTil(1);
		mengde.leggTil(2);
		mengde.leggTil(3);
		
		mengde2.leggTil(4);
		mengde2.leggTil(3);
		
		MengdeADT<Integer> mengdeDif = mengde.minus(mengde2);
//		TabellMengde<Integer> mengdeDif = (TabellMengde<Integer>) mengde.minus(mengde2);
		
		assertEquals(2, mengdeDif.antallElementer());
		assertTrue(mengdeDif.inneholder(1));
		assertTrue(mengdeDif.inneholder(2));
		assertFalse(mengdeDif.inneholder(3));
	}
	
	/**
	 * Legger til et element i mengden. Elementet skal kun legges til hvis
	 * det ikke finnes i mengden fra før.
	 * 
	 * @param element
	 */
	@Test
	void leggTil() {
		
		mengde.leggTil(2);
		
		assertTrue(mengde.inneholder(2));
		
	}
	
	/**
	 * Legger alle elementer fra en annenMengde til i mengden. Kun elementer
	 * som ikke finnes i mengden fra før, skal legges til.
	 * 
	 * @param annenMengde
	 */
	@Test
	void leggTilAlleFra() {
		
		mengde.leggTil(1);
		mengde.leggTil(2);
		mengde2.leggTil(3);
		mengde2.leggTil(4);
		
		assertFalse(mengde.inneholder(3));
		
		mengde.leggTilAlleFra(mengde2);
		
		assertTrue(mengde.inneholder(3));
	}
	
	/**
	 * Fjerner og returnerer et element fra mengden. Hvis elementet ikke finnes 
	 * i mengden, skal metoden returnere null.
	 * 
	 * @param element Et element som er lik det elementet som skal fjernes 
	 * @return Elementet som ble fjernet fra mengden, null hvis det ikke fantes.
	 */
	@Test
	void fjern() {
		
		mengde.leggTil(1);
		mengde.leggTil(2);
		mengde.leggTil(3);
		mengde.leggTil(4);
		
		assertEquals(3,mengde.fjern(3));
		assertFalse(mengde.inneholder(3));
		assertEquals(1,mengde.fjern(1));
		assertEquals(4,mengde.fjern(4));
		
	}
	
	/**
	 * @return En tabell av elementene i mengden. Tabellen har størrelse lik
	 *         antall elementer i mengden.
	 */
	@Test
	void tilTabell() {
		
		mengde.leggTil(1);
		mengde.leggTil(2);
		mengde.leggTil(3);
		
		Object[] tab = mengde.tilTabell();
		
		assertEquals(1,tab[0]);
		assertEquals(2,tab[1]);
		assertEquals(3,tab[2]);
		assertEquals(3,tab.length);
	}
	
	/**
	 * @return Antall elementer i mengden.
	 */
	@Test
	void antallElementer() {
		mengde.leggTil(1);
		mengde.leggTil(2);
		mengde.leggTil(3);
		
		assertEquals(3, mengde.antallElementer());
		assertEquals(0,mengde2.antallElementer());
	}
	
	
	
}
