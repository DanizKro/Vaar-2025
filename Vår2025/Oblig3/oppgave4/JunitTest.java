package oppgave4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JunitTest {

	/**
	 * @return Om mengden er tom
	 */
	@Test
	void erTom() {
		
	}
	
	/**
	 * @param element
	 * @return Om mengden inneholder element
	 */
	@Test
	void inneholder() {
		
	}
	
	/**
	 * @param annenMengde
	 * @return Om mengden er en delmengde av en annenMengde
	 */
	@Test
	void erDelmengdeAv() {
		
	}
	
	/**
	 * @param annenMengde
	 * @return Om mengden er lik en annenMengde
	 */
	@Test
	void erLik() {
		
	}
	
	/**
	 * @param annenMengde
	 * @return Om mengden og en annenMengde er disjunkte
	 */
	@Test
	void erDisjunkt() {
		
	}
	
	/**
	 * @param annenMengde
	 * @return Snittet av mengden og en annenMengde.
	 *         Metoden skal ikke endre på mengden eller annenMengde,
	 *         men lage en ny mengde som blir resultatet.
	 */
	@Test
	void snitt() {
		
	}
	
	/**
	 * @param annenMengde
	 * @return Unionen av mengden og en annenMengde.
	 *         Metoden skal ikke endre på mengden eller annenMengde,
	 *         men lage en ny mengde som blir resultatet.
	 */
	@Test
	void union(){
		
	}
	
	/**
	 * @param annenMengde
	 * @return Mengden minus annenMengde.
	 *         Metoden skal ikke endre på mengden eller annenMengde,
	 *         men lage en ny mengde som blir resultatet.
	 */
	@Test
	void minus(){
		
	}
	
	/**
	 * Legger til et element i mengden. Elementet skal kun legges til hvis
	 * det ikke finnes i mengden fra før.
	 * 
	 * @param element
	 */
	@Test
	void leggTil() {
		
	}
	
	/**
	 * Legger alle elementer fra en annenMengde til i mengden. Kun elementer
	 * som ikke finnes i mengden fra før, skal legges til.
	 * 
	 * @param annenMengde
	 */
	@Test
	void leggTilAlleFra() {
		
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
		
	}
	
	/**
	 * @return En tabell av elementene i mengden. Tabellen har størrelse lik
	 *         antall elementer i mengden.
	 */
	@Test
	void tilTabell() {
		
	}
	
	/**
	 * @return Antall elementer i mengden.
	 */
	@Test
	void antallElementer() {
		
	}
	
	
	
}
