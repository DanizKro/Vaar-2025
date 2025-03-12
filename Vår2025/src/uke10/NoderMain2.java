package uke10;

import java.util.ArrayList;
import java.util.Stack;

public class NoderMain2 {

	public static void main(String[] args) {

		// Tenker at vi skal opprette en lenke som pekes på av forste
		Node<Integer> forste = null;
		Node<Integer> ny = null;

		// Oppretter en ny node og setter denne inn først i lenken
		ny = new Node<>(4);
		ny.neste = forste;
		forste = ny;
//		skrivUtLenke("forste--> ", forste); // forste--➤[4|-]

		// Oppretter en ny node og setter denne inn først i lenken
		ny = new Node<>(3);
		ny.neste = forste;
		forste = ny;
//		skrivUtLenke("forste--> ", forste); // forste--➤[3|-]--➤[4|-]

		// Oppgave a) skrives direkte inn her ...
		ny = new Node<>(2);
		ny.neste = forste;
		forste = ny;
		ny = new Node<>(1);
		ny.neste = forste;
		forste = ny;
//		skrivUtLenke("forste--> ", forste);

		// Kall til metodene i Oppgave b)-g) gjøres her ...
		// b)
//		System.out.println(lenkeInneholderRekursivt(forste, 5));
		// c)
//		skrivUtFremlengsRekursivt(forste);
//		System.out.println();
		// d)
//		skrivUtBaklengsRekursivt(forste);
//		System.out.println();
		// e)
//		skrivUtBaklengsMedStabel(forste);
//		System.out.println();
		// f)
		ny = new Node<>(3);
		ny.neste = forste;
		forste = ny;
		skrivUtFremlengsRekursivt(forste);
		System.out.println();
		System.out.println("Antall forekomster av tallet " + 3 + " er: " + antallAvIterativ(forste, 3));
		// g)
		System.out.println(antallAvRekursiv(forste, 3));
		
	}

	/* ---------------------------------------------------------------- */
	// Metodene i Oppgave e)-f) skrives inn her ...
	private static <T> void skrivUtLenke(String intro, Node<T> start) {
		System.out.print(intro);
		Node<T> p = start;
		while (p != null) {
			System.out.print("[" + p.data + "|-]");
			if (p.neste != null) {
				System.out.print("--➤");
			}
			p = p.neste;
		}
		System.out.println();
	}
	
	private static int antallAvRekursiv(Node<Integer> start, int e) {
		
		int teller = 0;
		
		//Basis
		if(start == null) {
			return 0;
		}
		
		if(start.data == e) {
			teller++;
		}
		
		return  teller + antallAvRekursiv(start.neste, e);
	}
	
	private static int antallAvIterativ(Node<Integer> start, int e) {
		
		int antall = 0;
		Node<Integer> forste = start;
		
		while(forste != null) {
			if(forste.data == e) {
				antall++;
			}
			forste = forste.neste;
		}
		return antall;
	}
	
	private static <T> void skrivUtBaklengsMedStabel(Node<Integer> start) {
		
		
		Stack<Integer> stack = new Stack<>();
		Node<Integer> forste = start;
		
		while(forste != null) {
			stack.add(forste.data);
			forste = forste.neste;
		}
		
		while (!stack.isEmpty()) {
        System.out.print(stack.pop() + " ");
    }
		
//		System.out.print(stack.toString());
	}

	public static void skrivUtBaklengsRekursivt(Node<Integer> start) {

		// Basis
		if (start == null) {
			return;
		}
		skrivUtBaklengsRekursivt(start.neste);
		
		System.out.print(start.data + " ");

	}

	public static void skrivUtFremlengsRekursivt(Node<Integer> start) {

		// Basis
		if (start == null) {
			return;
		}

		System.out.print(start.data + " ");

		skrivUtFremlengsRekursivt(start.neste);
	}

	private static boolean lenkeInneholderRekursivt(Node<Integer> start, int e) {

		// Basis
		if (start == null) {
			return false;
		}

		if (start.data == e) {
			return true;
		}

		return lenkeInneholderRekursivt(start.neste, e);
	}

	private static <T> int antallNoderILenke(Node<T> start) {

		// Sjekker først om det er noen noder i det hele tatt
		if (start == null) {
			return 0;
		}

		Node<T> node = start;
		int teller = 1;

		// Sjekker om det er flere enn 1 node og eventuelt teller de
		while (node.neste != null) {
			teller++;
			node = node.neste;
		}

		return teller;
	}

	private static boolean lenkeInneholder(Node<String> start, String e) {

		Node<String> node = start;

		if (node.equals(e)) {
			return true;
		}

		while (node.neste != null) {
			if (node.data.equals(e)) {
				return true;
			}
			node = node.neste;
		}
		return false;
	}

}
