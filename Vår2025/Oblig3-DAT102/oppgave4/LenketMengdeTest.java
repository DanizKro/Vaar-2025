package oppgave4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LenketMengdeTest {

	private LenketMengde<Integer> mengde;
	private LenketMengde<Integer> mengde2;

	@BeforeEach
	void setUp() {

		mengde = new LenketMengde<>();
		mengde2 = new LenketMengde<>();

	}

	/**
	 * @return Om mengden er tom
	 */
	@Test
	void erTom() {

		assertTrue(mengde.erTom());
		mengde.leggTil(1);
		assertFalse(mengde.erTom());

	}

	/**
	 * @param element
	 * @return Om mengden inneholder element
	 */
	@Test
	void inneholder() {

		mengde.leggTil(1);
		mengde.leggTil(2);
		mengde.leggTil(3);

		assertTrue(mengde.inneholder(2));

	}

	/**
	 * @param annenMengde
	 * @return Om mengden er en delmengde av en annenMengde
	 */
	@Test
	void erDelmengdeAv() {

		mengde.leggTil(1);
		mengde.leggTil(2);

		mengde2.leggTil(2);
		mengde2.leggTil(1);
		mengde2.leggTil(3);

		assertTrue(mengde.erDelmengdeAv(mengde2));

	}

	/**
	 * @param annenMengde
	 * @return Om mengden er lik en annenMengde
	 */
	@Test
	void erLik() {
		mengde.leggTil(1);
		mengde.leggTil(2);

		mengde2.leggTil(2);
		mengde2.leggTil(1);

		assertTrue(mengde.erLik(mengde2));
	}

	/**
	 * @param annenMengde
	 * @return Om mengden og en annenMengde er disjunkte
	 */
	@Test
	void erDisjunkt() {

		mengde.leggTil(1);
		mengde.leggTil(2);
		mengde.leggTil(3);

		mengde2.leggTil(2);
		mengde2.leggTil(3);
		mengde2.leggTil(4);

		assertFalse(mengde.erDisjunkt(mengde2));
		mengde.fjern(2);
		mengde.fjern(3);

		assertTrue(mengde.erDisjunkt(mengde2));

	}

	/**
	 * @param annenMengde
	 * @return Snittet av mengden og en annenMengde. Metoden skal ikke endre på
	 *         mengden eller annenMengde, men lage en ny mengde som blir resultatet.
	 */
	@Test
	void snitt() {

		mengde.leggTil(1);
		mengde.leggTil(2);
		mengde.leggTil(3);

		mengde2.leggTil(3);
		mengde2.leggTil(4);

		LenketMengde<Integer> snitt = (LenketMengde<Integer>) mengde.snitt(mengde2);

		assertTrue(snitt.inneholder(3));
		assertFalse(snitt.inneholder(4));

	}

	/**
	 * @param annenMengde
	 * @return Unionen av mengden og en annenMengde. Metoden skal ikke endre på
	 *         mengden eller annenMengde, men lage en ny mengde som blir resultatet.
	 */
	@Test
	void union() {

		mengde.leggTil(1);
		mengde.leggTil(2);

		mengde2.leggTil(3);

		MengdeADT<Integer> union = mengde.union(mengde2);

		assertTrue(union.inneholder(1));
		assertTrue(union.inneholder(2));
		assertTrue(union.inneholder(3));
		
		assertEquals(3, union.antallElementer());

		

	}

	/**
	 * @param annenMengde
	 * @return Mengden minus annenMengde. Metoden skal ikke endre på mengden eller
	 *         annenMengde, men lage en ny mengde som blir resultatet.
	 */
	@Test
	void minus() {

		mengde.leggTil(1);
		mengde.leggTil(2);
		mengde.leggTil(3);
		mengde.leggTil(10);
		
		mengde2.leggTil(2);
		mengde2.leggTil(3);
		mengde2.leggTil(4);
	
		MengdeADT minus = mengde.minus(mengde2);
		
		assertTrue(minus.inneholder(1));
		assertTrue(minus.inneholder(10));
		assertFalse(minus.inneholder(2));
		
		
	}

	/**
	 * Legger til et element i mengden. Elementet skal kun legges til hvis det ikke
	 * finnes i mengden fra før.
	 * 
	 * @param element
	 */
	@Test
	void leggTil() {

		assertTrue(mengde.erTom());
		mengde.leggTil(1);
		assertTrue(mengde.inneholder(1));
		
	}

	/**
	 * Legger alle elementer fra en annenMengde til i mengden. Kun elementer som
	 * ikke finnes i mengden fra før, skal legges til.
	 * 
	 * @param annenMengde
	 */
	@Test
	void leggTilAlleFra() {
		
		mengde.leggTil(1);
		mengde.leggTil(2);
		
		mengde2.leggTil(3);
		mengde2.leggTil(4);
		
		mengde.leggTilAlleFra(mengde2);
		
		assertTrue(mengde.inneholder(4));
		assertEquals(4, mengde.antallElementer());

	}

	/**
	 * Fjerner og returnerer et element fra mengden. Hvis elementet ikke finnes i
	 * mengden, skal metoden returnere null.
	 * 
	 * @param element Et element som er lik det elementet som skal fjernes
	 * @return Elementet som ble fjernet fra mengden, null hvis det ikke fantes.
	 */
	@Test
	void fjern() {
		
		mengde.leggTil(1);
		assertTrue(mengde.inneholder(1));
		
		mengde.fjern(1);
		assertTrue(mengde.erTom());
	}

	/**
	 * @param <T>
	 * @return En tabell av elementene i mengden. Tabellen har størrelse lik antall
	 *         elementer i mengden.
	 */
	@Test
	void tilTabell() {
		
		mengde.leggTil(1);
		mengde.leggTil(2);
		mengde.leggTil(3);
		
		Object[] tab = mengde.tilTabell();
		
		//Blir lagt til tabellen fra "toppen" av stabelen. Det siste elemente som ble lagt til kommer først i tabellen pga leggTil-metoden til Noden
		assertEquals(3,tab[0]);
		assertEquals(2,tab[1]);
		assertEquals(1,tab[2]);
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
		
		assertEquals(3,mengde.antallElementer());
		mengde.fjern(2);
		assertEquals(2,mengde.antallElementer());
	}

}
