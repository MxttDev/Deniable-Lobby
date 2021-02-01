package org.Deniable.Events.Player;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.Deniable.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Objective;

import java.util.Random;

public class bossBar implements Listener {

    Lobby plugin;
    private Chat chat = null;

    public bossBar(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        createBossbar(e.getPlayer());
    }


    private void createBossbar(Player p) {

        Random ran = new Random();
        int random = ran.nextInt(3); // random number from 0 to 2


        BossBar bossBar = Bukkit.createBossBar(
                Utils.format(plugin.getConfig().getString("Bossbar."+random)),
                BarColor.BLUE,
                BarStyle.SOLID);
        bossBar.addPlayer(p);
    }
}
