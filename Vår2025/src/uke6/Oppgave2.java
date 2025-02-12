package uke6;

public class Oppgave2 {

	public static void main(String[] args) {
	
		int tall = 3;
		
		System.out.print(sumNaturligeTall(tall));

	}
	
	public static int sumNaturligeTall(int tall) {
		
		//Basetilfellet må alltid være med i rekursjon
		if(tall <= 0) {
			return 0;
		}
		int sum = tall;
		
		return sum + sumNaturligeTall(tall-1);
	}

}
