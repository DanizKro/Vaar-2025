package oppgave4;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Person {
	
    private String navn;
    
    //Hobbyer lagres som et set
    private Set<String> hobbyer;

    public Person(String navn, String... hobbyer) {
        this.navn = navn;
        this.hobbyer = new HashSet<>();
        
        //Tungvint løkke
//        List<String> hobbyListe = List.of(hobbyer);
//        for (int i = 0; i < hobbyListe.size(); i++) {
//            this.hobbyer.add(hobbyListe.get(i));
//        }
        
        //Bedre alternativ
        for (String e : hobbyer) {
            this.hobbyer.add(e);
        }
    }

    public String getNavn() {
        return navn;
    }

    public Set<String> getHobbyer() {
        return hobbyer;
    }
}
