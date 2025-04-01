//package no.hvl.dat107.entity;
//
//import java.util.List;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(schema = "bedrift_oblig3")
//public class Prosjekt {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String navn;
//    private String beskrivelse;
//    
//    @OneToMany(mappedBy="prosjekt")
//    private List<Prosjektdeltagelse> deltagelser;
//    
//    public void skrivUt(String innrykk) {
//        System.out.printf("%sProsjekt nr %d: %s", innrykk, id, navn, beskrivelse);
//    }
//    
//    public void skrivUtMedAnsatte() {
//        System.out.println();
//        skrivUt("");
//        deltagelser.forEach(a -> a.skrivUt("\n   "));
//    }
//
//    public void leggTilProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
//        deltagelser.add(prosjektdeltagelse);
//    }
//
//    public void fjernProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
//        deltagelser.remove(prosjektdeltagelse);
//    }
//
//	public int getId() {
//		return id;
//	}
//
//	public String getNavn() {
//		return navn;
//	}
//	public String getBeskrivelse() {
//		return beskrivelse;
//	}
//
//	public List<Prosjektdeltagelse> getDeltagelser() {
//		return deltagelser;
//	}
// 
//    
//}