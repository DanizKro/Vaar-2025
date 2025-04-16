package Sok;

public class BinaerSok {
	
	public static int binaerSokIterativ(int tabell[], int verdi) {
		
		int venstre = 0;
		int hoyre = tabell.length - 1;
		
		while (venstre <= hoyre) {
			
			int midtpunkt = (venstre + hoyre)/2;
			int resultat = element.compareTo(tabell[midtpunkt]); 	//Tar i betraktning at den har comparable
			
			if (resultat == 0) {
				return resultat;
				
			} else if (resultat < 0) {
				hoyre = midtpunkt - 1;
				
			} else {
				venstre = midtpunkt + 1;
			}
		}
		return -1;
	
	}
	
	public static <T exstends Comparable<T>> void kvikkSorter(T tabell[], int start, int end) {
		
		//Basis
		if(end <= start) {
			return;
		}
		
		int pivot = partisjoner(tabell, start, end);
		
		kvikkSorter(tabell, start, pivot-1);
		kvikkSorter(tabell, pivot+1, end );

		
	}
	
	

}
