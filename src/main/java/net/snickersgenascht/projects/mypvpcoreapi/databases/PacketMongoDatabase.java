package net.snickersgenascht.projects.mypvpcoreapi.databases;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class PacketMongoDatabase {

    private final Integer port;
    private MongoClient client;
    private String databaseName;
    private final String hostName;

    /*
    Connect to packet handler from mongodb
    */
    public PacketMongoDatabase(String hostName, Integer port) {
        this.hostName = hostName;
        this.port = port;
        this.databaseName = "packet_handler";
    }

    /*
    Connected the client with the databases
    */
    public void connect(String username, String password, String authDatabase) {
        this.client = MongoClients.create("mongodb://" + username + ":" + password + "@" + hostName + ":" + port + "/?authSource=" + authDatabase);
    }

    /*
    Check if mongo client connected with the database
    */
    public Boolean isConnected() {
        if (this.client != null) {
            return true;
        } else {
            return false;
        }
    }


    public MongoDatabase getPacketHandler() {
        return client.getDatabase(databaseName);
    }

    public String getHostName() {
        return hostName;
    }

    public Integer getPort() {
        return port;
    }
}
