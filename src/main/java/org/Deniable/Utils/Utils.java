package org.Deniable.Utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class Utils {

    public Lobby plugin;
    private Chat chat = null;
    public static HashMap<String, Integer> count = new HashMap<String, Integer>();

    public Utils(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    public static void playerConsleCheck(CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Player only command!");
        }
    }

    public static String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }


}
