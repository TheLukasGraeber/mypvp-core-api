package net.snickersgenascht.projects.mypvpcoreapi.wrappers;

import net.snickersgenascht.projects.mypvpcoreapi.clients.ProxyUserClient;
import net.snickersgenascht.projects.mypvpcoreapi.managements.ProxyWrapperManagement;

public class ProxyUserWrapper {

    private final String collectionName;

    /*
    Load Wrapper with a proxy handler
    */
    public ProxyUserWrapper() {
        this.collectionName = "players";
    }
    /*

    Load the management wrapper
    */
    public ProxyWrapperManagement management() {
        return new ProxyWrapperManagement(collectionName);
    }

    /*
    Load the project client with wrapper
    */
    public ProxyUserClient client() {
        return new ProxyUserClient(collectionName);
    }

}
