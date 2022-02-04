package com.mvye.firstplugin;

import com.mvye.firstplugin.events.EventsMeetingTwo;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class FirstPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventsMeetingTwo(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[FirstPlugin]: Plugin is enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[FirstPlugin]: Plugin is disabled!");
    }
}
