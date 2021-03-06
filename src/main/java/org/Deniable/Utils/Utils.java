package org.Deniable.Utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Team;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Utils {

    public static HashMap<String, Integer> count = new HashMap<String, Integer>();

    public static Lobby plugin = Lobby.getPlugin(Lobby.class);
    public static Chat chat = plugin.getChat();


    public static void playerConsleCheck(CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Player only command!");
        }
    }

    public static String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void getCount(Player player, String server) {

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerCount");
        out.writeUTF(server);

        player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
    }

    public static int getServerCount(Player p, String server) {
        getCount(p, server);
        if (Utils.count.get(server) != null) {
            return Utils.count.get(server);
        }
        return 0;
    }

    public static String getRank(Player p) {
        String rank;

        if (chat.getPlayerPrefix(p).equals("")) {
            rank = "Default";
        } else {
            rank = chat.getPlayerPrefix(p);
        }

        return rank;
    }

    public static String getDiscord(Player p) { //WIP
        String value;

        value = "Not linked";
        return value;
    }

    public static void serverSend(String server, Player p) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);

        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (IOException eee) {
            Bukkit.getLogger().info("REPORT TO THE DEVELOPERS.");
        }
        Bukkit.getPlayer(p.getUniqueId()).sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
    }

    public static ItemStack backArrow() {
        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemMeta meta = arrow.getItemMeta();
        meta.setDisplayName(Utils.format("&aBack"));

        ArrayList arrowlore = new ArrayList<String>();
        arrowlore.add(Utils.format(""));
        arrowlore.add(Utils.format("&bReturn to the previous menu!"));
        arrowlore.add(Utils.format(""));

        meta.setLore(arrowlore);
        arrow.setItemMeta(meta);

        return arrow;

    }

    public static String getPrefix(Player p) {
        String prefix;
        if (chat.getPrimaryGroup(p.getPlayer()).equals("default")) {
           prefix = "&7";
        } else {
            prefix = chat.getPlayerPrefix(p);
        }
        
        return prefix;
    }


}
