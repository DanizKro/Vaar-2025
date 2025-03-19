package oppgave4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class HobbyMatchMain {
	
	public static void main(String Args[]) {
		
		Person nr1 = new Person("David", "Fjell", "Gaming", "Bil", "Karriere");
		Person nr2 = new Person("Jonas", "Sport", "Gaming", "Båt", "Karriere");
		Person nr3 = new Person("Erlend", "Fjell", "Gaming", "Bil", "Karriere");
		
		
		
		
	}
	
	static double match(Person a, Person b) {
		
		Set<String> felles = new HashSet<>(a.getHobbyer());
		
		return 0;
	}

}
