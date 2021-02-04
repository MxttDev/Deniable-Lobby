package org.Deniable.Events.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.Deniable.GUI.CosmeticGUI.CosmeticGUI;
import org.Deniable.GUI.GMSelector.GMSelectorMain;
import org.Deniable.Utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Inventory implements Listener {
    ItemStack item1 = new ItemStack(Material.CHEST);
    ItemStack item2 = new ItemStack(Material.COMPASS);
    ItemStack item3 = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);

    @EventHandler
    public void onclick(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (p.getInventory().getItemInMainHand().getType() == Material.COMPASS) { // Open Server GUI
            GMSelectorMain.openMainGUI(p);
        } else if (p.getInventory().getItemInMainHand().getType() == Material.CHEST) { // open Cosmetic GUI
            CosmeticGUI.openMainGUI(p);
        } else if (p.getInventory().getItemInMainHand().getType() == Material.LEGACY_SKULL_ITEM) { // Open profile GUI
            p.closeInventory();
        }
    }



    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        ItemMeta itemmeta1 = item1.getItemMeta();
        ItemMeta itemmeta2 = item2.getItemMeta();
        SkullMeta itemmeta3 = (SkullMeta) item3.getItemMeta();

        itemmeta1.setDisplayName(Utils.format("&eCosmetics &8(Right Click)"));
        itemmeta2.setDisplayName(Utils.format("&eGamemode Selector &8(Right Click)"));
        itemmeta3.setDisplayName(Utils.format("&eMy profile &8(Right Click)"));
        itemmeta3.setOwner(p.getName());

        item1.setItemMeta(itemmeta1);
        item2.setItemMeta(itemmeta2);
        item3.setItemMeta(itemmeta3);

        e.getPlayer().getInventory().setItem(4, item1);
        e.getPlayer().getInventory().setItem(0, item2);
        e.getPlayer().getInventory().setItem(8, item3);

    }




}
