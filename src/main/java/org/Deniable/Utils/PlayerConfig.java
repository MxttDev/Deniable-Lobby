package org.Deniable.Utils;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class PlayerConfig implements Listener {

    public static Lobby plugin;

    public PlayerConfig(Lobby pl) {
        plugin = pl;
    }
    static File cfile;
    static FileConfiguration Pconfig;
    static File MessageFolder;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        createPlayerConfig(e.getPlayer());


    }



    public static void createPlayerConfig(Player p) {
        MessageFolder = new File(plugin.getDataFolder(), "players");
         cfile= new File(MessageFolder, p.getUniqueId().toString()+".yml");
         if (!plugin.getDataFolder().exists()) {
             plugin.getDataFolder().mkdir();
         }
         if (!MessageFolder.exists()) {
             MessageFolder.mkdirs();
         }
         if (!cfile.exists()) {
             try {
                 cfile.createNewFile();
                 Bukkit.getLogger().info("NEW USER CONFIG CREATED: "+p.getName());


             } catch (Exception e) {
                 Bukkit.getServer().getConsoleSender().sendMessage("Error creating "+cfile.getName());
             }
         }
         Pconfig = YamlConfiguration.loadConfiguration(cfile);
    }

    public static void load(Player p) {
        cfile = new File(MessageFolder, p.getUniqueId().toString() + ".yml");
        Pconfig = YamlConfiguration.loadConfiguration(cfile);
    }

    public static FileConfiguration get() {
        return Pconfig;
    }

    public static FileConfiguration getConfig(Player p) {
        cfile = new File(MessageFolder, p.getUniqueId().toString() + ".yml");
        Pconfig = YamlConfiguration.loadConfiguration(cfile);
        return Pconfig;
    }

    public static void save() {
        try {
            Pconfig.save(cfile);
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Error saving " + cfile.getName() + "!");
        }
    }

}
