package org.Deniable.Events.Player;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onChat implements Listener {

    Lobby plugin;
    private Chat chat = null;

    public onChat(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (chat.getPrimaryGroup(e.getPlayer()).equals("default")) {
            e.setFormat(Utils.format(plugin.getConfig().getString("System.Chat.Default").replace("<player>", e.getPlayer().getName()).replace("<message>", e.getMessage())));
        } else {
            e.setFormat(Utils.format(plugin.getConfig().getString("System.Chat.Ranks").replace("<player>", e.getPlayer().getName()).replace("<prefix>", chat.getPlayerPrefix(e.getPlayer())).replace("<message>", e.getMessage())));
        }
    }
}
