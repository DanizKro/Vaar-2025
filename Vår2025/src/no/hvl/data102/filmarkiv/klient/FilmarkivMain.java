package no.hvl.data102.filmarkiv.klient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class FilmarkivMain {

	public static void main(String[] args) {
		
//		FilmarkivADT arkivADT = new Filmarkiv(10);
//
//	    arkivADT.leggTilFilm(new Film(1, "Produsent1", "Star Wars", 1977, Sjanger.ACTION, "Lucasfilm"));
//	    arkivADT.leggTilFilm(new Film(2, "Produsent2", "Star Trek", 1980, Sjanger.EVENTYR, "Paramount"));
//	    arkivADT.leggTilFilm(new Film(3, "Produsent3", "Star Wars: Empire Strikes Back", 1980, Sjanger.ACTION, "Lucasfilm"));
//
//	    
//	    System.out.print(arkivADT.finnFilm(1).toString());
//	    
//	     //Lag et Tekstgrensesnitt-objekt
//	    Tekstgrensesnitt tg = new Tekstgrensesnitt();
//
//	    // Be brukeren om en delstreng de vil søke etter i tittelen
//	    Scanner scanner = new Scanner(System.in);
//	    System.out.println("Skriv inn del av tittel du ønsker å søke etter:");
//	    String delstreng = scanner.nextLine();
//
//	    // Kall på metoden skrivUtFilmDelstrengITittel
//	    tg.skrivUtFilmDelstrengITittel(arkivADT, delstreng);
//	    
//	    //Finner film med Filmnr:
//	    tg.skrivUtFilm(arkivADT.finnFilm(3));
//	    
//	    //Finner produsent:
//	   //tg.skrivUtFilmProdusent(arkivADT, "Produsent1");
	    
	    
	   
//************************************************************************************************************************************
	    
	    // KJØRBART PROGRAM

		// Laster opp filmer fra tidligere dokumenr
		Filmarkiv arkiv = new Filmarkiv(50);
		
		
		String desktopDir = System.getProperty("user.home") + "/Desktop" + "/Filmarkiv.txt";
		
		Film[] filmer = lesInnFraFil(
				desktopDir);
		
		// "/Users/dkron/Documents/GitHub/Oblig1-Filmarkiv/Filmarkiv.txt"

		for (Film film : filmer) {
			if (film != null) {
				arkiv.leggTilFilm(film); // Legg filmer inn i arkivet
			}
		}

		// Spør om du vil skrive ut filmer du har, eller om du vil legge til en ny fil

		System.out.println("Velkommen til ditt filmarkiv! :)");

		boolean avslutt = false;

		while (!avslutt) {
			System.out.println();
			System.out.println("Velg et av følgende alternativer:");
			System.out.println("1: Print ut film arkiv til skjermen");
			System.out.println("2: Legg til ny film");
			System.out.println("3: Skriv ut statestikk");
			System.out.println("4: Slett film");
			System.out.println("0: Lagre og avslutt");

			Scanner scanner = new Scanner(System.in);
			String valg = scanner.nextLine();

			switch (valg) {
			case "1":
				skrivUt(arkiv);
				break;

			case "2":
				arkiv.leggTilFilm(lesFilm());
				break;
				
			case "3":
				Tekstgrensesnitt tg = new Tekstgrensesnitt();
				tg.skrivUtStatistikk(arkiv);
				break;

			case "4":
				System.out.println("Slett Filmnr: ");
				int nr = scanner.nextInt();
				scanner.nextLine();
				if(arkiv.slettFilm(nr)) {
					arkiv.slettFilm(nr);
				} else {
					System.out.println("Finner ikke filmen");
				}
				break;

			case "0":
				printFil(arkiv, desktopDir);	//desktopDir er lokasjonen på PCen definert i string lengre oppe
				avslutt = true;
				System.out.println("Lagret og avsluttet :)");
				scanner.close();
				break;

			default:
				System.out.println("Ugyldig valg. Prøv igjen :)");
				break;
			}
		}
		//************************************************************************************************************************************
		
	
		
	}

	private static void skrivUt(Filmarkiv arkiv) {
		Film[] filmer = arkiv.hentFilmTabell(); // Hent tabellen med filmer fra arkivet
		if (filmer.length == 0 || filmer[0] == null) {
			System.out.println("Filmarkivet er tomt.");
			return;
		}

		System.out.println("Innhold i filmarkivet:");
		for (Film film : filmer) {
			if (film != null) {
				System.out.println(film.toString());
			}
		}
	}

	private static Film lesFilm() {

		Filmarkiv filmer = new Filmarkiv(50);
		Meny meny = new Meny(filmer);
		meny.start();

		Film nyfilm = Tekstgrensesnitt.lesFilm();

		System.out.print("Du har lagret følgende film " + nyfilm.toString());
		return nyfilm;
	}

	// Hjelp fra ChattGPT kode for innlesing av fil:
	public static Film[] lesInnFraFil(String filnavn) {
		Film[] filmer = new Film[50]; // Anta maksimalt 100 filmer
		int antallFilmer = 0;

		try {
			File fil = new File(filnavn);
			BufferedReader leser = new BufferedReader(new FileReader(fil));

			String linje;
			while ((linje = leser.readLine()) != null && antallFilmer < filmer.length) {
				// Fjern de ytre klammene og del opp verdiene
				linje = linje.substring(1, linje.length() - 1); // Fjern '[' og ']'
				String[] data = linje.split(", ");

				// Ekstraher verdier fra hver del
				int filmnr = Integer.parseInt(data[0].split("=")[1]);
				String produsent = data[1].split("=")[1];
				String tittel = data[2].split("=")[1];
				int lansering = Integer.parseInt(data[3].split("=")[1]);
				Sjanger sjanger = Sjanger.valueOf(data[4].split("=")[1].toUpperCase());
				String filmselskap = data[5].split("=")[1];

				// Opprett filmobjekt og legg til i tabellen
				filmer[antallFilmer] = new Film(filmnr, produsent, tittel, lansering, sjanger, filmselskap);
				antallFilmer++;
			}

			leser.close();
			System.out.println("[" + antallFilmer + "]" + "Filmer lest inn fra fil: " + filnavn);

		} catch (Exception e) {
			System.out.println("Feil under lesing av fil: " + e.getMessage());
		}

		return filmer;
	}

	// Skriver ut filmer fra innlest tabell til gitt plassering
	public static void printFil(Filmarkiv arkiv, String filnavn) {
		try {
			
			File dir = new File(filnavn).getParentFile();
			if (!dir.exists()) {
				dir.mkdirs(); 
			}

			File nyFil = new File(filnavn);
			PrintWriter skriv = new PrintWriter(nyFil);

			//Skriver ut filmer i dokumentet
			Film[] filmer = arkiv.hentFilmTabell();
			for (Film e : filmer) {
				if (e != null) {
					skriv.println(e.toString());
				}
			}

			skriv.close();
			System.out.println("Lagret fil: " + filnavn);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
