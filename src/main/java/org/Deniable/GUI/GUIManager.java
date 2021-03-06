package org.Deniable.GUI;

import org.Deniable.GUI.CosmeticGUI.CosmeticGUI;
import org.Deniable.GUI.CosmeticGUI.Glow.CosmeticGlowGUI;
import org.Deniable.GUI.CosmeticGUI.JoinMessages.CosmeticJoinM;
import org.Deniable.GUI.GMSelector.GMSelectorMain;
import org.Deniable.GUI.ProfileGUI.ProfileGUI;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIManager implements Listener {


    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        final Player p = (Player) e.getWhoClicked();
        final ItemStack clickedItem = e.getCurrentItem();

        if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

        if (e.getView().getTitle().equals(Utils.format(GMSelectorMain.MenuTitle))) { //Gamemode Selector
            if (e.getCurrentItem().getType() == GMSelectorMain.ItemMat1) { // SMP ICON
                Utils.serverSend("SMP", p); // connect player to smp server
            }
        } else if (e.getView().getTitle().equals(Utils.format(CosmeticGUI.MenuTitle))) { // Cosmetic Menu
            if (e.getCurrentItem().getType() == CosmeticGUI.ItemMat3) {// GLOW ICON
                p.closeInventory();
                CosmeticGlowGUI.openMainGUI(p);
            } else if (e.getCurrentItem().getType() == CosmeticGUI.ItemMat2) { // Join Messages Icon
                p.closeInventory();
                CosmeticJoinM.openMainGUI(p);
            } else if (e.getCurrentItem().getType() == CosmeticGUI.ItemMat1) { // PARTICLES
                p.closeInventory();
                p.sendMessage(Utils.format("&aWIP"));
            }
        } else if (e.getView().getTitle().equals(Utils.format(CosmeticGlowGUI.MenuTitle))) { // Cosmetic Glow menu
            if (e.getCurrentItem().getType() == Utils.backArrow().getType()) {
                p.closeInventory();
                CosmeticGUI.openMainGUI(p);
            }
        } else if (e.getView().getTitle().equals(Utils.format(CosmeticJoinM.MenuTitle))) {
            if (e.getCurrentItem().getType() == Utils.backArrow().getType()) {
                p.closeInventory();
                CosmeticGUI.openMainGUI(p);
            }
        } else if (e.getView().getTitle().equals(Utils.format(ProfileGUI.MenuTitle))) {
            if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                p.closeInventory();
            }
        }
    }
}
