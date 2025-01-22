package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {

	private int filmnr;
	private String produsent;
	private String tittel;
	private int lansering;
	private Sjanger sjanger;
	private String filmselskap;
	
	public Film(int filmnr, String produsent, String tittel, int lansering, Sjanger sjanger, String filmselskap) {

		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lansering = lansering;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}

	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLansering() {
		return lansering;
	}

	public void setLansering(int lansering) {
		this.lansering = lansering;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmselskap() {
		return filmselskap;
	}

	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}

	@Override
	public String toString() {
		return "Film [filmnr=" + filmnr + ", produsent=" + produsent + ", tittel=" + tittel + ", lansering=" + lansering
				+ ", sjanger=" + sjanger + ", filmselskap=" + filmselskap + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmnr, filmselskap, lansering, produsent, sjanger, tittel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmnr == other.filmnr && Objects.equals(filmselskap, other.filmselskap) && lansering == other.lansering
				&& Objects.equals(produsent, other.produsent) && sjanger == other.sjanger
				&& Objects.equals(tittel, other.tittel);
	}
	
	
	
	
}
