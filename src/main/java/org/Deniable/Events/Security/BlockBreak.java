package org.Deniable.Events.Security;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("Lobby.Build")) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }
}
