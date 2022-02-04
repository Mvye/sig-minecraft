package com.mvye.particlecommandmm.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ParticleCreation implements Listener {

    // Allows us to use BukkitRunnable
    private static Plugin plugin;

    // Constructor to pass in JavaPlugin to use BukkitRunnable
    public ParticleCreation(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public static void onSneak(PlayerToggleSneakEvent event) {
        final Player player = event.getPlayer();
        if (player.hasMetadata("toggleParticleMM"))
            new ParticleTask(player).runTaskTimer(plugin, 0, 1); // Runs the task with a delay of 0 once per tick
    }
}
