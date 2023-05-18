package net.snickersgenascht.projects.mypvpcoreapi.handlers;

import com.mongodb.client.MongoCollection;
import net.snickersgenascht.projects.mypvpcoreapi.MyPvPCoreAPI;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Objects;

public class PacketHandler {

    /*
    Get from Project the packets collection
    */
    private MongoCollection<Document> getPacketHandler() {
        return MyPvPCoreAPI.getPacketMongoDatabase().getPacketHandler().getCollection("packets");
    }

    /*
    Created a Packet with a packet-name, document.
    The document can wrote with another arguments.
    */
    public void create(String packet, Document document) {
        if (!this.isExist(packet, document)) {
            final Document document2 = new Document("packet", packet).append("packets", document);
            this.getPacketHandler().insertOne(document2);
        }
    }

    /*
    Deleted one Packet with a packet-name, document.
    The document can wrote with another arguments.
    */
    public void deleteOne(String packet, Document document) {
        if (this.isExist(packet, document)) {
            final Document document2 = new Document("packet", packet).append("packets", document);
            this.getPacketHandler().deleteOne(document2);
        }
    }

    /*
    Deleted all Packets with a packet-name, document.
    The document can wrote with another arguments.
    */
    public void deleteMany(String packet, Document document) {
        if (this.isExist(packet, document)) {
            final Document document2 = new Document("packet", packet).append("packets", document);
            this.getPacketHandler().deleteMany(document2);
        }
    }

    /*
    Get a packet information of document
    */
    public Document get(String packet) {
        final Document document2 = new Document("packet", packet);
        return (Document) Objects.requireNonNull(this.getPacketHandler().find(document2).first()).get("packets");
    }

    /*
    Get all packets
    */
    public ArrayList<Document> getAll(String packet) {
        final ArrayList<Document> documents = new ArrayList<>();
        final Document document2 = new Document("packet", packet);
        for (Document document : this.getPacketHandler().find(document2)) {
            documents.add(document);
        }
        return documents;
    }


    /*
    Queries whether this package exists
    */
    public Boolean isExist(String packet, Document document) {
        final Document document2 = new Document("packet", packet).append("packets", document);
        if (this.getPacketHandler().find(document2).first() != null) {
            return true;
        } else {
            return false;
        }
    }

}
