package com.mvye.particlecommand;

import com.mvye.particlecommand.commands.ParticleCommands;
import com.mvye.particlecommand.events.ParticleCreation;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class ParticleCommand extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ParticleCreation(this), this);
        getCommand("toggleParticle").setExecutor(new ParticleCommands(this));
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ParticleCommand]: Plugin is enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[ParticleCommand]: Plugin is disabled!");
    }
}
