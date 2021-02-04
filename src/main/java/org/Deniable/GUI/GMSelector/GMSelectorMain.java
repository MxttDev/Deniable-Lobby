package org.Deniable.GUI.GMSelector;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GMSelectorMain {
    Lobby plugin;
    private Chat chat = null;
    public GMSelectorMain(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    public static Material ItemMat1 =Material.BLAZE_POWDER; // SMP

    private static String MenuTitle = "&8Gamemode Menu";

    private static String Title1 = "&aSMP ";

    private static int SLOTS = 27; // 9 (1) 18 (2) 27 (3) 36 (4) 45 (5) 54 (6)

    public static void openMainGUI(Player p) {
        Inventory GUI = Bukkit.createInventory(p, SLOTS, Utils.format(MenuTitle));

        ItemStack Item1 = new ItemStack(ItemMat1);

        ItemMeta ItemMeta1 = Item1.getItemMeta();

        ItemMeta1.setDisplayName(Utils.format(Title1));

        ArrayList Lore1 = new ArrayList<String>();
        ArrayList Lore2 = new ArrayList<String>();
        ArrayList Lore3 = new ArrayList<String>();

        Lore1.add(Utils.format("&7 "));
        Lore1.add(Utils.format("&7Explore, discover and build"));
        Lore1.add(Utils.format("&7amazing things with your friends!"));
        Lore1.add(Utils.format("&7Survival with your friends!"));
        Lore1.add(Utils.format("&7 "));
        Lore1.add(Utils.format("&bClick to join."));
        Lore1.add(Utils.format("&7"+Utils.getServerCount(p,"SMP")+" currently playing!"));

        ItemMeta1.setLore(Lore1);

        Item1.setItemMeta(ItemMeta1);


        GUI.setItem(13, Item1);

        p.openInventory(GUI);

    }

}
