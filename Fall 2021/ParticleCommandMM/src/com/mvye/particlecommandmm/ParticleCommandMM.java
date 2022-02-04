package com.mvye.particlecommandmm;

import com.mvye.particlecommandmm.commands.ParticleCommands;
import com.mvye.particlecommandmm.events.ParticleCreation;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class ParticleCommandMM extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ParticleCreation(this), this);
        getCommand("toggleParticleMM").setExecutor(new ParticleCommands(this));
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[ParticleCommandMM]: Plugin is enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[ParticleCommandMM]: Plugin is disabled!");
    }
}
