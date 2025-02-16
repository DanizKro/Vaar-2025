package uke6;

public class Oppgave2 {

	public static void main(String[] args) {

		// System.out.print(sumNaturligeTall(2));

		// System.out.print(isPalindrome("kook"));

//		char[] tegnArray = aString.toCharArray();
//		for(char e : tegnArray) {
//        	System.out.print(e + "-");
//        }
//		System.out.println(tegnArray.length);

		int fib = 45;

		// ikke rekursiv metode
		System.out.println(fibonacci2(fib));

		// Rekursiv metode
		long startTime = System.currentTimeMillis();
		System.out.println("Du fikk tallet: " + fibonacci(fib));
		long endTime = System.currentTimeMillis();
		double tid = (endTime - startTime) / 1000;

		System.out.println("Fibonacci sekvens av: " + "[" + fib + "]" + " Tok : " + tid + " Sekunder");

	}

	// a)
	public static int sumNaturligeTall(int tall) {

		// Basetilfellet må alltid være med i rekursjon
		if (tall <= 0) {
			return 0;
		}
		int sum = tall;

		return sum + sumNaturligeTall(tall - 1);
	}

	// b)
	// Kjøretid N*N/2 = O(n):
	public static boolean isPalindrome(String aString) {

		char[] tegnArray = aString.toCharArray(); // N-kjøretid

		for (int i = 0; i < tegnArray.length; i++) {
			if (tegnArray[i] != tegnArray[tegnArray.length - 1 - i]) { // N/2 -kjøretid
				return false;
			}
		}
		return true;
	}

// Chatt GPT forbedret verjson der man ikke trenger å lage CharTabell man konverterer direkte: O(1)
// Kjøretid er samme O(n) men plasskompleksitet er redusert til O(1) pga ingen array som tar plass

//	public static boolean isPalindrome(String aString) {
//	   
//	    for (int i = 0; i < aString.length() / 2; i++) {
//	        if (aString.charAt(i) != aString.charAt(aString.length() - 1 - i)) {
//	            return false;
//	        }
//	    }
//	    return true;
//	}

	// c)

	public static int fibonacci(int n) {

		// Basetilfellet
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		return fibonacci(n - 1) + fibonacci(n - 2); // N*N kjøretid = O(n^2)
	}

	// d)

	// ikke rektursiv Fibonacci-metode (kjøretid O(n-1) -> O(n)
	public static int fibonacci2(int n) {

		// Basetilfeller både 0 og 1 returnerer bare tallet 0 og 1
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		int forrige = 0; // holder verdien for forrige tall
		int tall = 1; // holder verdien for nåværende tall som må være > 0
		int fib = 0; // Holder summen av forrige tall + nåværende tall i rekken

		// i=2 fordi man tar bare forrige og neste
		for (int i = 2; i <= n; i++) {
			fib = forrige + tall; // neste fibonacci-tall
			forrige = tall;
			tall = fib;
		}

		return fib;
	}

}
