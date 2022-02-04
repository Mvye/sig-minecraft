package com.mvye.firstplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EventsMeetingTwo implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.AQUA +"welcome to sig-minecraft minecraft server!! :D");
    }

    @EventHandler
    public static void onPlayerDamageBySpider(EntityDamageByEntityEvent event) {
        if (event.getEntityType() == EntityType.PLAYER) {
            Player player = (Player)event.getEntity();
            int min = 1;
            int max = 100;
            int CHANCE = (int)Math.floor(Math.random()*(max-min+1)+min);
            if (event.getDamager().getType() == EntityType.SPIDER) {
                if (CHANCE == 2) {
                    PotionEffect spidermanTime = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0);
                    player.addPotionEffect(spidermanTime);
                }
            }
            if (event.getDamager().getType() == EntityType.CAVE_SPIDER) {
                if (CHANCE == 2) {
                    PotionEffect superSpidermanTime = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1);
                    player.addPotionEffect(superSpidermanTime);
                }
            }
        }
    }
}
