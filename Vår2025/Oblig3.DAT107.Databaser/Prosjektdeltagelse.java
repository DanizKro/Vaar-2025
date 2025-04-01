//package no.hvl.dat107.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity 
//@Table(schema = "bedrift_oblig3")
//public class Prosjektdeltagelse {
//
//	@Id
//    @ManyToMany
//    @JoinColumn(name = "ansatt_id")
//    private Ansatt ansatt;
//    
//    @Id
//    @ManyToMany
//    @JoinColumn(name = "prosjekt_id")
//    private Prosjekt prosjekt;
//   
//    private int antallJobbtimer;
//    private boolean aktiv;
//    private String rolle;
//    
//    // Constructors, getters, setters
//
//    public Prosjektdeltagelse() {}
//    
//    public Prosjektdeltagelse(Ansatt ansatt, Prosjekt prosjekt, int timer, boolean aktiv, String rolle) {
//        this.ansatt = ansatt;
//        this.prosjekt = prosjekt;
//        this.antallJobbtimer = timer;
//        this.aktiv = aktiv;
//        this.rolle = rolle;
//        //Hvis vi gjør dette her slipper vi å gjøre det i DAO
////        ansatt.leggTilProsjektdeltagelse(this);
////        prosjekt.leggTilProsjektdeltagelse(this);
//    }
//    
//    public void skrivUt(String innrykk) {
//        System.out.printf("%sDeltagelse: %s %s, %s, %d timer", innrykk, 
//                ansatt.getFornavn(), ansatt.getEtternavn(), prosjekt.getNavn(), antallJobbtimer, aktiv, rolle);
//    }
//    
//}