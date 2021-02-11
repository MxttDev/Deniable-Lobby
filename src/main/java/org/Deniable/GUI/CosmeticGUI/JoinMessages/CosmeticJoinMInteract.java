package org.Deniable.GUI.CosmeticGUI.JoinMessages;

import org.Deniable.GUI.CosmeticGUI.CosmeticGUI;
import org.Deniable.Lobby;
import org.Deniable.Utils.PlayerConfig;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CosmeticJoinMInteract implements Listener {

    public static Lobby plugin = Lobby.getPlugin(Lobby.class);

    @EventHandler(ignoreCancelled = true)
    public void onInteract(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        String message;

        if (e.getCurrentItem() == null) {
            //do nothing

        } else if (e.getView().getTitle().equals(Utils.format(CosmeticJoinM.MenuTitle))) { // Join messages title
            if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat1) { // Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier1.1");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat2) { // Redstone
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier1.2");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat3) { // Stick
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier1.3");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat4) { // Feather
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier1.4");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat5) { // bone meal
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier2.1");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat6) { // bone
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier2.2");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat7) { // music disc chirp
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier2.3");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat8) { // egg
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier2.4");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat9) { // xp bottle
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier3.1");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat10) { // slime ball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier3.2");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat11) { // sugar cane
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier3.3");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat12) { // golden apple
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier3.4");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat13) { // end crystal
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier4.1");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat14) { //ender eye
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier4.2");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat15) { // wither skeleton
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier4.3");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat16) { // blazw podwer
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier4.4");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    p.closeInventory();
                    PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                    p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                    PlayerConfig.save();
                }
            } else {
                e.setCancelled(true);
            }
        }
    }
}
