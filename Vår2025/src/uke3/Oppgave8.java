package uke3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Oppgave8 {

	public static void main(String[]args) {
		
		ArrayList<NettStudent> liste = new ArrayList<>();
		
		
		NettStudent s1 = new NettStudent(1, "Lars", "Albrigsten", "Bergen", "Oslo");
		NettStudent s2 = new NettStudent(3, "Arne", "Ulf", "Bergen", "Egersund");
		NettStudent s3 = new NettStudent(4, "Jenny", "Jensen", "Bergen", "Oslo");
		NettStudent s4 = new NettStudent(5, "Pål", "Brugger", "Bergen", "Stavanger");
		NettStudent s5 = new NettStudent(2, "Emma", "Nordsjø", "Bergen", "Oslo");
		
		
		//Lager et set(som ikke tar imot duplikater) for å lagre hjemsted til alle nettStudentene.
		Set<String> hjemsted = new HashSet<>();
		
		//Bruker .get metode for hver student for å så legge til til listen, om hjembyen finnes fra før, legges den ikke til.
		hjemsted.add(s1.getHjemsted());
		hjemsted.add(s2.getHjemsted());
		hjemsted.add(s3.getHjemsted());
		hjemsted.add(s4.getHjemsted());
		hjemsted.add(s5.getHjemsted());
		
		System.out.print(hjemsted);
		
		
		
	}
	
}
