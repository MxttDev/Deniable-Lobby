package org.Deniable.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;
import java.util.Map;

public class Glow {


    public static void setGlow(Player p, String color) {
        p.setGlowing(true);
        switch (color) {
            case "GRAY":
                p.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 999, 255));
            case "AQUA":
                System.out.println("hey3");
            case "PINK":
                System.out.println("hey");
            case "RED":
                System.out.println("hey3");
            default:
                throw new IllegalArgumentException("idk it broke");

        }
    }

    public static void removeGlow(Player p) {
        p.setGlowing(false);
        Bukkit.getLogger().info("Player's glow has been removed.");
    }


}
