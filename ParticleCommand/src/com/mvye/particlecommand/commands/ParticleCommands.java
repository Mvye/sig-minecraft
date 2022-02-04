package com.mvye.particlecommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ParticleCommands implements CommandExecutor {
    private static Plugin plugin;

    public ParticleCommands(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player))
            return true;
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("toggleParticle")) {
            if (player.hasMetadata("toggleParticle")) {
                player.removeMetadata("toggleParticle", plugin);
            }
            else {
                player.setMetadata("toggleParticle", new FixedMetadataValue(plugin, 0));
            }
        }
        return false;
    }
}
