package net.snickersgenascht.projects.mypvpcoreapi.managements;

import com.mongodb.client.MongoCollection;
import net.snickersgenascht.projects.mypvpcoreapi.MyPvPCoreAPI;
import org.bson.Document;

import java.util.ArrayList;

public class ProxyWrapperManagement {

    private final String collection;

    public ProxyWrapperManagement(String collection) {
        this.collection = collection;
    }

    /*
    Get a collection from proxy handler and all player data's
    */
    private MongoCollection<Document> getCollection() {
        return MyPvPCoreAPI.getProxyMongoDatabase().getProxyHandler().getCollection(collection);
    }

    /*
    Created a new user to database
    */
    public void create(String uuid, String name) {
        final Document createDocument = new Document("playerUniqueID", uuid)
                .append("playerName", name)
                .append("playerLowedName", name.toLowerCase())
                .append("playerUpperName", name.toUpperCase());
        final Document exists = new Document("playerUniqueID", uuid);
        if (this.getCollection().find(exists).first() == null) {
            this.getCollection().insertOne(createDocument);
        }
    }

    /*
    Deleted a user from database
    */
    public void delete(String uuid) {
        final Document deleteDocument = new Document("playerUniqueID", uuid);
        final Document exists = new Document("playerUniqueID", uuid);
        if (this.getCollection().find(exists).first() != null) {
            this.getCollection().deleteOne(deleteDocument);
        }
    }

    /*
    Get all registered users from database
    */
    public ArrayList<Document> readAll() {
        final ArrayList<Document> documents = new ArrayList<>();
        for (Document document : this.getCollection().find()) {
            documents.add(document);
        }
        return documents;
    }

}
