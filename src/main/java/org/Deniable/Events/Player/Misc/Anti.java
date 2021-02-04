package org.Deniable.Events.Player.Misc;

import net.milkbowl.vault.chat.Chat;
import org.Deniable.Lobby;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerEditBookEvent;

public class Anti implements Listener {
    Lobby plugin;
    private Chat chat = null;

    public Anti(Lobby main, Chat chat) {
        this.plugin = main;
        this.chat = chat;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        Player p = (Player) e.getEntity();
         if (e.getEntityType() == EntityType.PLAYER) {
            if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
                e.setCancelled(true);
                Double X = plugin.getConfig().getDouble("System.Spawn.X");
                Double Y = plugin.getConfig().getDouble("System.Spawn.Y");
                Double Z = plugin.getConfig().getDouble("System.Spawn.Z");

                p.teleport(new Location(p.getWorld(), X, Y, Z, 180, 0));
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 3.0F, 0.5F);
                p.setHealth(20);
            } else {
                e.setCancelled(true);
            }
        } else {
             e.setCancelled(true);
         }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent e) {
        e.setFoodLevel(20);
        e.setCancelled(true);
    }

    @EventHandler
    public void onLeaveDecay(LeavesDecayEvent e) {
        e.setCancelled(true);
    }

}
