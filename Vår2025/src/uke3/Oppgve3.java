package uke3;

import java.util.ArrayList;

public class Oppgve3 {

	public static void main(String[] args) {
		
		ArrayList<Integer> tall = new ArrayList<Integer>(); // Lager ny ArrayList object
		
		tall.add(1);
		tall.add(2);
		tall.add(4);
		tall.add(4);
		tall.add(4);
		
//		System.out.println(tall);
//		System.out.println(tall.get(3));
//		System.out.println(tall.get(4));
		
//		tall.add(1, 2);
//		System.out.println(tall);
//		
//		System.out.println(finnes(tall, 2));
//		System.out.println(finnes(tall, 5));
		
		like(tall, 4);
		
		System.out.println(tall.removeAll(tall));
		System.out.println(tall);
		
		
		
		

}
	// Sjekker 
	public static void like(ArrayList<Integer> tabell, int tall) {
		
		boolean ikkeFunnet = false;
		
		for(int i = 0 ; i < tabell.size(); i++) {
			if(tabell.get(i) == tall) {
				System.out.println("Posisjon: " + i);
				ikkeFunnet = true;
			} 
		} if(!ikkeFunnet) {
			System.out.println("Tallet finnes ikke");
		}
	}
	
	public static boolean finnes(ArrayList<Integer> tall, int innput) {
		
		for(int i = 0; i < tall.size(); i++) {
			if(tall.get(i) == innput) {
				return true;
			}
		} return false;
		
	}
	
	
	
	
}












