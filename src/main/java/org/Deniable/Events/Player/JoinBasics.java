package org.Deniable.Events.Player;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.Discord;
import org.Deniable.Utils.Mongo;
import org.Deniable.Utils.Packet;
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
        Player p = e.getPlayer();
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        String PrefixPlayer = Utils.getPrefix(p)+p.getName();

        e.getPlayer().getInventory().clear();

        e.getPlayer().setFoodLevel(20);

        Double X = plugin.getConfig().getDouble("System.Spawn.X");
        Double Y = plugin.getConfig().getDouble("System.Spawn.Y");
        Double Z = plugin.getConfig().getDouble("System.Spawn.Z");

        e.getPlayer().teleport(new Location(e.getPlayer().getWorld(), X, Y, Z, 90, 0));

        Discord.SendMessage("**JOIN** "+e.getPlayer().getName(),e.getPlayer());

        if (!p.hasPlayedBefore()) {
            int num = plugin.getConfig().getInt("System.Joins");
            num++;
            plugin.getConfig().set("Joins", num);
            e.setJoinMessage(Utils.format("&e"+p.getName()+"&7 has joined Deniable for the first time! &e[#"+num+"]"));
            plugin.saveConfig();
        } else {
            String msg = Mongo.getData(p).getString("Join Message").replace("<Player>", PrefixPlayer);

            if (msg != null) {
                e.setJoinMessage(Utils.format(msg));
            } else {
                e.setJoinMessage(Utils.format("&b<Player> has arrived!").replace("<Player>", PrefixPlayer));
            }

        }

        if (!chat.getPrimaryGroup(p).equals("default")) {
            p.setAllowFlight(true);
        }


    }

    @EventHandler(ignoreCancelled = true)
    public void onquit(PlayerQuitEvent e) {
        e.setQuitMessage(Utils.format("&7"+Utils.getPrefix(e.getPlayer())+e.getPlayer().getName()+"&b has quit!"));
        Discord.SendMessage("**LEAVE** "+e.getPlayer().getName(),e.getPlayer());
    }


}
