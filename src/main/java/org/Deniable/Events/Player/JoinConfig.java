package org.Deniable.Events.Player;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.PlayerConfig;
import org.Deniable.Utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JoinConfig implements Listener {

    Lobby plugin;
    private Chat chat = null;

    public JoinConfig(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        PlayerConfig.get().set("Player.Name", p.getName());
        PlayerConfig.get().set("Player.UUID", p.getUniqueId().toString());

        if (chat.getPrimaryGroup(e.getPlayer()).equals("default")) {
            PlayerConfig.get().set("Player.Rank", "default");
            PlayerConfig.get().set("Player.Rank.Prefix", "&7default");
            PlayerConfig.save();
        } else {
            PlayerConfig.get().set("Player.Rank", chat.getPrimaryGroup(p));
            PlayerConfig.get().set("Player.Rank.Prefix", chat.getPlayerPrefix(p));
            PlayerConfig.save();
        }

        PlayerConfig.get().set("Player.Social.Discord", Utils.getDiscord(p));

        if (PlayerConfig.get().getString("Stats.FirstJoin.Date") == null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();

            PlayerConfig.get().set("Stats.FirstJoin.Date", formatter.format(date));
            PlayerConfig.save();
        }



    }


}
