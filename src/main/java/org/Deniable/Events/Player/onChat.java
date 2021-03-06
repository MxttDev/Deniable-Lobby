package org.Deniable.Events.Player;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.ChatConfig;
import org.Deniable.Utils.Discord;
import org.Deniable.Utils.Mongo;
import org.Deniable.Utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
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

    @EventHandler(priority = EventPriority.LOW)
    public void onChat(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        String rank = chat.getPrimaryGroup(e.getPlayer()).toUpperCase();

        String DefaultFormat = plugin.getConfig().getString("System.Chat.Default").replace("<player>", "%1$s");

        String DonorFormat = plugin.getConfig().getString("System.Chat.Ranks").replace("<player>", "%1$s").replace("<prefix>", chat.getPlayerPrefix(e.getPlayer()));

        Discord.SendMessage("**["+rank+"]** "+e.getPlayer().getName()+": "+e.getMessage(), e.getPlayer());

        for (String s : ChatConfig.get().getStringList("Blocked")) {
            if (message.contains(s)) {
                message = message.replace(s, "****");
            }
        }


        if (chat.getPrimaryGroup(e.getPlayer()).equals("default")) {
            e.setFormat(Utils.format(DefaultFormat).replace("<message>", "%2$s"));
            e.setMessage(message);
        } else {
            e.setFormat(Utils.format(DonorFormat).replace("<message>", "%2$s"));

            if (Mongo.permissionLvl.get(e.getPlayer().getUniqueId()) == 4) {
                e.setMessage(Utils.format(message));
            } else {
                e.setMessage(message);
            }
        }
    }
}
