package no.hvl.dat107.oblig4.entity;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Kunde {
	private ObjectId id;
    
	@BsonProperty(value = "knr")
    private Integer kundeNr;
    
    @BsonProperty(value = "fornavn")
    private String fornavn;
    
    @BsonProperty(value = "etternavn")
    private String etternavn;
    
    @BsonProperty(value = "adresse")
    private String adresse;
    
    @BsonProperty(value = "postnr")
    private String postnr;

    // Constructor(s)
    public Kunde() {}
    
    public Kunde(Integer kundeNr, String fornavn, String etternavn, String adresse, String postnr) {
		this.kundeNr = kundeNr;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.postnr = postnr;
	}
    
    // Getters and Setters
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Integer getKundeNr() {
		return kundeNr;
	}

	public void setKundeNr(Integer kundeNr) {
		this.kundeNr = kundeNr;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPostnr() {
		return postnr;
	}

	public void setPostnr(String postnr) {
		this.postnr = postnr;
	}

	@Override
	public String toString() {
		return "Kunde [id=" + id + ", kundeNr=" + kundeNr + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", adresse=" + adresse + ", postnr=" + postnr + "]";
	}
    
	
}
