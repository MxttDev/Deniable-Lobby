package org.Deniable.GUI;

import org.Deniable.GUI.CosmeticGUI.CosmeticGUI;
import org.Deniable.GUI.CosmeticGUI.Glow.CosmeticGlowGUI;
import org.Deniable.GUI.CosmeticGUI.JoinMessages.CosmeticJoinM;
import org.Deniable.GUI.GMSelector.GMSelectorMain;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class GUIManager implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();

        if (e.getCurrentItem() == null) {
            //do nothing
        } else if (e.getView().getTitle().equals(Utils.format(GMSelectorMain.MenuTitle))) { //Gamemode Selector
            if (e.getCurrentItem().getType() == GMSelectorMain.ItemMat1) { // SMP ICON
                Utils.serverSend("SMP", p); // connect player to smp server
            }
        } else if (e.getView().getTitle().equals(Utils.format(CosmeticGUI.MenuTitle))) { // Cosmetic Menu
            if (e.getCurrentItem().getType() == CosmeticGUI.ItemMat3) {// GLOW ICON
                CosmeticGlowGUI.openMainGUI(p);
            } else if (e.getCurrentItem().getType() == CosmeticGUI.ItemMat2) { // Join Messages Icon
                CosmeticJoinM.openMainGUI(p);
            }
        } else if (e.getView().getTitle().equals(Utils.format(CosmeticGlowGUI.MenuTitle))) { // Cosmetic Glow menu
            if (e.getCurrentItem().getType() == Utils.backArrow().getType()) {
                CosmeticGUI.openMainGUI(p);
            }
        } else if (e.getView().getTitle().equals(Utils.format(CosmeticJoinM.MenuTitle))) {
            if (e.getCurrentItem().getType() == Utils.backArrow().getType()) {
                CosmeticGUI.openMainGUI(p);
            }

        }
    }
}
