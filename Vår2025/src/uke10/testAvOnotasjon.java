package uke10;

import java.util.Random;

public class testAvOnotasjon {

	public static void main(String[] args) {
		
		final int n = 10;
		int[] tab = new int[n];
		int[] sum = new int[n];
		Random tilf = new Random();

		for(int i=0; i<n; i++){
		    tab[i] = tilf.nextInt(10);
		}

		sum[0] = tab[0];  // Startverdien
		for(int j=1; j<n; j++){
		    sum[j] = sum[j-1] + tab[j];  // Bruker forrige sum-verdi
		}

		for (int e : tab) {
			   System.out.print(e + " ");
			}
		System.out.print("\n");	
		for (int e : sum) {
			   System.out.print(e + " ");
			}
		
		
	}

}
