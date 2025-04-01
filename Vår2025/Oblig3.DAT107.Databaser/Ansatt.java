

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "bedrift_oblig3")
public class Ansatt {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ansatt_id;
    private String brukernavn;
    private String fornavn;
    private String etternavn;
    private LocalDate datoForAnsettelse;
    private String stilling;
    private Double maanedslonn;
    
    public Ansatt() {
    	
    }
    
    public Ansatt(String brukernavn, String fornavn, String etternavn, LocalDate datoForAnsettelse, String stilling,
			Double maanedslonn, Avdeling avdelings_id) {
		super();
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.datoForAnsettelse = datoForAnsettelse;
		this.stilling = stilling;
		this.maanedslonn = maanedslonn;
		this.avdelings_id = avdelings_id;
	}
    
    //Mange ansatte kan være med i bare 1 avdeling hver
    //I denne klassen er det en FK, i Avdeling er det PK
    @ManyToOne
    @JoinColumn(name = "avdelings_id", nullable = false)
    private Avdeling avdeling;
    
    //Bare en ansatt kan være sjef i en avdeling
    //I denne klassen er det en PK, i Avdeling er det FK
    @OneToOne(mappedBy="ansatt_sjef")
    private Avdeling avdelings_id;
   

	@Override
	public String toString() {
		return "Ansatt [brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", datoForAnsettelse=" + datoForAnsettelse + ", stilling=" + stilling + ", maanedslonn=" + maanedslonn
				+ ", avdelings_id=" + avdelings_id + "]";
	}

	public Integer getId() {
		return this.ansatt_id;
	}
	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public LocalDate getDatoForAnsettelse() {
		return datoForAnsettelse;
	}

	public void setDatoForAnsettelse(LocalDate datoForAnsettelse) {
		this.datoForAnsettelse = datoForAnsettelse;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public Double getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(Double maanedslonn) {
		this.maanedslonn = maanedslonn;
	}

	public int getAvdelings_id() {
		return avdelings_id.getAvdelings_id();
	}

	public void setAvdelings_id(Avdeling avdelings_id) {
		this.avdelings_id = avdelings_id;
	}
    


}