package no.hvl.dat107.oblig4.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;

import static com.mongodb.client.model.Filters.eq;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import no.hvl.dat107.oblig4.entity.Kunde;

public class KundeRepository {
	private MongoClient client;
	private MongoDatabase db;
	private MongoCollection<Kunde> kunder;
	
	public KundeRepository(MongoClient client) {
		super();
		this.client = client;
		this.db = client.getDatabase("oblig4-db");
		this.kunder = db.getCollection("kunde", Kunde.class);
	}
	
	public Kunde findByKnr(int knr) {
		
		return kunder.find(eq("knr", knr)).first();
	}

	public Kunde save(Kunde kunde) {
		
		kunder.insertOne(kunde);
		
		return kunde;
	}

	public Kunde delete(int knr) {
		return kunder.findOneAndDelete(eq("knr", knr));
	}

	public Kunde update(Object id, Kunde oppdatertKunde) {
		
		Bson filter = eq("_id", id);
		
		kunder.replaceOne(filter, oppdatertKunde);
		
		return kunder.findOneAndReplace(filter, oppdatertKunde);
	}
}
