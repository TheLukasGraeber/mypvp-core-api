package net.snickersgenascht.projects.mypvpcoreapi.wrappers;

import net.snickersgenascht.projects.mypvpcoreapi.clients.ProjectUserClient;
import net.snickersgenascht.projects.mypvpcoreapi.managements.ProjectWrapperManagement;

public class ProjectUserWrapper {

    private final String project;
    private final String collectionName;

    /*
    Load Wrapper with project name
    */
    public ProjectUserWrapper(String project) {
        this.project = project;
        this.collectionName = "players";
    }

    /*
    Load the management wrapper
    */
    public ProjectWrapperManagement management() {
        return new ProjectWrapperManagement(project, collectionName);
    }

    /*
    Load the project client with wrapper
    */
    public ProjectUserClient client() {
        return new ProjectUserClient(project, collectionName);
    }

    public String getProject() {
        return project;
    }

}
