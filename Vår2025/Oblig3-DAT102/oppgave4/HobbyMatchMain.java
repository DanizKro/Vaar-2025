package oppgave4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class HobbyMatchMain {
	
	public static void main(String Args[]) {
		
		Person nr1 = new Person("David", "Fjell", "Gaming", "Bil", "Karriere","kampsport");
		Person nr2 = new Person("Jonas", "Sport", "Gaming", "Blt", "Karriere","kampsport");
		Person nr3 = new Person("Erlend", "Fjell", "Gaming", "Bil", "Karriere","klatring");
		
		// 0,5 = høyeste match, da er alle hobbyer like
		System.out.println(match(nr1,nr1));
		System.out.println(match(nr1,nr2));
		System.out.println(match(nr2,nr1));
		System.out.println(match(nr1,nr3));
		
		
		
		
	}
	
	
	static double match(Person a, Person b) {
		
	    Set<String> KunA = new HashSet<>(a.getHobbyer());
	    Set<String> KunB = new HashSet<>(b.getHobbyer());

	    Set<String> felles = new HashSet<>(KunA);
	    felles.retainAll(KunB); //Fjerner alle ulike elementer og bare beholder felles elementer

	    Set<String> kunHosA = new HashSet<>(KunA);
	    kunHosA.removeAll(KunB); //Fjerner alle elementer fra A som finnes i B

	    Set<String> kunHosB = new HashSet<>(KunB);
	    kunHosB.removeAll(KunA); //Fjerner alle elementer fra B som finnes i A

	    int antallFelles = felles.size();
	    int antallKunHosDenEne = kunHosA.size();
	    int antallKunHosDenAndre = kunHosB.size();
	    int antallTotalt = KunA.size() + KunB.size();

	    if (antallTotalt == 0) return 0; // Unngå divisjon på null

	    return (double) Math.abs(antallFelles - (antallKunHosDenEne + antallKunHosDenAndre)) / antallTotalt;
	}
}
