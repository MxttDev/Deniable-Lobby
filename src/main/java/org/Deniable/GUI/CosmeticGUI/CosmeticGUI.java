package org.Deniable.GUI.CosmeticGUI;

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

public class CosmeticGUI {
    Lobby plugin;
    private Chat chat = null;
    public CosmeticGUI(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    public static Material ItemMat1 =Material.BLAZE_POWDER; //Particles
    public static Material ItemMat2 =Material.ENCHANTED_BOOK; // Join message
    public static Material ItemMat3 =Material.GLOWSTONE_DUST; // Glow

    public static String MenuTitle = "&8Cosmetics (Lobby)";

    private static String Title1 = "&aParticles";
    private static String Title2 = "&aJoin Messages";
    private static String Title3 = "&aGlow effect"; // &e&lCosmetic &7(Right-Click)

    private static int SLOTS = 9; // 9 (1) 18 (2) 27 (3) 36 (4) 45 (5) 54 (6)

    public static void openMainGUI(Player p) {
        Inventory GUI = Bukkit.createInventory(p, SLOTS, Utils.format(MenuTitle));

        ItemStack Item1 = new ItemStack(ItemMat1);
        ItemStack Item2 = new ItemStack(ItemMat2);
        ItemStack Item3 = new ItemStack(ItemMat3);

        ItemMeta ItemMeta1 = Item1.getItemMeta();
        ItemMeta ItemMeta2 = Item2.getItemMeta();
        ItemMeta ItemMeta3 = Item3.getItemMeta();

        ItemMeta1.setDisplayName(Utils.format(Title1));
        ItemMeta2.setDisplayName(Utils.format(Title2));
        ItemMeta3.setDisplayName(Utils.format(Title3));


        ArrayList Lore1 = new ArrayList<String>();
        ArrayList Lore2 = new ArrayList<String>();
        ArrayList Lore3 = new ArrayList<String>();

        Lore1.add(Utils.format("&7 "));
        Lore1.add(Utils.format("&bParticles effects that follow you around!"));
        Lore1.add(Utils.format("&7 "));

        Lore2.add(Utils.format("&7 "));
        Lore2.add(Utils.format("&bCustomize your join messages!"));
        Lore2.add(Utils.format("&7 "));

        Lore3.add(Utils.format("&7 "));
        Lore3.add(Utils.format("&bPersistent glow effect in the lobby!"));
        Lore3.add(Utils.format("&7 "));

        ItemMeta1.setLore(Lore1);
        ItemMeta2.setLore(Lore2);
        ItemMeta3.setLore(Lore3);

        Item1.setItemMeta(ItemMeta1);
        Item2.setItemMeta(ItemMeta2);
        Item3.setItemMeta(ItemMeta3);

        GUI.setItem(0, Item3);
        GUI.setItem(4, Item2);
        GUI.setItem(8, Item1);

        p.openInventory(GUI);

    }








}
