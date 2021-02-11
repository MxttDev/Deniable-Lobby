package org.Deniable.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.Map;

public class Glow {


    public static void setGlow(Player p, ChatColor color) {
        p.setGlowing(true);
        Bukkit.getLogger().info("Set color to"+color.toString());
    }

    public static void removeGlow(Player p) {
        p.setGlowing(false);
        Bukkit.getLogger().info("Player's glow has been removed.");
    }


}
