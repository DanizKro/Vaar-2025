package uke3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static java.lang.Integer.parseInt;


public class Oppgave5 {

	public static void main(String[] args) {
		
		//String = søkeorde datatype
		//Integer = teller datatype
		Map<String, Integer> frekvens = new HashMap<>();
		
		String[] ord = {"er", "det", "alle", "er", "det", "det"};
		
		for(String i : ord) {
			if(frekvens.containsKey(i)) {				//Sjekker om frekvens tabellen har et ord med nøkkelen dra tabellen: ord
				frekvens.put(i, frekvens.get(i)+1);		//Hvis den har det, henter vi indeks(antall) nøkler som har det i frekvens-tabellen og plusser på antall 
			} else frekvens.put(i, 1);					//Hvis frekvens-tabellen ikke har en teller for en nøkkel, lages det en teller og antall med nøkkelord settes til 1
		}
		//System.out.println(frekvens);
		//--------------------------------------------------
		
		//Leser inn ord fra brukeren, og teller antall ord som er puttet inn og hvor mange som er av de
		
		ArrayList<String> lesinn = new ArrayList<>();
		Map<String, Integer> lestInnOrd = new HashMap<>();
		
		int antall = parseInt(showInputDialog("Hvor mange ord vil du legge til?"));
		
		for(int i = 0; i < antall; i++) {
			lesinn.add(showInputDialog("Les inn ord nr" + (i+1)));
		}
		
		for(String i : lesinn) {
			if(lestInnOrd.containsKey(i)) {
				lestInnOrd.put(i, lestInnOrd.get(i)+1);
			} else lestInnOrd.put(i, 1);
		}
		showMessageDialog(null,lestInnOrd);
		
		
		
			
		
	}
	
	
}
