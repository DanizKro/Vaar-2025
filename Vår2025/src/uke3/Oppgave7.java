package uke3;

import java.util.ArrayList;
import java.util.Collections;

public class Oppgave7 {

	public static void main(String[] args) {

		ArrayList<Student> studenter = new ArrayList<>();

		studenter.add(new Student(1, "Da", "C", "Stud"));
		studenter.add(new Student(4, "Ad", "D", "Stud"));
		studenter.add(new Student(2, "Je", "D", "Stud"));
		studenter.add(new Student(3, "Ti", "B", "Stud"));
		studenter.add(new Student(5, "Da", "A", "Stud"));

		System.out.println(studenter);

		// Bruker sorteringsmetode fra Collections -> Student klassen har en egen
		// definert nøkkel i compareTo metoden i klassen.
		Collections.sort(studenter);

		System.out.println(studenter);

	}
}
