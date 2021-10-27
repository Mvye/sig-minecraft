package com.mvye.tntarrow.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack lightningArrow;

    public static void init() {
        createLightningArrow();
    }

    private static void createLightningArrow() {
        ItemStack item = new ItemStack(Material.ARROW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bLightning Arrow");
        List<String> lore = new ArrayList<>();
        lore.add("§5Legends say this arrow can summon lightning!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LURE, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        lightningArrow = item;

        // Shaped Recipe
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("lightning_arrow"), item);
        recipe.shape("TTT",
                     "TAT",
                     "TTT");
        recipe.setIngredient('T', Material.TNT);
        recipe.setIngredient('A', Material.ARROW);
        Bukkit.getServer().addRecipe(recipe);
    }
}
