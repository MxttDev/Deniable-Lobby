package org.Deniable.Events.Player;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;

public class Tablist implements Listener {

    Lobby plugin;
    private Chat chat = null;

    public Tablist(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (!chat.getPrimaryGroup(e.getPlayer()).equals("default")) {
            e.getPlayer().setPlayerListName(Utils.format(chat.getPlayerPrefix(e.getPlayer())+e.getPlayer().getDisplayName()));
        } else {
            e.getPlayer().setPlayerListName(Utils.format("&7"+e.getPlayer().getName()));
        }


    }
}
