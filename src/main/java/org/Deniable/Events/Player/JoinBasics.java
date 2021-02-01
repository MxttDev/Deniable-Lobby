package org.Deniable.Events.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.Rank;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

import java.util.HashMap;

public class JoinBasics implements Listener {

    Lobby plugin;
    private Chat chat = null;

    public JoinBasics(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().setGameMode(GameMode.ADVENTURE);

        e.getPlayer().getInventory().clear();
    }
}
