package org.Deniable.GUI.CosmeticGUI.JoinMessages;

import org.Deniable.GUI.CosmeticGUI.CosmeticGUI;
import org.Deniable.Lobby;
import org.Deniable.Utils.PlayerConfig;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
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

        } else if (e.getView().getTitle().equals(Utils.format(CosmeticJoinM.MenuTitle))) { // Join messages title

            if (e.getRawSlot() == 12) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier1.1");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat1) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 13) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier1.2");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat2) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 15) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier1.3");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat3) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 16) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier1.4");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat4) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 21) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier2.1");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat5) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 22) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier2.2");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat6) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 24) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier2.3");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat7) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 25) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier2.4");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat8) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 30) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier3.1");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat9) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 31) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier3.2");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else {
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat10) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 33) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier3.3");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else{
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat11) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 34) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier3.4");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else{
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat12) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 39) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier4.1");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else{
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat13) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 40) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier4.2");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else{
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat14) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 42) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier4.3");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else{
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat15) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            } else if (e.getRawSlot() == 43) {// Snowball
                message = plugin.getConfig().getString("Cosmetics.Join.Message.Tier4.4");
                if (e.getClick().equals(ClickType.RIGHT)) {
                    PreviewJoinMessage.PreviewMessage(message , p);
                } else{
                    if (e.getCurrentItem().getType() == CosmeticJoinM.ItemMat16) {
                        p.closeInventory();
                        PlayerConfig.getConfig(p).set("Cosmetics.Join.Message", message);
                        p.sendMessage(Utils.format(plugin.getConfig().getString("Cosmetics.Join.Message.MessageUpdate").replace("<Message>", message)));
                        PlayerConfig.save();
                    } else {
                        e.setCancelled(true);
                    }
                }
            }

            if (e.getCurrentItem().getType() == Material.GRAY_DYE) {
                e.setCancelled(true);
            } else if (e.getCurrentItem().getType() == Material.OAK_SIGN) {
                e.setCancelled(true);
            }



        }
    }
}
