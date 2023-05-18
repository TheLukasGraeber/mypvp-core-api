package net.snickersgenascht.projects.mypvpcoreapi.clients;

import com.mongodb.client.MongoCollection;
import net.snickersgenascht.projects.mypvpcoreapi.MyPvPCoreAPI;
import org.bson.Document;

import java.util.Objects;

public class ProxyUserClient {

    private final String collection;

    /*
    The client loads the proxy handler name and the 'players' collection,
    which players can query and read out all the information
    */
    public ProxyUserClient(String collection) {
        this.collection = collection;
    }

    /*
    Get a collection from project and all player data's
    */
    private MongoCollection<Document> getCollection() {
        return MyPvPCoreAPI.getProxyMongoDatabase().getProxyHandler().getCollection(collection);
    }

    /*
    Replaced an uuid from old user to a new
    */
    public void replaceUnique(String oldUUID, String uuid) {
        final Document oldDocument = new Document("playerUniqueID", oldUUID)
                .append("playerName", this.getName(oldUUID))
                .append("playerLowedName", this.getLowedName(oldUUID))
                .append("playerUpperName", this.getUpperName(oldUUID));
        final Document newDocument = new Document("playerUniqueID", uuid)
                .append("playerName", this.getName(oldUUID))
                .append("playerLowedName", this.getLowedName(oldUUID))
                .append("playerUpperName", this.getUpperName(oldUUID));
        final Document exists = new Document("playerUniqueID", oldUUID);
        if (this.getCollection().find(exists).first() != null) {
            this.getCollection().replaceOne(oldDocument, newDocument);
        }
    }

    /*
    Replaced a username from old user to a new
    */
    public void replaceName(String name, String name2) {
        final Document oldDocument = new Document("playerUniqueID", this.getUnique(name))
                .append("playerName", name)
                .append("playerLowedName", name.toLowerCase())
                .append("playerUpperName", name.toUpperCase());
        final Document newDocument = new Document("playerUniqueID", this.getUnique(name))
                .append("playerName", name2)
                .append("playerLowedName", name2.toLowerCase())
                .append("playerUpperName", name2.toUpperCase());;
        final Document exists = new Document("playerUniqueID", this.getUnique(name));
        if (this.getCollection().find(exists).first() != null) {
            this.getCollection().replaceOne(oldDocument, newDocument);
        }
    }

    /*
    Get a name with lowed letters from uuid
    */
    public String getLowedName(String uuid) {
        final Document exists = new Document("playerUniqueID", uuid);
        if (this.getCollection().find(exists).first() != null) {
            return Objects.requireNonNull(this.getCollection().find(exists).first()).getString("playerLowedName");
        } else {
            return null;
        }
    }

    /*
    Get a name with upper letters from uuid
    */
    public String getUpperName(String uuid) {
        final Document exists = new Document("playerUniqueID", uuid);
        if (this.getCollection().find(exists).first() != null) {
            return Objects.requireNonNull(this.getCollection().find(exists).first()).getString("playerUpperName");
        } else {
            return null;
        }
    }

    /*
    Get an uuid from name
    */
    public String getUnique(String name) {
        final Document exists = new Document("playerName", name);
        if (this.getCollection().find(exists).first() != null) {
            return Objects.requireNonNull(this.getCollection().find(exists).first()).getString("playerUniqueID");
        } else {
            return null;
        }
    }

    /*
    Get a name from uuid
    */
    public String getName(String uuid) {
        final Document exists = new Document("playerUniqueID", uuid);
        if (this.getCollection().find(exists).first() != null) {
            return Objects.requireNonNull(this.getCollection().find(exists).first()).getString("playerName");
        } else {
            return null;
        }
    }

}
