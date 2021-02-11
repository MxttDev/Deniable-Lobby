package org.Deniable.Events.Player;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.PlayerConfig;
import org.Deniable.Utils.Utils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
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

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        Player p = e.getPlayer();

        e.getPlayer().getInventory().clear();
        String ranks = Utils.format(Utils.getPrefix(p)+p.getDisplayName());

        if (PlayerConfig.getConfig(p).getString("Cosmetics.Join.Message") == null) {
            e.setJoinMessage(Utils.format("&7"+Utils.getPrefix(p)+p.getName()+"&b has arrived!"));
        } else {
            e.setJoinMessage(Utils.format(PlayerConfig.getConfig(p).getString("Cosmetics.Join.Message").replace("<Player>", ranks)));
        }



    }
}
