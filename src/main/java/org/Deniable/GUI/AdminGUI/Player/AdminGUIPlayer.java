package org.Deniable.GUI.AdminGUI.Player;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class AdminGUIPlayer {

    Lobby plugin;
    public Chat chat = null;

    public AdminGUIPlayer(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    private static int SLOTS = 54; // 9 (1) 18 (2) 27 (3) 36 (4) 45 (5) 54 (6)
    private static String MenuTitle = "&8Player";
    public static Material BackMat =Material.ARROW;
    private static String Title1 = "&a&lRESET CONFIG";
    private static int slot;
    private static String value;


    public static void openAdminServerGUI(Player p) {
        Inventory GUI = Bukkit.createInventory(p, SLOTS, Utils.format(MenuTitle));
        for (Player a : Bukkit.getOnlinePlayers()) {
            slot++;
            ItemStack item = new ItemStack(Material.LEGACY_SKULL_ITEM,1,(short) 3);
            SkullMeta itemmeta = (SkullMeta) item.getItemMeta();
            itemmeta.setOwner(a.getName());
            itemmeta.setDisplayName(Utils.format("&e"+a.getName()));

            ArrayList Lore1 = new ArrayList<String>();

            Lore1.add(Utils.format("&7 "));

            Lore1.add(Utils.format("&b "));
            Lore1.add(Utils.format("&fDiscord: &e"+ Utils.getDiscord(a)));
            Lore1.add(Utils.format("&7 "));

            itemmeta.setLore(Lore1);
            item.setItemMeta(itemmeta);

            GUI.setItem(slot, item);
        }
        slot = 0;

        p.openInventory(GUI);

    }

}
