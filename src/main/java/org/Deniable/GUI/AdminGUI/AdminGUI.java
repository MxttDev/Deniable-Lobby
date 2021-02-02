package org.Deniable.GUI.AdminGUI;

import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AdminGUI {

    private static int SLOTS = 27; // 9 (1) 18 (2) 27 (3) 36 (4) 45 (5) 54 (6)
    private static String MenuTitle = "&8ADMIN GUI";
    public static Material ServerItemMat =Material.NETHER_STAR;
    public static Material PlayerItemMat =Material.WITHER_SKELETON_SKULL;
    private static String ServerTitle = "&a&lSERVER";
    private static String PlayerTitle = "&a&lPLAYER";

    public static void openAdminGUI(Player p) {
        Inventory GUI = Bukkit.createInventory(p, SLOTS, Utils.format(MenuTitle));

        ItemStack ServerItem = new ItemStack(ServerItemMat);
        ItemStack PlayerItem = new ItemStack(PlayerItemMat);

        ItemMeta ServerItemMeta = ServerItem.getItemMeta();
        ItemMeta PlayerItemMeta = PlayerItem.getItemMeta();

        ServerItemMeta.setDisplayName(Utils.format(ServerTitle));
        PlayerItemMeta.setDisplayName(Utils.format(PlayerTitle));

        ArrayList ServerLore = new ArrayList<String>();
        ArrayList PlayerLore = new ArrayList<String>();

        ServerLore.add(Utils.format("&7 "));
        ServerLore.add(Utils.format("&bManage server-side events. "));
        ServerLore.add(Utils.format("&7 "));

        PlayerLore.add(Utils.format("&7 "));
        PlayerLore.add(Utils.format("&bManage server players. "));
        PlayerLore.add(Utils.format("&7 "));

        ServerItemMeta.setLore(ServerLore);
        PlayerItemMeta.setLore(PlayerLore);

        ServerItem.setItemMeta(ServerItemMeta);
        PlayerItem.setItemMeta(PlayerItemMeta);

        GUI.setItem(11, ServerItem);
        GUI.setItem(15, PlayerItem);

        p.openInventory(GUI);

    }



}
