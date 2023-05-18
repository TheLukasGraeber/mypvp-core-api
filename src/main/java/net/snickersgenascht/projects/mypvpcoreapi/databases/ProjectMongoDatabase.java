package net.snickersgenascht.projects.mypvpcoreapi.databases;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ProjectMongoDatabase {

    private final Integer port;
    private MongoClient client;
    private String databaseName;
    private final String hostName;

    /*
    Connect to project from mongodb
    */
    public ProjectMongoDatabase(String hostName, Integer port) {
        this.hostName = hostName;
        this.port = port;
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


    public MongoDatabase getProject(String project) {
        return client.getDatabase(project);
    }

    public String getHostName() {
        return hostName;
    }

    public Integer getPort() {
        return port;
    }
}
