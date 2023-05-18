package net.snickersgenascht.projects.mypvpcoreapi;

import net.snickersgenascht.projects.mypvpcoreapi.colors.manager.HexCodeManager;
import net.snickersgenascht.projects.mypvpcoreapi.databases.PacketMongoDatabase;
import net.snickersgenascht.projects.mypvpcoreapi.databases.ProjectMongoDatabase;
import net.snickersgenascht.projects.mypvpcoreapi.databases.ProxyMongoDatabase;

public class MyPvPCoreAPI {

    private static MyPvPCoreAPI myPvPCoreAPI;
    public static ProxyMongoDatabase proxyMongoDatabase;
    public static PacketMongoDatabase packetMongoDatabase;
    public static ProjectMongoDatabase projectMongoDatabase;
    private static final String prefix = "§7 §8» " + HexCodeManager.createGradientFromString("MyPvP-Core", new String[]{"#E4AC16", "#F1C54E"}) + " §8┃ §7";
    private static final String prefixAlert = "§8« " + HexCodeManager.createGradientFromString("MyPvP-Core", new String[]{"#E4AC16", "#F1C54E"}) + " §8»";
    private static final String databaseError = prefix + "§cAufgrund eines Fehlers konnten die Daten nicht geladen oder geupdatet werden. Bitte melde dich sofort bei einem Teammitglied!";
    private static final String noPerm = prefix + "§cDieser Befehl existiert nicht, oder du hast keine Rechte diesen auszuführen!";

    /*
    Start the api service
    */
    public void start() {
        this.startDatabases();
    }

    /*
    Start all databases for this api
    */
    private void startDatabases() {
        proxyMongoDatabase = new ProxyMongoDatabase("localhost", 27017);
        proxyMongoDatabase.connect("core-api", "", "admin");
        packetMongoDatabase = new PacketMongoDatabase("localhost", 27017);
        packetMongoDatabase.connect("core-api", "", "admin");
        projectMongoDatabase = new ProjectMongoDatabase("localhost", 27017);
        projectMongoDatabase.connect("core-api", "", "admin");
    }

    public static ProxyMongoDatabase getProxyMongoDatabase() {
        return proxyMongoDatabase;
    }

    public static PacketMongoDatabase getPacketMongoDatabase() {
        return packetMongoDatabase;
    }

    public static ProjectMongoDatabase getProjectMongoDatabase() {
        return projectMongoDatabase;
    }

    public static MyPvPCoreAPI getMyPvPCoreAPI() {
        return myPvPCoreAPI;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static String getPrefixAlert() {
        return prefixAlert;
    }

    public static String getNoPerm() {
        return noPerm;
    }

    public static String getDatabaseError() {
        return databaseError;
    }

}
