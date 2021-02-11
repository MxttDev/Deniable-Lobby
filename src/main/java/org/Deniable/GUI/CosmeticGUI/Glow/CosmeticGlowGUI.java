package org.Deniable.GUI.CosmeticGUI.Glow;

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

public class CosmeticGlowGUI {

    Lobby plugin;
    private Chat chat = null;
    public CosmeticGlowGUI(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    public static Material ItemMat0 =Material.BARRIER;
    public static Material ItemMat1 =Material.SUNFLOWER; // Glow effect 1
    public static Material ItemMat2 =Material.SLIME_BALL; // Glow effect 2
    public static Material ItemMat3 =Material.APPLE; // Glow effect 3
    public static Material ItemMat4 =Material.ENCHANTED_GOLDEN_APPLE; // Glow effect 4

    public static String MenuTitle = "&8Glow Menu";

    private static String Title0 = "&aRemove Glow";
    private static String Title1 = "&aGray Glow";
    private static String Title2 = "&aAqua Glow";
    private static String Title3 = "&aPink Glow"; // &e&lCosmetic &7(Right-Click)
    private static String Title4 = "&aRed Glow"; // &e&lCosmetic &7(Right-Click)

    private static int SLOTS = 27; // 9 (1) 18 (2) 27 (3) 36 (4) 45 (5) 54 (6)

    public static void openMainGUI(Player p) {
        Inventory GUI = Bukkit.createInventory(p, SLOTS, Utils.format(MenuTitle));

        ItemStack Item0 = new ItemStack(ItemMat0);
        ItemStack Item1 = new ItemStack(ItemMat1);
        ItemStack Item2 = new ItemStack(ItemMat2);
        ItemStack Item3 = new ItemStack(ItemMat3);
        ItemStack Item4 = new ItemStack(ItemMat4);

        ItemMeta ItemMeta0 = Item0.getItemMeta();
        ItemMeta ItemMeta1 = Item1.getItemMeta();
        ItemMeta ItemMeta2 = Item2.getItemMeta();
        ItemMeta ItemMeta3 = Item3.getItemMeta();
        ItemMeta ItemMeta4 = Item4.getItemMeta();

        ItemMeta0.setDisplayName(Utils.format(Title0));
        ItemMeta1.setDisplayName(Utils.format(Title1));
        ItemMeta2.setDisplayName(Utils.format(Title2));
        ItemMeta3.setDisplayName(Utils.format(Title3));
        ItemMeta4.setDisplayName(Utils.format(Title4));

        ArrayList Lore0 = new ArrayList<String>();
        ArrayList Lore1 = new ArrayList<String>();
        ArrayList Lore2 = new ArrayList<String>();
        ArrayList Lore3 = new ArrayList<String>();
        ArrayList Lore4 = new ArrayList<String>();

        Lore0.add(Utils.format("&7 "));
        Lore0.add(Utils.format("&bRemove all of your glow effects."));
        Lore0.add(Utils.format("&7 "));

        Lore1.add(Utils.format("&7 "));
        Lore1.add(Utils.format("&bEquip this glow effect in the lobby!"));
        Lore1.add(Utils.format("&7 "));
        Lore1.add(Utils.format("&7Requires &A[VIP]"));
        Lore1.add(Utils.format("&7 "));

        Lore2.add(Utils.format("&7 "));
        Lore2.add(Utils.format("&bEquip this glow effect in the lobby!"));
        Lore2.add(Utils.format("&7 "));
        Lore2.add(Utils.format("&7Requires &e[ELITE] "));
        Lore2.add(Utils.format("&7 "));

        Lore3.add(Utils.format("&7 "));
        Lore3.add(Utils.format("&bPersistent glow effect in the lobby!"));
        Lore3.add(Utils.format("&7 "));
        Lore3.add(Utils.format("&7Requires &d[ULTRA]"));
        Lore3.add(Utils.format("&7 "));

        Lore4.add(Utils.format("&7 "));
        Lore4.add(Utils.format("&bPersistent glow effect in the lobby!"));
        Lore4.add(Utils.format("&7 "));
        Lore4.add(Utils.format("&7Requires &6[LEGEND]"));
        Lore4.add(Utils.format("&7 "));

        ItemMeta1.setLore(Lore0);
        ItemMeta1.setLore(Lore1);
        ItemMeta2.setLore(Lore2);
        ItemMeta3.setLore(Lore3);
        ItemMeta4.setLore(Lore4);

        Item0.setItemMeta(ItemMeta0);
        Item1.setItemMeta(ItemMeta1);
        Item2.setItemMeta(ItemMeta2);
        Item3.setItemMeta(ItemMeta3);
        Item4.setItemMeta(ItemMeta4);



        GUI.setItem(13, Item0); // back
        GUI.setItem(10, Item1); // gray g
        GUI.setItem(11, Item2); // aqua
        GUI.setItem(15, Item3); // pink
        GUI.setItem(16, Item4); // red
        GUI.setItem(18, Utils.backArrow());

        p.openInventory(GUI);

    }
}
