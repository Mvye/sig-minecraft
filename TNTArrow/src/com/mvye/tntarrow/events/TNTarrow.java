package com.mvye.tntarrow.events;

import com.mvye.tntarrow.items.ItemManager;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class TNTarrow implements Listener {

    private static Plugin plugin;
    private static ItemStack lightningArrow = new ItemStack(ItemManager.lightningArrow);

    public TNTarrow(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public static void onProjectileHit(EntityShootBowEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getProjectile() instanceof Arrow) {
                if (event.getEntity().getWorld().getName() == event.getProjectile().getWorld().getName()) {
                    Arrow arrow = (Arrow) event.getProjectile();
                    Inventory inventory = ((Player) event.getEntity()).getInventory();
                    if (inventory.contains(lightningArrow)) {
                        inventory.remove(lightningArrow);
                        new LightningArrowTask(arrow).runTaskTimer(plugin, 0, 1);
                    }
                }
            }
        }
    }
}
