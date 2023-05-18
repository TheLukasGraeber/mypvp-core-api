package net.snickersgenascht.projects.mypvpcoreapi.managements;

import com.mongodb.client.MongoCollection;
import net.snickersgenascht.projects.mypvpcoreapi.MyPvPCoreAPI;
import org.bson.Document;

import java.util.ArrayList;

public class ProjectWrapperManagement {

    private final String project;
    private final String collection;

    public ProjectWrapperManagement(String project, String collection) {
        this.project = project;
        this.collection = collection;
    }

    /*
    Get a collection from project and all player data's
    */
    private MongoCollection<Document> getCollection() {
        return MyPvPCoreAPI.getProjectMongoDatabase().getProject(project).getCollection(collection);
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
