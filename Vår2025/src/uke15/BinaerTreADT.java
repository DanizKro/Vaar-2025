package uke15;

import java.util.Iterator;

public interface BinaerTreADT<T> {
	// Boka sitt TreeInterface<T>
	int getAntall(); 
	T getRotData();
	int getHogde();
	boolean erTom();
	void toem();
	
	// Uvanlig, men for å ha ei oppgave
	int getAntallPaaNivaa(int k);
	
	// Boka sitt TreeIeratorInterface<T>
	Iterator<T> getPreordenIterator();
	Iterator<T> getInordenIterator();
	Iterator<T> getPostOrdenIterator();
	Iterator<T> getNivaaIterator();
	
	// Spesielt for binære tre
	
	/**
	 * Lagar eit binært tre med ein node
	 * 
	 * @param rotData Objektet som er data i rota
	 */
	void setTre(T rotData);
	
	/**
	 * Konstruer eit nytt binært tre
	 * 
	 * @param rotData  Objektet som er data i rota
	 * @param venstre  Venstre undertre for det nye treet
	 * @param hogre    Høgre undertre for det nye treet
	 */
	void setTre(T rotData, BinaerTreADT<T> venstre, BinaerTreADT<T> hogre);	
}
