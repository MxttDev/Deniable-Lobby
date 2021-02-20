package org.Deniable.GUI.ProfileGUI;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.PlayerConfig;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class ProfileGUI {
    Lobby plugin;
    public Chat chat = null;

    public ProfileGUI(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    public static String MenuTitle = "&8My Profile";;

    private static int SLOTS = 27; // 9 (1) 18 (2) 27 (3) 36 (4) 45 (5) 54 (6)

    public static void openMainGUI(Player p) {
        Inventory GUI = Bukkit.createInventory(p, SLOTS, Utils.format(MenuTitle));

        ItemStack Item1 = new ItemStack(Material.LEGACY_SKULL_ITEM,1,(short) 3);

        SkullMeta itemmeta = (SkullMeta) Item1.getItemMeta();
        itemmeta.setOwner(p.getName());
        itemmeta.setDisplayName(Utils.format("&e"+p.getDisplayName()));

        ArrayList Lore1 = new ArrayList<String>();

        Lore1.add(Utils.format("&7 "));
        Lore1.add(Utils.format("&fRank: "+Utils.getRank(p)));
        Lore1.add(Utils.format("&fFirst Join:&e "+PlayerConfig.getConfig(p).getString("Stats.FirstJoin.Date")));
        Lore1.add(Utils.format("&a "));
        Lore1.add(Utils.format("&fDiscord:&e "+Utils.getDiscord(p)));
        Lore1.add(Utils.format("&b "));
        Lore1.add(Utils.format("&fLevel: &e0"));
        Lore1.add(Utils.format("&3 "));

        itemmeta.setLore(Lore1);

        Item1.setItemMeta(itemmeta);


        GUI.setItem(13, Item1);

        p.openInventory(GUI);

    }

}
