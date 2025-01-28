package no.hvl.data102.filmarkiv.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.LinearNode;

public class FilmarkivTest2 {

	@Test
	void finnFilm() {

		Filmarkiv2 test1 = new Filmarkiv2();
		test1.leggTilFilm(new Film(10, "Panasonic", "Månelanding", 1992, Sjanger.EVENTYR, "Disney"));

		assertNotNull(test1.finnFilm(10));

	}

	@Test
	void leggTilFilm() {

		Filmarkiv2 test1 = new Filmarkiv2();
		Film s1 = new Film(10, "Panasonic", "Månelanding", 1992, Sjanger.EVENTYR, "Disney");
		test1.leggTilFilm(s1);

		// Sjekker om det faktisk er bare 1 film i tabellen
		assertEquals(1, test1.getAntall()); // Sjekker om antall objekter i tabellen er 1
		assertEquals(s1, test1.finnFilm(10)); // Sjekker filmen med nummer 10 er i tabellen og sammenligner den med s1
	}

	@Test
	void slettfilm() {

		Filmarkiv2 t1 = new Filmarkiv2();
		t1.leggTilFilm(new Film(1, "Produsent A", "Snow White", 2020, Sjanger.ACTION, "WarnerBrothers"));
		t1.leggTilFilm(new Film(2, "Produsent B", "Taken", 2021, Sjanger.DRAMA, "Netflix"));
		t1.leggTilFilm(new Film(3, "Produsent C", "Harry Potter", 2022, Sjanger.EVENTYR, "SF-Film"));

		assertTrue(t1.slettFilm(3)); // Metoden skal returnere true hvis den er slettet
		assertNull(t1.finnFilm(3)); // Slettet film skal ikke eksistere i tabellen

	}

	@Test
	void soekTittel() {

		//Film(int filmnr, String produsent, String tittel, int lansering, Sjanger sjanger, String filmselskap)
		
		Filmarkiv2 t1 = new Filmarkiv2();
		t1.leggTilFilm(new Film(1, "Produsent A", "Snow White", 2020, Sjanger.EVENTYR, "WarnerBrothers"));
		t1.leggTilFilm(new Film(2, "Produsent B", "Transfomers", 2014, Sjanger.ACTION, "WarnerBrothers"));
		t1.leggTilFilm(new Film(3, "Produsent A", "Snow White", 2020, Sjanger.ACTION, "WarnerBrothers"));
		
		Film[] resultat = t1.soekTittel("snow white");

		assertEquals("Snow White", resultat[0].getTittel());
		assertEquals("Snow White", resultat[1].getTittel());

	}

	@Test
	void soekProdusent() {

		Filmarkiv2 t1 = new Filmarkiv2();
		t1.leggTilFilm(new Film(1, "Michael Bay", "Transformers", 2020, Sjanger.ACTION, "WB"));

		Film[] resultat = t1.soekProdusent("michael bay");

		assertEquals("Michael Bay", resultat[0].getProdusent());
	}

	@Test
	void antallSjanger() {

		Filmarkiv2 t1 = new Filmarkiv2();
		t1.leggTilFilm(new Film(1, "Produsent A", "Snow White", 2020, Sjanger.ACTION, "WarnerBrothers"));
		t1.leggTilFilm(new Film(2, "Michael Bay", "Transformers", 2020, Sjanger.ACTION, "WB"));
		t1.leggTilFilm(new Film(3, "Produsent B", "Harry Potter", 2022, Sjanger.EVENTYR, "SF-Film"));

		assertEquals(2, t1.antallSjanger(Sjanger.ACTION));
		assertEquals(1, t1.antallSjanger(Sjanger.EVENTYR));
		
	}

	

}
