package uke3;

public class Main {

	static void skrivTab(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

//		int[] hTab = { 1, 2, 3, 4 };
// 
//		skrivTab(hTab);
//
//		// a) Hva blir skrevet ut?
//
//		for (int i = 0; i < hTab.length; i++) {
//			hTab[i]++;
//		}
//
//		skrivTab(hTab);
//
//		// b) Hva blir skrevet ut?
//		for (int t : hTab) {
//			t++;
//		}
//		skrivTab(hTab);

		// --------------------------------------------------------------
		
//		Heltall[] rTab = new Heltall[4];
//		rTab[0] = new Heltall(1);
//		rTab[1] = new Heltall(2);
//		rTab[2] = new Heltall(3);
//		rTab[3] = new Heltall(4);
//		// c) Hvorfor fungerer ikke denne?
//
//		// Fungerer ikke fordi metoden skrivTab har int som innput.
//		// skrivTab(rTab);
//
//		// d) Hva blir skrevet ut?
//		for (Heltall t : rTab) {
//			System.out.print(t + " ");
//		}
//		System.out.println();
//		
//		// e) Hva blir skrevet ut?
//		for (Heltall t : rTab) {
//			t.inkrementer();
//		}
//		for (Heltall t : rTab) {
//			System.out.print(t + " ");
//		}
//		System.out.println();
		
		// Test av oppg 2 - REKTANGEL -----------------------------------------
		
//		Rektangel firkant = new Rektangel(2,3);
//		firkant.tegn();
//		System.out.print("Areal av Rektangel: " + firkant.areal());
//		
//		Trekant trekant = new Trekant(3);
		//---------------------------------------------------------------------
		Trekant t1 = new Trekant(5);
		Trekant t2 = new Trekant(2);
		
		Rektangel r1 = new Rektangel(2,5);
		Rektangel r2 = new Rektangel(2,2);
		
		Figur[] liste = new Figur[4];
		
		liste[0] = r1;
		liste[1] = t2;
		liste[2] = t1;
		liste[3] = r2;
		
		for(int i = 0; i < liste.length; i++) {
			System.out.println(liste[i].navn());
			liste[i].tegn();
			System.out.println("Areal = " + liste[i].areal());
			System.out.println();
		}
		
	}

}
