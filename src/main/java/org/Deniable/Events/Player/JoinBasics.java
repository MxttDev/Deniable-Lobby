package org.Deniable.Events.Player;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;

public class JoinBasics implements Listener {

    Lobby plugin;
    private Chat chat = null;

    public JoinBasics(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().setGameMode(GameMode.ADVENTURE);

        e.getPlayer().getInventory().clear();
        e.getPlayer().setFoodLevel(20);

        Double X = plugin.getConfig().getDouble("System.Spawn.X");
        Double Y = plugin.getConfig().getDouble("System.Spawn.Y");
        Double Z = plugin.getConfig().getDouble("System.Spawn.Z");

        e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), X, Y, Z, 180, 0));
        setPlayerPerms(e.getPlayer());
    }

    @EventHandler(ignoreCancelled = true)
    public void onquit(PlayerQuitEvent e) {
        Permission.put(e.getPlayer().getUniqueId(), 0);
        e.setQuitMessage(Utils.format("&7"+Utils.getPrefix(e.getPlayer())+e.getPlayer().getName()+"&b has quit!"));
    }

    public static HashMap<UUID, Integer> Permission = new HashMap<UUID, Integer>();

    public void setPlayerPerms(Player p) {

        Bukkit.getLogger().info(chat.getPrimaryGroup(p));

        if (chat.getPrimaryGroup(p).equals("default")) {
            Permission.put(p.getUniqueId(), 0);
        }else if (chat.getPrimaryGroup(p).equals("vip")) {
            Permission.put(p.getUniqueId(), 1);
        } else if (chat.getPrimaryGroup(p).equals("elite")) {
            Permission.put(p.getUniqueId(), 2);
        } else if (chat.getPrimaryGroup(p).equals("pro")) {
            Permission.put(p.getUniqueId(), 3);
        } else if (chat.getPrimaryGroup(p).equals("ultra")) {
            Permission.put(p.getUniqueId(), 4);
        } else {
            Permission.put(p.getUniqueId(), 4);
        }

    }



}
