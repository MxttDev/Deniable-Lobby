package org.Deniable.GUI.CosmeticGUI.JoinMessages;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Events.Player.JoinBasics;
import org.Deniable.Lobby;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CosmeticJoinM {

    public static Lobby plugin = Lobby.getPlugin(Lobby.class);
    public static Chat chat = plugin.getChat();

    public static Material ItemMat1 =Material.SNOWBALL; //                TIER 1
    public static Material ItemMat2 =Material.REDSTONE; //                TIER 1
    public static Material ItemMat3 =Material.STICK; //                   TIER 1
    public static Material ItemMat4 =Material.FEATHER; //                 TIER 1
    public static Material ItemMat5 =Material.BONE_MEAL;//              TIER 2
    public static Material ItemMat6 =Material.BONE; //                  TIER 2
    public static Material ItemMat7 =Material.MUSIC_DISC_CHIRP; //      TIER 2
    public static Material ItemMat8 =Material.EGG; //                   TIER 2
    public static Material ItemMat9 =Material.EXPERIENCE_BOTTLE; //       TIER 3
    public static Material ItemMat10 =Material.SLIME_BALL; //             TIER 3
    public static Material ItemMat11 =Material.SUGAR_CANE; //             TIER 3
    public static Material ItemMat12 =Material.GOLDEN_APPLE; //           TIER 3
    public static Material ItemMat13 =Material.END_CRYSTAL; //          TIER 4
    public static Material ItemMat14 =Material.ENDER_EYE; //            TIER 4
    public static Material ItemMat15 =Material.WITHER_SKELETON_SKULL;// TIER 4
    public static Material ItemMat16 =Material.BLAZE_POWDER; //         TIER 4

    public static String MenuTitle = "&8Join Messages";

    private static int SLOTS = 54; // 9 (1) 18 (2) 27 (3) 36 (4) 45 (5) 54 (6)

    public static void openMainGUI(Player p) {
        Inventory GUI = Bukkit.createInventory(p, SLOTS, Utils.format(MenuTitle));

        String Message1 = "&b<player> has appeared!";
        String Message2 = "&b<player> has entered the server!";

        ItemStack Sign1 = new ItemStack(Material.OAK_SIGN);
        ItemStack Sign2 = new ItemStack(Material.OAK_SIGN);
        ItemStack Sign3 = new ItemStack(Material.OAK_SIGN);
        ItemStack Sign4 = new ItemStack(Material.OAK_SIGN);

        ItemStack none1 = new ItemStack(Material.GRAY_DYE);
        ItemStack none2 = new ItemStack(Material.GRAY_DYE);
        ItemStack none3 = new ItemStack(Material.GRAY_DYE);
        ItemStack none4 = new ItemStack(Material.GRAY_DYE);


        ItemStack Item1 = new ItemStack(ItemMat1);
        ItemStack Item2 = new ItemStack(ItemMat2);
        ItemStack Item3 = new ItemStack(ItemMat3);
        ItemStack Item4 = new ItemStack(ItemMat4);
        ItemStack Item5 = new ItemStack(ItemMat5);
        ItemStack Item6 = new ItemStack(ItemMat6);
        ItemStack Item7 = new ItemStack(ItemMat7);
        ItemStack Item8 = new ItemStack(ItemMat8);
        ItemStack Item9 = new ItemStack(ItemMat9);
        ItemStack Item10 = new ItemStack(ItemMat10);
        ItemStack Item11 = new ItemStack(ItemMat11);
        ItemStack Item12 = new ItemStack(ItemMat12);
        ItemStack Item13 = new ItemStack(ItemMat13);
        ItemStack Item14 = new ItemStack(ItemMat14);
        ItemStack Item15 = new ItemStack(ItemMat15);
        ItemStack Item16 = new ItemStack(ItemMat16);

        ItemMeta ItemMeta1 =  Item1.getItemMeta();
        ItemMeta ItemMeta2 =  Item2.getItemMeta();
        ItemMeta ItemMeta3 =  Item3.getItemMeta();
        ItemMeta ItemMeta4 =  Item4.getItemMeta(); //
        ItemMeta ItemMeta5 =   Item5.getItemMeta();
        ItemMeta ItemMeta6 =   Item6.getItemMeta();
        ItemMeta ItemMeta7 =   Item7.getItemMeta();
        ItemMeta ItemMeta8 =   Item8.getItemMeta(); //
        ItemMeta ItemMeta9 =  Item9.getItemMeta();
        ItemMeta ItemMeta10 = Item10.getItemMeta();
        ItemMeta ItemMeta11 = Item11.getItemMeta();
        ItemMeta ItemMeta12 = Item12.getItemMeta(); //
        ItemMeta ItemMeta13 =  Item13.getItemMeta();
        ItemMeta ItemMeta14 =  Item14.getItemMeta();
        ItemMeta ItemMeta15 =  Item15.getItemMeta();
        ItemMeta ItemMeta16 =  Item16.getItemMeta();

        ItemMeta OakMeta1 = Sign1.getItemMeta();
        ItemMeta OakMeta2 = Sign2.getItemMeta();
        ItemMeta OakMeta3 = Sign3.getItemMeta();
        ItemMeta OakMeta4 = Sign4.getItemMeta();

        ItemMeta noneMeta1 = none1.getItemMeta();
        ItemMeta noneMeta2 = none2.getItemMeta();
        ItemMeta noneMeta3 = none3.getItemMeta();
        ItemMeta noneMeta4 = none4.getItemMeta();

        OakMeta1.setDisplayName(Utils.format("&eTier 1"));
        OakMeta2.setDisplayName(Utils.format("&eTier 2"));
        OakMeta3.setDisplayName(Utils.format("&eTier 3"));
        OakMeta4.setDisplayName(Utils.format("&eTier 4"));

        ItemMeta1.setDisplayName(Utils.format("&cTier 1"));
        ItemMeta2.setDisplayName(Utils.format("&cTier 1"));
        ItemMeta3.setDisplayName(Utils.format("&cTier 1"));
        ItemMeta4.setDisplayName(Utils.format("&cTier 1"));

        ItemMeta5.setDisplayName(Utils.format("&cTier 2"));
        ItemMeta6.setDisplayName(Utils.format("&cTier 2"));
        ItemMeta7.setDisplayName(Utils.format("&cTier 2"));
        ItemMeta8.setDisplayName(Utils.format("&cTier 2"));

        ItemMeta9.setDisplayName(Utils.format("&cTier 3"));
        ItemMeta10.setDisplayName(Utils.format("&cTier 3"));
        ItemMeta11.setDisplayName(Utils.format("&cTier 3"));
        ItemMeta12.setDisplayName(Utils.format("&cTier 3"));

        ItemMeta13.setDisplayName(Utils.format("&cTier 4"));
        ItemMeta14.setDisplayName(Utils.format("&cTier 4"));
        ItemMeta15.setDisplayName(Utils.format("&cTier 4"));
        ItemMeta16.setDisplayName(Utils.format("&cTier 4"));

        noneMeta1.setDisplayName(Utils.format("&cNot unlocked"));
        noneMeta2.setDisplayName(Utils.format("&cNot unlocked"));
        noneMeta3.setDisplayName(Utils.format("&cNot unlocked"));
        noneMeta4.setDisplayName(Utils.format("&cNot unlocked"));

        ArrayList Lore1 = new ArrayList<String>();
        ArrayList Lore2 = new ArrayList<String>();
        ArrayList Lore3 = new ArrayList<String>();
        ArrayList Lore4 = new ArrayList<String>();

        ArrayList Lore5 = new ArrayList<String>();
        ArrayList Lore6 = new ArrayList<String>();
        ArrayList Lore7 = new ArrayList<String>();
        ArrayList Lore8 = new ArrayList<String>();

        for (String lore1 : plugin.getConfig().getStringList("Cosmetics.Join.Tier1.Lore")) {
            Lore1.add(Utils.format(lore1));
        }
        for (String lore2 : plugin.getConfig().getStringList("Cosmetics.Join.Tier2.Lore")) {
            Lore2.add(Utils.format(lore2));
        }
        for (String lore3 : plugin.getConfig().getStringList("Cosmetics.Join.Tier3.Lore")) {
            Lore3.add(Utils.format(lore3));
        }
        for (String lore4 : plugin.getConfig().getStringList("Cosmetics.Join.Tier4.Lore")) {
            Lore4.add(Utils.format(lore4));
        }

        for (String lore5 : plugin.getConfig().getStringList("Cosmetics.Join.Disabled.Tier1")) {
            Lore5.add(Utils.format(lore5));
        }
        for (String lore6 : plugin.getConfig().getStringList("Cosmetics.Join.Disabled.Tier2")) {
            Lore6.add(Utils.format(lore6));
        }
        for (String lore7 : plugin.getConfig().getStringList("Cosmetics.Join.Disabled.Tier3")) {
            Lore7.add(Utils.format(lore7));
        }
        for (String lore8 : plugin.getConfig().getStringList("Cosmetics.Join.Disabled.Tier4")) {
            Lore8.add(Utils.format(lore8));
        }


        OakMeta1.addEnchant(Enchantment.LURE,1,true);
        OakMeta2.addEnchant(Enchantment.LURE,1,true);
        OakMeta3.addEnchant(Enchantment.LURE,1,true);
        OakMeta4.addEnchant(Enchantment.LURE,1,true);

        OakMeta1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        OakMeta2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        OakMeta3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        OakMeta4.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ItemMeta1.setLore(Lore1);
        ItemMeta2.setLore(Lore1);
        ItemMeta3.setLore(Lore1);
        ItemMeta4.setLore(Lore1);
        ItemMeta5.setLore(Lore2);
        ItemMeta6.setLore(Lore2);
        ItemMeta7.setLore(Lore2);
        ItemMeta8.setLore(Lore2);
        ItemMeta9.setLore(Lore3);
        ItemMeta10.setLore(Lore3);
        ItemMeta11.setLore(Lore3);
        ItemMeta12.setLore(Lore3);
        ItemMeta13.setLore(Lore4);
        ItemMeta14.setLore(Lore4);
        ItemMeta15.setLore(Lore4);
        ItemMeta16.setLore(Lore4);
        noneMeta1.setLore(Lore1);
        noneMeta2.setLore(Lore2);
        noneMeta3.setLore(Lore3);
        noneMeta4.setLore(Lore4);

        Sign1.setItemMeta(OakMeta1);
        Sign2.setItemMeta(OakMeta2);
        Sign3.setItemMeta(OakMeta3);
        Sign4.setItemMeta(OakMeta4);

        none1.setItemMeta(noneMeta1);
        none2.setItemMeta(noneMeta2);
        none3.setItemMeta(noneMeta3);
        none4.setItemMeta(noneMeta4);

        Item1.setItemMeta(ItemMeta1);
        Item2.setItemMeta(ItemMeta2);
        Item3.setItemMeta(ItemMeta3);
        Item4.setItemMeta(ItemMeta4);
        Item5.setItemMeta(ItemMeta5);
        Item6.setItemMeta(ItemMeta6);
        Item7.setItemMeta(ItemMeta7);
        Item8.setItemMeta(ItemMeta8);
        Item9.setItemMeta(ItemMeta9);
        Item10.setItemMeta(ItemMeta10);
        Item11.setItemMeta(ItemMeta11);
        Item12.setItemMeta(ItemMeta12);
        Item13.setItemMeta(ItemMeta13);
        Item14.setItemMeta(ItemMeta14);
        Item15.setItemMeta(ItemMeta15);
        Item16.setItemMeta(ItemMeta16);

        GUI.setItem(10,Sign1);
        GUI.setItem(19,Sign2);
        GUI.setItem(28,Sign3);
        GUI.setItem(37,Sign4);

        GUI.setItem(12,none1);
        GUI.setItem(13,none1);
        GUI.setItem(15,none1);
        GUI.setItem(16,none1);
        GUI.setItem(21,none2);
        GUI.setItem(22,none2);
        GUI.setItem(24,none2);
        GUI.setItem(25,none2);
        GUI.setItem(30,none3);
        GUI.setItem(31,none3);
        GUI.setItem(33,none3);
        GUI.setItem(34,none3);
        GUI.setItem(39,none4);
        GUI.setItem(40,none4);
        GUI.setItem(42,none4);
        GUI.setItem(43,none4);

        if (JoinBasics.Permission.get(p.getUniqueId()) == 1) {
            GUI.setItem(12, Item1); // SNOWBALL
            GUI.setItem(13, Item2); // REDSTONE
            GUI.setItem(15, Item3); // STICK
            GUI.setItem(16, Item4); // FEATHER

        } else if (JoinBasics.Permission.get(p.getUniqueId()) == 2) {
            GUI.setItem(12, Item1); // SNOWBALL
            GUI.setItem(13, Item2); // REDSTONE
            GUI.setItem(15, Item3); // STICK
            GUI.setItem(16, Item4); // FEATHER
            GUI.setItem(21, Item5); // BONE MEAL
            GUI.setItem(22, Item6); // BONE
            GUI.setItem(24, Item7); // gray g
            GUI.setItem(25, Item8); // gray g
        } else if (JoinBasics.Permission.get(p.getUniqueId()) == 3) {
            GUI.setItem(12, Item1); // SNOWBALL
            GUI.setItem(13, Item2); // REDSTONE
            GUI.setItem(15, Item3); // STICK
            GUI.setItem(16, Item4); // FEATHER
            GUI.setItem(21, Item5); // BONE MEAL
            GUI.setItem(22, Item6); // BONE
            GUI.setItem(24, Item7); // gray g
            GUI.setItem(25, Item8); // gray g
            GUI.setItem(30, Item9); // BONE MEAL
            GUI.setItem(31, Item10); // BONE
            GUI.setItem(33, Item11); // gray g
            GUI.setItem(34, Item12); // gray g
        } else if (JoinBasics.Permission.get(p.getUniqueId()) == 4) {
            GUI.setItem(12, Item1); // SNOWBALL
            GUI.setItem(13, Item2); // REDSTONE
            GUI.setItem(15, Item3); // STICK
            GUI.setItem(16, Item4); // FEATHER
            GUI.setItem(21, Item5); // BONE MEAL
            GUI.setItem(22, Item6); // BONE
            GUI.setItem(24, Item7); // gray g
            GUI.setItem(25, Item8); // gray g
            GUI.setItem(30, Item9); // BONE MEAL
            GUI.setItem(31, Item10); // BONE
            GUI.setItem(33, Item11); // gray g
            GUI.setItem(34, Item12); // gray g
            GUI.setItem(39, Item13); // BONE MEAL
            GUI.setItem(40, Item14); // BONE
            GUI.setItem(42, Item15); // gray g
            GUI.setItem(43, Item16); // gray g
        }



        GUI.setItem(45, Utils.backArrow());

        p.openInventory(GUI);

    }
}
