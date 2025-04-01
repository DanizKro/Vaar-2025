

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Avdeling", schema = "bedrift_oblig3")
public class Avdeling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer avdelings_id;

    
    private String navn;
    
    //PK i denne klassen/tabellen som er FK i ansatt tabellen
    @OneToMany(mappedBy = "avdelings_id")  // Read-only, no @JoinColumn here
    private List<Ansatt> ansattListe = new ArrayList<>();
    
    //FK - fra ansatt
    @OneToOne
    @JoinColumn(name="ansatt_sjef")
    private Ansatt ansatt_sjef;
   

    
    //Må ha vanlig konstruktør også!
    public Avdeling() {}

    public Avdeling(String navn, Ansatt ansattSjef) {
        this.navn = navn;
        this.ansatt_sjef = ansattSjef;
    }
    
   

    @Override
    public String toString() {
        return "[AvdelingsId: " + avdelings_id + ", Navn: " + navn + ", Ansatt_id: "+ ansatt_sjef.getId() + "]";
    }

	public Integer getAvdelings_id() {
		return avdelings_id;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public List<Ansatt> getAnsattListe() {
		return ansattListe;
	}

	public void setAnsattListe(List<Ansatt> ansattListe) {
		this.ansattListe = ansattListe;
	}

	public Ansatt getAnsatt_sjef() {
		return ansatt_sjef;
	}

	public void setAnsatt_sjef(Ansatt ansatt_sjef) {
		this.ansatt_sjef = ansatt_sjef;
	}
  
}