package uke3;

import java.util.HashSet;
import java.util.Set;

public class Oppgave4 {

	public static void main(String[] args) {
		
		// Mengde, har ingen posisjons index, kan ikke inneholde duplikater
		Set<String> names = new HashSet<>(); 
		
		names.add("Daniel");
		names.add("Ole");
		names.add("Siva");
		
		Set<String> names2 = new HashSet<>();
		
		names2.add("Leinad");
		names2.add("Ole");
		names2.add("Visa");
		
		//Skriver ut tabellen 3 ganger, ikke mulig å skirive ut på indeks posisjon
//		for(String i : names) {
//			System.out.print(names);
//		}
		
		//Union -> Lager en tabell som bare inneholder bare felles elementer
		Set<String> snitt = new HashSet<>();
		
		for(String i : names) {
			if(names2.contains(i)) {
				snitt.add(i);
			}
		} 
		//System.out.print(snitt);
		
		
		//Legger inn 2 tabeller i et HashSet, som ekskluderer kopier -> (Snitt, felles elementer)
		Set<String> union = new HashSet<>();

		union.addAll(names);
		union.addAll(names2);
		
		//System.out.print(union);
		
	}
	
	
	
	
	
}
