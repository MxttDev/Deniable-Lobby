package org.Deniable.GUI.CosmeticGUI.Glow;

import org.Deniable.Utils.Glow;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class CosmeticGlowSET implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();

        if (e.getView().getTitle().equals(Utils.format(CosmeticGlowGUI.MenuTitle))) {
            if (e.getCurrentItem().getType() == CosmeticGlowGUI.ItemMat1) { // SUNFLOWER (GRAY GLOW)
                p.closeInventory();

                Glow.setGlow(p, ChatColor.GRAY);
                p.sendMessage(Utils.format("&bYou have set your glow to Gray!"));

            } else if (e.getCurrentItem().getType() == CosmeticGlowGUI.ItemMat2) { // SLIME BALL (AQUA)
                p.closeInventory();

                Glow.setGlow(p, ChatColor.AQUA);
                p.sendMessage(Utils.format("&bYou have set your glow to Aqua!"));

            } else if (e.getCurrentItem().getType() == CosmeticGlowGUI.ItemMat3) { // APPLE (PINK)
                p.closeInventory();

                Glow.setGlow(p, ChatColor.LIGHT_PURPLE);
                p.sendMessage(Utils.format("&bYou have set your glow to Pink!"));

            } else if (e.getCurrentItem().getType() == CosmeticGlowGUI.ItemMat4) { // GOLDEN APPLE (RED)
                p.closeInventory();

                Glow.setGlow(p, ChatColor.RED);
                p.sendMessage(Utils.format("&bYou have set your glow to Red!"));

            } else if (e.getCurrentItem().getType() == CosmeticGlowGUI.ItemMat0) { // Barrier
                p.closeInventory();
                Glow.removeGlow(p);
                p.sendMessage(Utils.format("&bYou have removed your glow!"));
            }
        }

    }
}
