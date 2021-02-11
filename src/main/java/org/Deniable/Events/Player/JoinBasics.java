package org.Deniable.Events.Player;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

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
    }
}
