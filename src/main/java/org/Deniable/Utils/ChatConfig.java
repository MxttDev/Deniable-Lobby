package org.Deniable.Utils;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;

public class ChatConfig {

    public static Lobby plugin = Lobby.getPlugin(Lobby.class);

    static File chatfile;
    static FileConfiguration ChatConfig;

    public static void createChatConfig() {
        chatfile= new File(plugin.getDataFolder(), "chat.yml");
        if (!chatfile.exists()) {
            try {
                chatfile.createNewFile();
                Bukkit.getLogger().info("NEW CHAT CONFIG CREATED!");

            } catch (Exception e) {
                Bukkit.getServer().getConsoleSender().sendMessage("Error creating "+chatfile.getName());
            }
        }
        ChatConfig = YamlConfiguration.loadConfiguration(chatfile);
    }

    public static void load() {
        chatfile = new File(plugin.getDataFolder(), "chat.yml");
        ChatConfig = YamlConfiguration.loadConfiguration(chatfile);
    }

    public static FileConfiguration get() {
        return ChatConfig;
    }

    public static FileConfiguration getConfig(Player p) {
        chatfile = new File(plugin.getDataFolder(), "chat.yml");
        ChatConfig = YamlConfiguration.loadConfiguration(chatfile);
        return ChatConfig;
    }

    public static void save() {
        try {
            ChatConfig.save(chatfile);
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Error saving " + chatfile.getName() + "!");
        }
    }
}
