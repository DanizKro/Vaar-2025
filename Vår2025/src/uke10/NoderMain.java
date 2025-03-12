package uke10;

public class NoderMain {

	public static void main(String[] args) {

		Node<String> a = new Node<>("A");
		Node<String> b = new Node<>("B");
		Node<String> c = new Node<>("C");

		a.neste = c;
		skrivUtLenke("a--➤", a);
		// Oppgave a)-d) skrives direkte inn her ...

		// a)
		a.neste = b;
		b.neste = c;
		skrivUtLenke("a-->", a);
		// b)
		a.neste = c;
		skrivUtLenke("a-->", a);
		// c)
		Node<String> d = new Node<String>("D");
		a.neste = d;
		d.neste = c;
		skrivUtLenke("a-->", a);
		// d)
		Node<String> e = new Node<>("E");
		c.neste = e;
		skrivUtLenke("a-->", a);
		// e)
		System.out.println(antallNoderILenke(a));
		// f)
		String check = "C";
		System.out.println("Lenke innholder" + "[" + check + "]" + " = " +  lenkeInneholder(a, check));
		// Kall til metodene i Oppgave e)-f) gjøres her ...
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
			if(node.data.equals(e)) {
				return true;
			}
			node = node.neste;
		}
		return false;
	}

}
