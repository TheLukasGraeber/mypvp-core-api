package net.snickersgenascht.projects.mypvpcoreapi.handlers;

import net.snickersgenascht.projects.mypvpcoreapi.MyPvPCoreAPI;
import org.bson.Document;

public class LogsHandler {

    private final String project;

    public LogsHandler(String project) {
        this.project = project;
    }

    /*
    Created a Log with a category, name, document.
    The document can wrote with another arguments.
    */
    public void create(String category, String name, Document document) {
        final Document createDocument = new Document("category", category)
                .append("name", name)
                .append("document", document);
        MyPvPCoreAPI.getProjectMongoDatabase().getProject(project).getCollection("logs").insertOne(createDocument);
    }

    /*
    Deleted a Log with a category, name.
    */
    public void delete(String category, String name) {
        final Document deleteDocument = new Document("category", category)
                .append("name", name);
        MyPvPCoreAPI.getProjectMongoDatabase().getProject(project).getCollection("logs").deleteOne(deleteDocument);
    }

}