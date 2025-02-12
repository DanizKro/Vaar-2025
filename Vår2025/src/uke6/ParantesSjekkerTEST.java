package uke6;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParantesSjekkerTEST {
	
	
	@Test
	void sjekkParenteser() {
		
		ParantesSjekker sjekker = new ParantesSjekker();

        String sant1 = "{ [ ( ) ] }";
        String feil1 = "{ [ ( ) }";
        String feil2 = "[ ( ) ] }";
        String feil3 = "{ [ ( ] ) }";
        String javaprogram = """
                class HelloWorld {
                  public static void main(String[] args) {
                    System.out.println("Hello World!");
                  }
                }
                """;
        
        assertTrue(sjekker.sjekkParenteser(sant1));
        assertFalse(sjekker.sjekkParenteser(feil1));
        assertFalse(sjekker.sjekkParenteser(feil2));
        assertFalse(sjekker.sjekkParenteser(feil3));
        assertTrue(sjekker.sjekkParenteser(javaprogram));
	}
	
	@Test
	void erStartParentes() {
		
		ParantesSjekker sjekker = new ParantesSjekker();
		
		char start = '{';
		char start2 = '[';
		char start3 = '(';
		char slutt = '}';
		 
		
		  assertTrue(sjekker.erStartParentes(start));
		  assertTrue(sjekker.erStartParentes(start2));
		  assertTrue(sjekker.erStartParentes(start3));
		  assertFalse(sjekker.erStartParentes(slutt));
	}
	
	@Test
	void erSluttParenteser() {
		
		ParantesSjekker sjekker = new ParantesSjekker();
		
		char slutt = '}';
		char slutt2 = ']';
		char slutt3 = ')';
		char start = '{';
		
		 assertTrue(sjekker.erSluttParentes(slutt));
		  assertTrue(sjekker.erSluttParentes(slutt2));
		  assertTrue(sjekker.erSluttParentes(slutt3));
		  assertFalse(sjekker.erSluttParentes(start));
	}
	
	@Test
	void erParentesPar() {
		
		ParantesSjekker sjekker = new ParantesSjekker();
		
		char start = '{';
		char slutt = '}';
		char start2 = '(';
		char slutt2 = ')';
		
		assertTrue(sjekker.erParentesPar(start, slutt));
		assertTrue(sjekker.erParentesPar(start2, slutt2));
		assertFalse(sjekker.erParentesPar(start, slutt2));
	}

}
