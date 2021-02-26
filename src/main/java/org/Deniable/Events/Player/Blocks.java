package org.Deniable.Events.Player;

import org.Deniable.Utils.Mongo;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Blocks implements Listener {


    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();

        if (Mongo.getData(p).get("Permission Level").equals(4)) {
            if (p.getGameMode() == GameMode.CREATIVE) {
                e.setCancelled(false);
                return;
            }
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void onBuild(BlockPlaceEvent e) {
        Player p = e.getPlayer();

        if (Mongo.getData(p).get("Permission Level").equals(4)) {
            if (p.getGameMode() == GameMode.CREATIVE) {
                e.setCancelled(false);
                return;
            }
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void onTnt(BlockPlaceEvent e) {
        Player p = e.getPlayer();

        if (e.getBlock().equals(Material.TNT)) {
            p.kickPlayer("TNT NOT ALLOWED.");
        }

    }

}
