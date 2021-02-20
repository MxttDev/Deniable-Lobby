package org.Deniable.GUI.AdminGUI;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.GUI.AdminGUI.Player.AdminGUIPlayer;
import org.Deniable.GUI.AdminGUI.Server.AdminGUIServer;
import org.Deniable.Lobby;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class AdminGUIManager implements Listener {

    Lobby plugin;
    private Chat chat = null;

    public AdminGUIManager(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();
        Player p = (Player) e.getWhoClicked();

        if (inv.contains(AdminGUI.ServerItemMat) && inv.contains(AdminGUI.PlayerItemMat)) {
            if (e.getCurrentItem().getType().equals(AdminGUI.ServerItemMat)) { // SERVER ITEM
                AdminGUIServer.openAdminServerGUI(p);
            } else if (e.getCurrentItem().getType().equals(AdminGUI.PlayerItemMat)) {
                AdminGUIPlayer.openAdminServerGUI(p);
            }
        } else if (inv.contains(AdminGUIServer.ItemMat1) && inv.contains(AdminGUIServer.ItemMat2)) {
            if (e.getCurrentItem().getType().equals(AdminGUIServer.ItemMat1)) { // RESET CONFIG
                plugin.ReloadTheConfig();

                p.sendMessage(Utils.format("&aConfig has been reset."));
                p.closeInventory();
            } else if (e.getCurrentItem().getType().equals(AdminGUIServer.ItemMat2)) { // STOP SERVER
                Bukkit.getServer().shutdown();
                p.closeInventory();
            } else if (e.getCurrentItem().getType().equals(AdminGUIServer.BackMat)) {
                AdminGUI.openAdminGUI(p);
            }

        } else {
            //no
        }
    }
}
