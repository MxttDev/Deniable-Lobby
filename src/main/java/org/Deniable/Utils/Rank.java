package org.Deniable.Utils;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Rank {
    Lobby plugin;
    Chat chat = null;

    public Rank(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    public String getRank(Player p) {
        return chat.getPlayerPrefix(p);
    }


}
