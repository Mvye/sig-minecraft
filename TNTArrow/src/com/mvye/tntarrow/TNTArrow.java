package com.mvye.tntarrow;

import com.mvye.tntarrow.events.TNTarrow;
import com.mvye.tntarrow.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class TNTArrow extends JavaPlugin {
    @Override
    public void onEnable() {
        ItemManager.init();
        getServer().getPluginManager().registerEvents(new TNTarrow(this), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[TNTArrow]: Plugin is enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[TNTArrow]: Plugin is disabled!");
    }
}
