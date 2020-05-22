package modelo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

//Correr mongo y mongodb en terminal
//Importar desde consola normal:
//mongoimport --db adatord --file /Users/sarascript/Desktop/20200225_ADAT_Ordinario.json --collection baloncesto --jsonArray --drop

//https://www.tutorialspoint.com/mongodb/index.htm

public class MongoAccess {
	
	private MongoClient mongo = connect();
	private MongoCollection<Document> myCollection = mongo.getDatabase("adatord").getCollection("baloncesto");
	
	// Iniciar conexión con mongodb
	public static MongoClient connect() {
		MongoClient mongo;
		mongo = new MongoClient("localhost", 27017);
		return mongo;
	}
	
	// Método Show all
	public void showAll() {
		FindIterable<Document> result = myCollection.find();
		
		for (Document document : result) {
			System.out.println(document.toString());
		}
	}
	
	// Método Search for title
	public void searchForTitle(String title) {
		int num = 0;
		
		FindIterable<Document> result = myCollection.find(Filters.eq("titulos", title));
		
		for (Document document : result) {
			num++;
			System.out.println(document.toString());
		}
		
		if (num == 0) {
			System.out.println("No team with that title.");
		}
	}
	
	// Método Add element
	public void add(String name, String city) {
		myCollection.insertOne(new Document().append("nombre", name).append("ciudad", city));
		System.out.println("Team inserted with name: " + name);
	}
	
	// Método Update titles
	public void updateTitles(String name, String title) {
		myCollection.updateOne(new Document("nombre", name), new Document("$push", new Document("titulos", title)));
		System.out.println("Title " + title + " inserted in team " + name);
	}
	
	
}
