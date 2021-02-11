package org.Deniable.Events.Player;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.ChatConfig;
import org.Deniable.Utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class onChat implements Listener {

    Lobby plugin;
    private Chat chat = null;

    public onChat(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler(ignoreCancelled = true)
    public void onChat(AsyncPlayerChatEvent e) {

        String message = e.getMessage();
        String content = ChatConfig.get().getList("Blocked").toString();

        for (String s : ChatConfig.get().getStringList("Blocked")) {
            if (message.contains(s)) {
                message = message.replace(s, "****");
            }
        }


        if (chat.getPrimaryGroup(e.getPlayer()).equals("default")) {
            e.setFormat(Utils.format(plugin.getConfig().getString("System.Chat.Default").replace("<player>", e.getPlayer().getName()).replace("<message>", message)));
        } else {
            e.setFormat(Utils.format(plugin.getConfig().getString("System.Chat.Ranks").replace("<player>", e.getPlayer().getName()).replace("<prefix>", chat.getPlayerPrefix(e.getPlayer())).replace("<message>", message)));
        }
    }
}
