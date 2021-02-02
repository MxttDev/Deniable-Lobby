package org.Deniable.GUI.AdminGUI.Server;

import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AdminGUIServer {

    private static int SLOTS = 27; // 9 (1) 18 (2) 27 (3) 36 (4) 45 (5) 54 (6)
    private static String MenuTitle = "&8SERVER";
    public static Material ItemMat1 =Material.ENCHANTED_BOOK;
    public static Material ItemMat2 =Material.CLOCK;
    public static Material BackMat =Material.ARROW;
    private static String Title1 = "&a&lRESET CONFIG";
    private static String Title2 = "&a&lSTOP SERVER";
    private static String Title3 = "&a&lBACK";

    public static void openAdminServerGUI(Player p) {
        Inventory GUI = Bukkit.createInventory(p, SLOTS, Utils.format(MenuTitle));

        ItemStack Item1 = new ItemStack(ItemMat1);
        ItemStack Item2 = new ItemStack(ItemMat2);
        ItemStack Back = new ItemStack(BackMat);

        ItemMeta ItemMeta1 = Item1.getItemMeta();
        ItemMeta ItemMeta2 = Item2.getItemMeta();
        ItemMeta BackMeta = Back.getItemMeta();

        ItemMeta1.setDisplayName(Utils.format(Title1));
        ItemMeta2.setDisplayName(Utils.format(Title2));
        BackMeta.setDisplayName(Utils.format(Title3));

        ArrayList Lore1 = new ArrayList<String>();
        ArrayList Lore2 = new ArrayList<String>();
        ArrayList Lore3 = new ArrayList<String>();

        Lore1.add(Utils.format("&7 "));
        Lore1.add(Utils.format("&bReset the server's config "));
        Lore1.add(Utils.format("&7 "));

        Lore2.add(Utils.format("&7 "));
        Lore2.add(Utils.format("&bStop the lobby server."));
        Lore2.add(Utils.format("&7 "));

        Lore3.add(Utils.format("&7 "));
        Lore3.add(Utils.format("&bReturn to the previous page."));
        Lore3.add(Utils.format("&7 "));

        ItemMeta1.setLore(Lore1);
        ItemMeta2.setLore(Lore2);
        BackMeta.setLore(Lore3);

        Item1.setItemMeta(ItemMeta1);
        Item2.setItemMeta(ItemMeta2);
        Back.setItemMeta(BackMeta);

        GUI.setItem(11, Item1);
        GUI.setItem(15, Item2);
        GUI.setItem(18, Back);

        p.openInventory(GUI);

    }
}
