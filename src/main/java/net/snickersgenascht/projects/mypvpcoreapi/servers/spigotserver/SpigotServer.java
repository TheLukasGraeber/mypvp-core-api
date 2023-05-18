package net.snickersgenascht.projects.mypvpcoreapi.servers.spigotserver;

import net.snickersgenascht.projects.mypvpcoreapi.MyPvPCoreAPI;
import net.snickersgenascht.projects.mypvpcoreapi.servers.spigotserver.commands.CoreCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class SpigotServer extends JavaPlugin {

    @Override
    public void onEnable() {
        this.start();
    }

    /*
    Start the server
    */
    private void start() {
        new MyPvPCoreAPI().start();
        this.registerCommands();
    }

    /*
    Register all commands
    */
    private void registerCommands() {
        Objects.requireNonNull(this.getCommand("core")).setExecutor(new CoreCommand());
    }

}
