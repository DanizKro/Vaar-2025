package no.hvl.dat107.oblig4;

import java.io.*;
import java.util.Optional;

import com.mongodb.client.MongoClient;

import no.hvl.dat107.oblig4.config.MongoClientFactory;
import no.hvl.dat107.oblig4.entity.Kunde;
import no.hvl.dat107.oblig4.repository.KundeRepository;
import no.hvl.dat107.oblig4.repository.LoadJsonRepository;

public class MongoDbOblig4 {
    public static void main(String[] args) throws IOException {

        MongoClient client = MongoClientFactory.getMongoClient("mongodb://localhost:27017");

        LoadJsonRepository repoLoad = new LoadJsonRepository(client);
        KundeRepository repoKunde = new KundeRepository(client);
        
        // ------------------------------------------
        // Oppgave 4b) LOAD DATA into MongoDB
        // Tips! use 
        
        //repoLoad.loadCollection("kunde", "kunde.json");
        // ------------------------------------------
        heading("Loading data ...");
        /* TODO */
        
        //TEST
        
        // ------------------------------------------
        // Oppgave 4 d) Finn kundenr 5002
        // ------------------------------------------
        heading("Finding Kundenr = 5002");
        
        // TODO: Fullfør metoden findByKnr i KundeRepository
        Kunde kunde = repoKunde.findByKnr(5002);
        if (kunde != null) {
        	System.out.println(kunde);
        } else {
        	System.out.println("INFO: Kundenr 5002 finnes ikke.");
        }
        
//        // ------------------------------------------
//        // Oppgave 4 e) Legg til ny kunde 
//        // ------------------------------------------
//        heading("Inserting new Kunde 5001");
//        
//        // TODO: Fullfør metoden save i KundeRepository
//        Kunde aKunde = new Kunde(5001,"Ola", "Hansen", "Lia 2", "1234");
//        Kunde nyKunde = repoKunde.save(aKunde);
//        
//        if (nyKunde != null) {
//        	System.out.println(nyKunde);
//        } else {
//        	System.out.println("INFO: Kundenr 5001 finnes ikke.");
//        }
//        
//        // ------------------------------------------
//        // Oppgave 4 d) Slett kunde 
//        // ------------------------------------------
//        heading("Slett kundenr 5007 ...");
//        
//        // TODO: Fullfør metoden delete i KundeRepository
//        Kunde slettetKunde = repoKunde.delete(5007);
//        
//        if (slettetKunde != null) {
//        	System.out.println("Kunde 5007 er slettet.");
//        } else {
//        	System.out.println("INFO: Kundenr 5007 finnes ikke.");
//        }
//       
//        
//        // ------------------------------------------
//        // Oppgave 4 e) Endre fornavn knr 5002 => Pål 
//        // ------------------------------------------
//        
//        if (kunde != null) {
//        	heading("Endrer fornavn kundenr 5002 til 'Pål' ..."); 
//        	
//        	kunde.setFornavn("Pål");
//        	Kunde endretKunde = repoKunde.update(kunde.getId(), kunde); 
//            
//        	if (endretKunde != null) {
//            	System.out.println(kunde);
//            } else {
//            	System.out.println("INFO: Kundenr 5002 finnes ikke.");
//            }
//        }

    }

	private static void heading(String msg) {
		String line = "---------------------------------------";
		System.out.println("");
		System.out.println(line);
		System.out.println("-- " + msg);
		System.out.println(line);
	}
}