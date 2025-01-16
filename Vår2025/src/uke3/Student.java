package uke3;

import java.util.Objects;

public class Student implements Comparable<Student> {

	private int studentNummer;
	private String fornavn;
	private String etternavn;
	private String studieby;

	public Student(int studentNummer, String fornavn, String etternavn, String studieby) {
		this.studentNummer = studentNummer;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.studieby = studieby;
	}

	public int getStudentNummer() {
		return studentNummer;
	}

	public void setStudentNummer(int studentNummer) {
		this.studentNummer = studentNummer;
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

	public String getStudieby() {
		return studieby;
	}

	public void setStudieby(String studieby) {
		this.studieby = studieby;
	}

	@Override
	public String toString() {
		return "Student [studentNummer=" + studentNummer + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", studieby=" + studieby + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentNummer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return studentNummer == other.studentNummer;
	}

	@Override
	public int compareTo(Student o) {

		// Sorterer ved bruk av metoder for unikt int(1=første nr) eller
		// string(alfabetisk)

		return Integer.compare(this.studentNummer, o.studentNummer);
//			return this.fornavn.compareTo(o.fornavn);
//			return this.etternavn.compareTo(o.etternavn);
	}

}
