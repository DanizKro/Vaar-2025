package no.hvl.dat107.oblig4.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoWriteException;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.InsertOneModel;

public class LoadJsonRepository {
	private String path = "data/";
	
	private MongoClient client;
	private MongoDatabase database;
	
	public LoadJsonRepository(MongoClient client) {
		super();
		this.client = client;
		this.database = client.getDatabase("oblig4-db");
	}


	public void loadCollection(String name, String filename) throws FileNotFoundException, IOException {
		MongoCollection<Document> coll = database.getCollection(name);
		
		try {
            //drop previous import
            coll.drop();

            //Bulk Approach:
            int count = 0;
            int countTotal = 0;
            int batch = 100;
            List<InsertOneModel<Document>> docs = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(path + filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    docs.add(new InsertOneModel<>(Document.parse(line)));
                    
                    count++;
                    countTotal++;
                    
                    if (count == batch) {
                        coll.bulkWrite(docs, new BulkWriteOptions().ordered(false));
                        docs.clear();
                        count = 0;
                    }
                }
            }

            if (count > 0) {
                BulkWriteResult bulkWriteResult=  coll.bulkWrite(docs, new BulkWriteOptions().ordered(false));
                System.out.println("Collection: " + name + ", Inserted: " + countTotal);
            }

        } catch (MongoWriteException e) {
            System.out.println("Error");
        }
		
	}

}
