package net.snickersgenascht.projects.mypvpcoreapi.servers.bungeeserver;

import net.md_5.bungee.api.plugin.Plugin;
import net.snickersgenascht.projects.mypvpcoreapi.MyPvPCoreAPI;

public class BungeeCordServer extends Plugin {

    @Override
    public void onEnable() {
        this.start();
    }

    /*
    Start the server
    */
    private void start() {
        new MyPvPCoreAPI().start();
    }

}
