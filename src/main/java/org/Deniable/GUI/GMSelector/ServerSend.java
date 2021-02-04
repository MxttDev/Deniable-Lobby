package org.Deniable.GUI.GMSelector;

import org.Deniable.Utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ServerSend implements Listener {

    @EventHandler
    public void ServerSend(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();

        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);

        if (inv.contains(GMSelectorMain.ItemMat1)) {
            if (e.getCurrentItem().getType().equals(GMSelectorMain.ItemMat1)) {
                p.closeInventory();
                Utils.serverSend("SMP", p);
            }
        }



    }


}
