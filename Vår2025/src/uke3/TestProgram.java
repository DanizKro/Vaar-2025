package uke3;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class TestProgram {
	
	@Test
	void funkegererTrekant() {
		Trekant t1 = new Trekant(10);
		
		assertEquals(50, t1.areal()); //Tester om metoden areal får 50 som resultat
		
		
	} // controll + shift + o - importerer alt som ikke er importert

}
