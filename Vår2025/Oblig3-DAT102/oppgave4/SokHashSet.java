package oppgave4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class SokHashSet {
	
	public static void main(String[] args) {
		
		//Bruker final fordi verdiene skal ikke endres
        final int antElement = 100000;
        final int antSok = 10000;
        
        HashSet<Integer> hashSet = new HashSet<>();
        int[] tallTabell = new int[antElement];
        
        int startTall = 376;
        for (int i = 0; i < antElement; i++) {
            hashSet.add(startTall);						    //Legger til i HashSet
            tallTabell[i] = startTall;				 		//Legger til i tallTabellen
            startTall = (startTall + 45714) % 1000000;      //Beregner nytt tall
        }

        Arrays.sort(tallTabell);

        // Generer tilfeldige søk-tall
        Random random = new Random();
        int[] søkeTall = new int[antSok];
        for (int i = 0; i < antSok; i++) {
            søkeTall[i] = random.nextInt(1000000);
        }

        // Tidsbruk i HashSet
        long startHashSet = System.nanoTime();
        int funnetHashSet = 0;
        
        for (int tallSøk : søkeTall) {
            if (hashSet.contains(tallSøk)) {
                funnetHashSet++;
            }
        }
        long tidHashSet = System.nanoTime() - startHashSet;

        // Tidsbruk i binærts søk i tabellen
        long startBi = System.nanoTime();
        int funnetSok = 0;
        for (int tallSøk : søkeTall) {
            if (Arrays.binarySearch(tallTabell, tallSøk) >= 0) {
                funnetSok++;
            }
        }
        long tidBinarySearch = System.nanoTime() - startBi;

        
        //Fått hjelp med utskriftsmetode, hvorfor 1_000_00.0?
        System.out.println("Antall treff i HashSet: " + funnetHashSet);
        System.out.println("Tid for HashSet-søk: " + (tidHashSet / 1_000_000.0) + " ms");

        System.out.println("Antall treff i binærsøk: " + funnetSok);
        System.out.println("Tid for binærsøk: " + (tidBinarySearch / 1_000_000.0) + " ms");
    }
}