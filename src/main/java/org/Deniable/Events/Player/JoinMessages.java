package org.Deniable.Events.Player;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.Utils;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessages implements Listener {

    Lobby plugin;
    private Chat chat = null;

    public JoinMessages(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().setGameMode(GameMode.ADVENTURE);

        e.getPlayer().getInventory().clear();

        if (chat.getPrimaryGroup(e.getPlayer()).equals("default")) {
            e.setJoinMessage(Utils.format(plugin.getConfig().getString("System.Join.Default").replace("<player>", e.getPlayer().getName())));
        } else {
            e.setJoinMessage(Utils.format(plugin.getConfig().getString("System.Join.Ranks").replace("<player>", e.getPlayer().getDisplayName()).replace("<prefix>", chat.getPlayerPrefix(e.getPlayer()))));
        }
    }
}
