package net.snickersgenascht.projects.mypvpcoreapi.servers.spigotserver.commands;

import net.snickersgenascht.projects.mypvpcoreapi.MyPvPCoreAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CoreCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage(MyPvPCoreAPI.getPrefix() + "§7Ersteller dieser CoreAPI§8:");
        sender.sendMessage(MyPvPCoreAPI.getPrefix() + "§c- Snickersgenascht");
        return false;
    }

}
